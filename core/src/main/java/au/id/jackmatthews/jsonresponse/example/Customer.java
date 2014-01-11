package au.id.jackmatthews.jsonresponse.example;

public class Customer {

    private final long id;
    private final String name;
    private final String surname;
    private final String nickname;
    private final Address address;

    public Customer(long id, String name, String surname, String nickname, Address address) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.address = address;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Address getAddress() {
        return this.address;
    }

}
