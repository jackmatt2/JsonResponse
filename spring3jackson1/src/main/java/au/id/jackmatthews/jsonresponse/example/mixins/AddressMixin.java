package au.id.jackmatthews.jsonresponse.example.mixins;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public interface AddressMixin {
	@JsonIgnore long getId();
	@JsonIgnore String getSuburb();
    @JsonProperty String getCity();
}