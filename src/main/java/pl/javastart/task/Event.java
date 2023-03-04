package pl.javastart.task;

import pl.javastart.task.ticket.FinalData;
import pl.javastart.task.ticket.TicketStandard;

public class Event {
    private String name;
    private Address address;
    private static final int MAX_TICKETS = 200;

    private final TicketStandard[] ticketStandards = new TicketStandard[MAX_TICKETS];
    private int ticketNumberId = 0;
    private final boolean ticketsAvailable = ticketNumberId <= MAX_TICKETS;

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
        if (ticketsAvailable) {
            ticketStandards[ticketNumberId] = dataReader.readAndCreateTicketOnline();
            ticketStandards[ticketNumberId].setTicketId(ticketNumberId + 1);
            ticketNumberId++;
        }
    }

    public void addGiftTicket() {
        if (ticketsAvailable) {
            ticketStandards[ticketNumberId] = dataReader.readAndCreateTicketGift();
            ticketStandards[ticketNumberId].setTicketId(ticketNumberId + 1);
            ticketNumberId++;
        }
    }

    public void addStandardTicket() {
        if (ticketsAvailable) {
            ticketStandards[ticketNumberId] = dataReader.readAndCreateTicketStandard();
            ticketStandards[ticketNumberId].setTicketId(ticketNumberId + 1);
            ticketNumberId++;

        }
    }

    public void getStadardTicketInfo() {
        for (int i = 0; i < ticketNumberId; i++) {
            if (ticketStandards[i].ticketName() == FinalData.STANDARD_TICKET_NAME) {
                System.out.println(info());
                ticketInfo(i);

            }
        }
    }

    public void getOnlineTicketInfo() {
        for (int i = 0; i < ticketNumberId; i++) {
            if (ticketStandards[i].ticketName() == FinalData.ONLINE_TICKET_NAME) {
                System.out.println(info());
                ticketInfo(i);
            }
        }
    }

    public void getGiftTicketInfo() {
        for (int i = 0; i < ticketNumberId; i++) {
            if (ticketStandards[i].ticketName() == FinalData.GIFT_TICKET_NAME) {
                System.out.println(info());
                ticketInfo(i);
            }
        }
    }

    public String info() {
        return "Nazwa wydarzenia: " + name + address.addressInfo();
    }

    private void ticketInfo(int loopIndex) {
        System.out.println(ticketStandards[loopIndex].info());
    }
}
