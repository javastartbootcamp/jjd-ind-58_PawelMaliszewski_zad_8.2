package pl.javastart.task.ticket;

public class TicketStandard {
    private double discount;
    private final double price = FinalData.TICKET_PRICE;
    private int ticketId;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public double price() {
        return price + FinalData.PACKING_POSTAGE_COST;
    }

    public double discountAmount(double priceAfterCharges) {
        return priceAfterCharges * (getDiscount() / 100);
    }

    public String ticketName() {
        return FinalData.STANDARD_TICKET_NAME;
    }

    public String info() {
        return "Bilet: " + ticketName() + " Cena: " + price() + ", Numer biletu: " + getTicketId();
    }
}
