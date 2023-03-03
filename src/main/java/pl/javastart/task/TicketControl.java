package pl.javastart.task;

public class TicketControl {
    private static final int Exit = 0;
    private static final int GET_STANDARD_TICKET = 1;
    private static final int GET_ONLINE_TICKET = 2;
    private static final int GET_GIFT_TICKET = 3;
    private static final int STANDARD_TICKETS_INFO = 4;
    private static final int ONLINE_TICKETS_INFO = 5;
    private static final int GIFT_TICKETS_INFO = 6;

    private final Event event = new Event();
    private final DataReader dataReader = new DataReader();

    public void controlLoop() {
        int option;
        event.setName(dataReader.eventName());
        System.out.println("Wyprowadź Adres:");
        event.addNewAddress();
        do {
            printOption();
            option = dataReader.getInt();
            switch (option) {
                case GET_STANDARD_TICKET -> event.addStandardTicket();
                case GET_ONLINE_TICKET -> event.addOnlineTicket();
                case GET_GIFT_TICKET -> event.addGiftTicket();
                case STANDARD_TICKETS_INFO -> event.getStadardTicketInfo();
                case ONLINE_TICKETS_INFO -> event.getOnlineTicketInfo();
                case GIFT_TICKETS_INFO -> event.getGiftTicketInfo();
                case Exit -> dataReader.close();
                default -> System.out.println("Nieprawidłowy Numer");
            }
        } while (option != 0);
    }

    private void printOption() {
        System.out.println("""
                Wybierz:
                ======================================================
                1 aby kupić bilet Standardowy
                2 aby kupić bilet Internetowy
                3 aby kupić bilet Prezentowy
                ------------------------------------------------------
                4 aby wyświetlić informacje o biletach Standardowych
                5 aby wyświetlić informacje o biletach Internetowych
                6 aby wyświetlić informacje o biletach Prezentowych
                ------------------------------------------------------
                0 aby zakończyć program
                ------------------------------------------------------
                """);
    }
}
