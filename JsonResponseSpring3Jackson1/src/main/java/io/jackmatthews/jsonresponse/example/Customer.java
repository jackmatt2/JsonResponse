package io.jackmatthews.jsonresponse.example;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonView;


public class Customer {

	private long id;
	private String name;
    private String surname;
    private String nickname;
    private Address address;
	
	public Customer(long id, String name, String surname, String nickname,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getNickname() {
		return nickname;
	}

	public Address getAddress() {
		return address;
	}

	public interface SummaryMixin {
		@JsonIgnore String getId();
		@JsonIgnore String getName();
	    @JsonIgnore String getSurname();
	    @JsonProperty String getNickname();
	    @JsonProperty Address getAddress();
	}
    
}
