package au.id.jackmatthews.jsonresponse.example;

public class Address {

    private final long id;
    private final String suburb;
    private final String city;

    public Address(long id, String suburb, String city) {
        super();
        this.id = id;
        this.suburb = suburb;
        this.city = city;
    }

    public long getId() {
        return this.id;
    }

    public String getSuburb() {
        return this.suburb;
    }

    public String getCity() {
        return this.city;
    }

}
