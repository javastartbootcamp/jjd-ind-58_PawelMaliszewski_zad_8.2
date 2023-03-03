package pl.javastart.task;

import pl.javastart.task.ticket.TicketGift;
import pl.javastart.task.ticket.TicketOnline;
import pl.javastart.task.ticket.TicketStandard;

import java.util.Scanner;

public class DataReader {

    private static final int NO_SIGNATURE = 0;
    private static final int WITH_SIGNATURE = 1;

    private final Scanner sc = new Scanner(System.in);

    String eventName() {
        System.out.println("Wprowadź nazwę wydarzenia");
        return sc.nextLine();
    }

    public TicketStandard readAndCreateTicketStandard() {
        double discount = readAndReturnDiscount();
        return new TicketStandard(discount);
    }

    public Address readAndCreateAddress() {
        System.out.println("Nazwa obiektu");
        String name = sc.nextLine();
        System.out.println("Miasto");
        String city = sc.nextLine();
        System.out.println("Ulica");
        String street = sc.nextLine();
        System.out.println("numer budynku");
        String number = sc.nextLine();
        return new Address(name, city, street, number);
    }

    public TicketOnline readAndCreateTicketOnline() {
        int endLoop  = 0;
        String email1;
        double discount = readAndReturnDiscount();
        do {
            System.out.println("Podaj adres email");
            email1 = sc.nextLine();
            System.out.println("Powtórz adres email");
            String email2 = sc.nextLine();
            if (email1.equals(email2) && email1.contains("@")) {
                endLoop = 1;
            } else {
                System.out.println("Adres email nie jest indentyczy, lub jest niepoprawny");
            }
        } while (endLoop == 0);
        return new TicketOnline(discount, email1);
    }

    public TicketGift readAndCreateTicketGift() {
        boolean signature = false;
        int endLoop  = 0;
        double discount = readAndReturnDiscount();
        do {
            System.out.println(
                    "Bez autografu wpisz: " + NO_SIGNATURE + "\n"
                    + "Z autografem wpisz: " + WITH_SIGNATURE
            );
            int number = sc.nextInt();
            if (number == NO_SIGNATURE) {
                endLoop = 1;
            } else if (number == WITH_SIGNATURE) {
                signature = true;
                endLoop = 1;
            } else {
                System.out.println("Błędny wybór spróbuj jeszcze raz");
            }
        } while (endLoop == 0);
        return new TicketGift(discount, signature);
    }

    double readAndReturnDiscount() {
        double discount = -1;
        boolean isCorect = false;
        do {
            System.out.println("Podaj zniżkę w %");
            discount = sc.nextDouble();
            sc.nextLine();
            if (discount >= 0 && discount <= 100) {
                isCorect = true;
            } else {
                System.out.println("podano niewłaściwą zniżkę, spróbuj ponownie");
            }
        } while (!isCorect);
        return discount;
    }

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public void close() {
        System.out.println("Koniec programu");
        sc.close();
    }
}

