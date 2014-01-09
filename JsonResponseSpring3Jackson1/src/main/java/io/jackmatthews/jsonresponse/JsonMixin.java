package io.jackmatthews.jsonresponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JsonMixin {
	public Class<?> target();
	public Class<?> mixin();
}
