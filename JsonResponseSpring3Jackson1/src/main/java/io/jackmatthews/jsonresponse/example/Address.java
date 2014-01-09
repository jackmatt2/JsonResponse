package io.jackmatthews.jsonresponse.example;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonView;


public class Address {

	private long id;
	private String suburb;
    private String city;
    
    public Address(long id, String suburb, String city) {
		super();
		this.id = id;
		this.suburb = suburb;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getSuburb() {
		return suburb;
	}

	public String getCity() {
		return city;
	}

	public interface SummaryMixin {
		@JsonIgnore long getId();
		@JsonIgnore String getSuburb();
	    @JsonProperty String getCity();
	}
    
}
