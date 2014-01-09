package io.jackmatthews.jsonresponse;

final class ResponseWrapperImpl implements ResponseWrapper {

	private final Object originalResponse;
	private final JsonResponse jsonResponse;
	
	
	public ResponseWrapperImpl(Object originalResponse,
			JsonResponse jsonResponse) {
		super();
		this.originalResponse = originalResponse;
		this.jsonResponse = jsonResponse;
	}

	@Override
	public boolean hasJsonMixins() {
		return jsonResponse.mixins().length > 0;
	}
	
	@Override
	public JsonResponse getJsonResponse() {
		return this.jsonResponse;
	}
	
	@Override
	public Object getOriginalResponse() {
		return this.originalResponse;
	}

	
}
