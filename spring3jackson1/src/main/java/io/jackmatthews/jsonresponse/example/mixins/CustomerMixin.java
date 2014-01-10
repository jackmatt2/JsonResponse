package io.jackmatthews.jsonresponse.example.mixins;

import io.jackmatthews.jsonresponse.example.Address;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public interface CustomerMixin {
	@JsonIgnore String getId();
	@JsonIgnore String getName();
    @JsonIgnore String getSurname();
    @JsonProperty String getNickname();
    @JsonProperty Address getAddress();
}