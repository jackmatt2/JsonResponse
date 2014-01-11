package au.id.jackmatthews.jsonresponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JsonResponse {
    public JsonMixin[] mixins();
}
