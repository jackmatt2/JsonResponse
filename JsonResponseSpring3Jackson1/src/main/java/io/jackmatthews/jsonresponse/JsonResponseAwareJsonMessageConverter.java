package io.jackmatthews.jsonresponse;

import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

/**
 * Adds support for {@link JsonResponse} annotation
 * 
 * @author Jack Matthews
 *
 */
public class JsonResponseAwareJsonMessageConverter extends
        MappingJacksonHttpMessageConverter {

    public JsonResponseAwareJsonMessageConverter()
    { 
        super();
        ObjectMapper defaultMapper = new ObjectMapper();
        defaultMapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, true);
        setObjectMapper(defaultMapper);
    }
    
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        if (object instanceof ResponseWrapper)
        {
            writeJson((ResponseWrapper) object, outputMessage);
        } else {
            super.writeInternal(object, outputMessage);
        }
    }
    
    protected void writeJson(ResponseWrapper response, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
    	
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
   
        ObjectMapper mapper = new ObjectMapper();
        
        //Add support for jackson mixins
        JsonMixin[] jsonMixins = response.getJsonResponse().mixins();
        for(int i=0;i<jsonMixins.length;i++) {
        	mapper.getSerializationConfig()
        		.addMixInAnnotations(jsonMixins[i].target(), jsonMixins[i].mixin());
        }
        
        JsonGenerator jsonGenerator =
                mapper.getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);
        try {
            mapper.writeValue(jsonGenerator, response.getOriginalResponse());
        }
        catch (IOException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
    
}
