package pl.javastart.task.ticket;

public class TicketOnline extends TicketStandard {

    private String emailAddress;

    public TicketOnline(double discount, String emailAddress) {
        setDiscount(discount);
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public double price() {
        return getPrice() - discountAmount(getPrice());
    }

    @Override
    public String ticketName() {
        return FinalData.ONLINE_TICKET_NAME;
    }

    @Override
    public String info() {
        return super.info() + ", Adres email: " + emailAddress;
    }
}
