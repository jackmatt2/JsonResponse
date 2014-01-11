package au.id.jackmatthews.jsonresponse.example.mixins;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import au.id.jackmatthews.jsonresponse.example.Address;

public interface CustomerMixin {
	@JsonIgnore String getId();
	@JsonIgnore String getName();
    @JsonIgnore String getSurname();
    @JsonProperty String getNickname();
    @JsonProperty Address getAddress();
}