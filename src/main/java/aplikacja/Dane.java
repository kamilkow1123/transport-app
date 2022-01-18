package aplikacja;
import aplikacja.dostawy.Dostawa;
import aplikacja.dostawy.Zamowienie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dane {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String daneZamowien[][] = new String[][]{
            {"500", "12000", "2022-02-01 12:30", "10", null},
            {"400", "14000", "2022-02-02 12:30", "11", null},
            {"300", "16000", "2022-02-03 12:30", "12", null},
            {"200", "18000", "2022-02-04 12:30", "13", null},
            {"100", "20000", "2022-02-05 12:30", "14", null},
    };

    public Zamowienie zamowienia[] = {
        new Zamowienie(500, 12000, LocalDateTime.parse("2022-02-01 12:30", formatter), "10", null ),
        new Zamowienie(400, 14000, LocalDateTime.parse("2022-06-15 12:30", formatter), "11", null ),
        new Zamowienie(300, 16000, LocalDateTime.parse("2022-03-11 12:30", formatter), "11", null )
    };

    public String daneDostaw[][] = new String[][]{
            {"2022-02-06 12:30", "2022-02-15 12:30", "100", "1000", "Gdansk", "Honolulu"},
            {"2022-02-07 12:30", "2022-02-16 12:30", "101", "2000", "Sopot", "Tokio"},
            {"2022-02-08 12:30", "2022-02-17 12:30", "102", "1000", "Gdynia", "Nowy Jork"},
    };

    public Dostawa dostawy[] = {
        new Dostawa(
            LocalDateTime.parse("2022-02-06 12:30", formatter),
            LocalDateTime.parse("2022-02-15 12:30", formatter),
            "100",
            1000,
            "Gdansk",
            "Honolulu"
        ),
        new Dostawa(
            LocalDateTime.parse("2022-02-06 12:30", formatter),
            LocalDateTime.parse("2022-02-15 12:30", formatter),
        "101",
        2000,
        "Tokio",
        "Sopot"
        ),
    };
}
