package au.id.jackmatthews.jsonresponse.example.mixins;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface AddressMixin {
    @JsonIgnore
    long getId();

    @JsonIgnore
    String getSuburb();

    @JsonProperty
    String getCity();
}