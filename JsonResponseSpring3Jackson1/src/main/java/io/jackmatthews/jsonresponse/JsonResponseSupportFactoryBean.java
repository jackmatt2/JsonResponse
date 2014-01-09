package io.jackmatthews.jsonresponse;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.google.common.collect.Lists;

/**
 * Modified Spring internal Return value handlers, and wires up a decorator
 * to add support for @JsonResponseView
 * 
 * @author Jack Matthews
 *
 */
public class JsonResponseSupportFactoryBean implements InitializingBean {
	
	Logger log = LoggerFactory.getLogger(JsonResponseSupportFactoryBean.class);

    @Autowired
    private RequestMappingHandlerAdapter adapter;
    
    @Override
    public void afterPropertiesSet() throws Exception {
    	//Spring 4 way
    	//List<HandlerMethodReturnValueHandler> handlers = Lists.newArrayList(adapter.getReturnValueHandlers());
        
    	HandlerMethodReturnValueHandlerComposite returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = Lists.newArrayList(returnValueHandlers.getHandlers());
        
    	decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);
    }
    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor)
            {
                JsonResponseInjectingReturnValueHandler decorator = new JsonResponseInjectingReturnValueHandler(handler);
                int index = handlers.indexOf(handler);
                handlers.set(index, decorator);
                log.info("JsonResponse decorator support wired up");
                break;
            }
        }        
    }

}