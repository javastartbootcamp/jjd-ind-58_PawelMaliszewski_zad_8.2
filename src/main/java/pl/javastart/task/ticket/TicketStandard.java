package pl.javastart.task.ticket;

public class TicketStandard {

    private double price = Price.TICKET_PRICE;
    private double discount;

    private int ticketId;

    public TicketStandard(double discountInPercent) {
        this.discount = discountInPercent;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    private double price() {
        return price - (price * (discount / 100));
    }

    private String discoutInPercent() {
        int percent =  (int) discount;
        return percent + "%, ";
    }

    public String ticketName() {
        return "Standardowy";
    }

    public String info() {
        return "Bilet: " + ticketName() + " Cena: " + price + ", Znizka: " + discoutInPercent() + "Cena po zniżce: "
                + price() + ", Numer biletu: " + getTicketId();
    }
}
