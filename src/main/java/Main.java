import aplikacja.Aplikacja;
import aplikacja.dostawy.Dostawa;
import aplikacja.dostawy.Zamowienie;
import aplikacja.uzytkownik.Uzytkownik;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Aplikacja app = new Aplikacja();

        String str = "2022-02-01 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTimeOdplywu = LocalDateTime.parse(str, formatter);
        str = "2022-02-21 12:30";
        LocalDateTime dateTimePrzyplywu = LocalDateTime.parse(str, formatter);

        Dostawa dostawa1 = new Dostawa(dateTimeOdplywu, dateTimePrzyplywu, "100", 1000, "Gdansk", "Honolulu");
        Dostawa dostawa2 = new Dostawa(dateTimeOdplywu, dateTimePrzyplywu, "101", 2000, "Sopot", "Tokio");

        app.dodajDostawe(dostawa1);

        Dostawa res1 = app.sprawdzCzyDostawaWLiscie(dostawa1);
        System.out.println("Dostawa1 w liscie: " + res1);
        Dostawa res2 = app.sprawdzCzyDostawaWLiscie(dostawa2);
        System.out.println("Dostawa2 w liscie: " + res2);

        str = "2022-02-20 12:30";
        LocalDateTime oczekiwanyCzasDostawy = LocalDateTime.parse(str, formatter);

        Uzytkownik zlecajacy = new Uzytkownik("Artur", "Rejment", "arczik@gmail.pl", "987654321", false);

        Zamowienie zamowienie1 = new Zamowienie(500, 20000, oczekiwanyCzasDostawy, "10", zlecajacy);
        Zamowienie zamowienie2 = new Zamowienie(400, 15000, oczekiwanyCzasDostawy, "11", zlecajacy);
        Zamowienie zamowienie3 = new Zamowienie(300, 12000, oczekiwanyCzasDostawy, "12", zlecajacy);

        app.dodajZamowienie(zamowienie1);
        app.dodajZamowienie(zamowienie2);
        app.dodajZamowienie(zamowienie3);

        boolean czyDodanoZamowienie1 = app.dodajZamowienieDoDostawy(dostawa1, zamowienie1);
        boolean czyDodanoZamowienie2 = app.dodajZamowienieDoDostawy(dostawa1, zamowienie2);
        boolean czyDodanoZamowienie3 = app.dodajZamowienieDoDostawy(dostawa1, zamowienie3);
        System.out.println("\nDodano zamowienie 1? " + czyDodanoZamowienie1);
        System.out.println("Dodano zamowienie 2? " + czyDodanoZamowienie2);
        System.out.println("Dodano zamowienie 3? " + czyDodanoZamowienie3);

        app.zarzadzajZamowieniem("10");
    }
}
