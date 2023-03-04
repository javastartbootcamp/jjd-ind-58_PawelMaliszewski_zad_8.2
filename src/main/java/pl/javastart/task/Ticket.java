package pl.javastart.task;

public class Ticket {

    public static final String ONLINE_NAME = "Online";
    public static final String STANDARD_NAME = "Standard";
    public static final String GIFT_NAME = "Gift";

    private String eventName;
    private String address;
    private String type;
    private double price = 100;
    private double discount;
    private final int ticketNumber;
    private static int ticketId = 1;

    public Ticket(String eventName, String address, String type, double price, double discount) {
        this.eventName = eventName;
        this.address = address;
        this.type = type;
        this.price = price;
        this.discount = discount;
        ticketNumber = ticketId;
        ticketId++;

    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String showInfo() {
        return "Nazwa wydarzenia: " + eventName
                + ", Adres: " + address
                + ", Bilet: " + typeName()
                + ", Numer Biletu: " + ticketNumber;
    }

    private String typeName() {
        return switch (type) {
            case ONLINE_NAME:
                yield "internetowy";
            case STANDARD_NAME:
                yield "standardowy";
            case GIFT_NAME:
                yield "prezentowy";
            default:
                yield "Błędny typ biletu";
        };
    }
}
