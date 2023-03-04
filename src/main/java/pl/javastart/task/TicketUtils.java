package pl.javastart.task;

import java.util.Scanner;

public class TicketUtils {

    private static final Scanner sc = new Scanner(System.in);

    public static Ticket addTicket() {
        System.out.println("Nazwa wydarzenia:");
        String eventName = sc.nextLine();
        System.out.println("Adres:");
        String address  = sc.nextLine();
        String type = "";
        int option;
        do {
            System.out.println("""
                    Wybierz:
                    1 Internetowy
                    2 Standardowy
                    3 Prezentowy
                    """);
            option = getInt();
            switch (option) {
                case 1 -> type = Ticket.ONLINE_NAME;
                case 2 -> type = Ticket.STANDARD_NAME;
                case 3 -> type = Ticket.GIFT_NAME;
                default -> System.out.println("Błędny numer, spróbuj jeszcze raz");
            }
        } while (!isFromOneToThree(option));
        double price = 100;
        double discount = 0;
        if (option != 2) {
            System.out.println("Podaj zniżkę");
            discount = sc.nextDouble();
        }
        return new Ticket(eventName, address, type, price, discount);
    }

    public static double getTicketPrice(Ticket ticket) {
        return switch (ticket.getType()) {
            case Ticket.ONLINE_NAME -> ticket.getPrice() - (ticket.getPrice() * ticket.getDiscount());
            case Ticket.STANDARD_NAME -> ticket.getPrice() + 5;
            case Ticket.GIFT_NAME -> (ticket.getPrice() + 5) * 1.05 - (ticket.getPrice() * ticket.getDiscount());
            default -> 0;
        };
    }

    private static int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    private static boolean isFromOneToThree(int number) {
        return number >= 1 && number <= 3;
    }

    public static void ticketInfo(Ticket ticket) {
        System.out.println(ticket.showInfo() + ", Cena: " + getTicketPrice(ticket));
    }
}
