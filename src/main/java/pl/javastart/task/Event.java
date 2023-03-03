package pl.javastart.task;

import pl.javastart.task.ticket.TicketGift;
import pl.javastart.task.ticket.TicketOnline;
import pl.javastart.task.ticket.TicketStandard;

public class Event {
    private String name;

    private Address address;
    private static final int MAX_TICKETS = 200;
    private int onlineTicketCount = 0;
    private final TicketOnline[] ticketOnline = new TicketOnline[MAX_TICKETS];
    private int giftTicketCount = 0;
    private final TicketGift[] ticketGifts = new TicketGift[MAX_TICKETS];
    private int standardTicketCount = 0;
    private final TicketStandard[] ticketStandards = new TicketStandard[MAX_TICKETS];
    private int ticketNumberId = 1;
    private final boolean ticketsAvilable = ticketNumberId <= MAX_TICKETS;

    private final DataReader dataReader = new DataReader();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNewAddress() {
        address = dataReader.readAndCreateAddress();
    }

    public void addOnlineTicket() {
        if (ticketsAvilable) {
            ticketOnline[onlineTicketCount] = dataReader.readAndCreateTicketOnline();
            ticketOnline[onlineTicketCount].setTicketId(ticketNumberId);
            onlineTicketCount++;
            ticketNumberId++;

        }
    }

    public void addGiftTicket() {
        if (ticketsAvilable) {
            ticketGifts[giftTicketCount] = dataReader.readAndCreateTicketGift();
            ticketGifts[giftTicketCount].setTicketId(ticketNumberId);
            giftTicketCount++;
            ticketNumberId++;
        }
    }

    public void addStandardTicket() {
        if (ticketsAvilable) {
            ticketStandards[standardTicketCount] = dataReader.readAndCreateTicketStandard();
            ticketStandards[standardTicketCount].setTicketId(ticketNumberId);
            standardTicketCount++;
            ticketNumberId++;

        }
    }

    public void getStadardTicketInfo() {
        for (int i = 0; i < standardTicketCount; i++) {
            System.out.println(info());
            System.out.println(ticketStandards[i].info());
        }
    }

    public void getOnlineTicketInfo() {
        for (int i = 0; i < onlineTicketCount; i++) {
            System.out.println(info());
            System.out.println(ticketOnline[i].info());
        }
    }

    public void getGiftTicketInfo() {
        for (int i = 0; i < giftTicketCount; i++) {
            System.out.println(info());
            System.out.println(ticketGifts[i].info());
        }
    }

    public String info() {
        return "Nazwa wydarzenia: " + name + address.addressInfo();
    }
}
