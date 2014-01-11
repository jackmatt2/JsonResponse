package au.id.jackmatthews.jsonresponse.example.mixins;

import au.id.jackmatthews.jsonresponse.example.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface CustomerMixin {
    @JsonIgnore
    String getId();

    @JsonIgnore
    String getName();

    @JsonIgnore
    String getSurname();

    @JsonProperty
    String getNickname();

    @JsonProperty
    Address getAddress();
}