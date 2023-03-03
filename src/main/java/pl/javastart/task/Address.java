package pl.javastart.task;

public class Address {
    private String placeName;
    private String city;
    private String street;
    private String number;

    public Address() {

    }

    public Address(String placeName, String city, String street, String number) {
        this.placeName = placeName;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String addressInfo() {
        return ", Nazwa obiektu: " + placeName + ", Miasto: " + city + ", Ulica: " + street + " " + number;
    }
}
