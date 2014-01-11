package au.id.jackmatthews.jsonresponse;

interface ResponseWrapper {

    boolean hasJsonMixins();

    JsonResponse getJsonResponse();

    Object getOriginalResponse();

}
