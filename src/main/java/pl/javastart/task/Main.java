package pl.javastart.task;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Koncert", "Warszawa", "Online", 100, 0);
        Ticket ticket2 = new Ticket("Koncert", "Warszawa", "Online", 100, 0.1);
        Ticket ticket3 = new Ticket("Koncert", "Warszawa", "Standard", 100, 0);
        Ticket ticket4 = new Ticket("Koncert", "Warszawa", "Standard", 100, 0.1);
        Ticket ticket5 = new Ticket("Koncert", "Warszawa", "Gift", 100, 0);
        Ticket ticket6 = new Ticket("Koncert", "Warszawa", "Gift", 100, 0.1);
        Ticket ticket7 = TicketUtils.addTicket();
        Ticket ticket8 = TicketUtils.addTicket();

        double tiketprice = TicketUtils.getTicketPrice(ticket1);
        System.out.println(tiketprice);

        TicketUtils.ticketInfo(ticket1);
        TicketUtils.ticketInfo(ticket2);
        TicketUtils.ticketInfo(ticket3);
        TicketUtils.ticketInfo(ticket4);
        TicketUtils.ticketInfo(ticket5);
        TicketUtils.ticketInfo(ticket6);
        TicketUtils.ticketInfo(ticket7);
        TicketUtils.ticketInfo(ticket8);
    }
}
