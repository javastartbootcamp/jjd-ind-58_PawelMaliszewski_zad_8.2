package pl.javastart.task.ticket;

public class TicketOnline extends TicketStandard {

    String emailAddress;

    public TicketOnline(double discount, String emailAddress) {
        super(discount);
        this.emailAddress = emailAddress;
    }

    @Override
    public String ticketName() {
        return "Internetowy";
    }

    @Override
    public String info() {
        return super.info() + ", Adres email: " + emailAddress;
    }
}
