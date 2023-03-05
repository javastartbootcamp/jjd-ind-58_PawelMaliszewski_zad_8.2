package pl.javastart.task;

import java.util.Scanner;

public class TicketUtils {
    
    private static final Scanner sc = new Scanner(System.in);
    private static final double PACKING_COST = 5;
    private static final double FIVE_PERCENT = 0.05;

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
        System.out.println("Podaj zniżkę");
        discount = sc.nextDouble();
        return new Ticket(eventName, address, type, price, discount);
    }

    public static double getTicketPrice(Ticket ticket) {
        return switch (ticket.getType()) {
            case Ticket.ONLINE_NAME -> getPriceAfterDiscount(ticket);
            case Ticket.STANDARD_NAME -> priceAfterDiscountPlusPacking(ticket);
            case Ticket.GIFT_NAME -> priceAfterDiscountPlusPacking(ticket) + getPriceAfterDiscount(ticket) * FIVE_PERCENT;
            default -> 0;
        };
    }

    private static double getPriceAfterDiscount(Ticket ticket) {
        return ticket.getPrice() - ticket.getPrice() * ticket.getDiscount();
    }

    private static double priceAfterDiscountPlusPacking(Ticket ticket) {
        return getPriceAfterDiscount(ticket) + PACKING_COST;
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
