package pl.javastart.task.ticket;

public class TicketGift extends TicketStandard {

    private boolean artistSignature;

    public TicketGift(double discount, boolean artistSignature) {
        this.artistSignature = artistSignature;
        setDiscount(discount);
    }

    public boolean isArtistSignature() {
        return artistSignature;
    }

    public void setArtistSignature(boolean artistSignature) {
        this.artistSignature = artistSignature;
    }

    @Override
    public double price() {
        return FinalData.PRICE_PLUS_FIVE_PERCENT_FOR_SERVICE
                - discountAmount(FinalData.PRICE_PLUS_FIVE_PERCENT_FOR_SERVICE);
    }

    private String signatureInfo() {
        if (artistSignature) {
            return ", Bilet z podpisem artysty";
        }
        return "";
    }

    @Override
    public String ticketName() {
        return FinalData.GIFT_TICKET_NAME;
    }

    public String info() {
        return super.info() + signatureInfo();
    }
}
