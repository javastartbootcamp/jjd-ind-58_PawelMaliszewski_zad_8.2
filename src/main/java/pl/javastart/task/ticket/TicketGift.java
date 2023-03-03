package pl.javastart.task.ticket;

public class TicketGift extends TicketStandard {

    private static final double ADD_EXTRA_PRICE_FOR_SERVICE = 1.05;

    boolean artistSingature;

    public TicketGift(double discountInPercent, boolean artistSingature) {
        super(discountInPercent);
        this.artistSingature = artistSingature;
        setPrice(Price.TICKET_PRICE * ADD_EXTRA_PRICE_FOR_SERVICE);
    }

    String signatureInfo() {
        if (artistSingature) {
            return ", Bilet z podpisem artysty";
        }
        return "";
    }

    @Override
    public String ticketName() {
        return "Prezentowy";
    }

    public String info() {
        return super.info() + signatureInfo();
    }
}
