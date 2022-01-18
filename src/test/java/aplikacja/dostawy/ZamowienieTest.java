package aplikacja.dostawy;
import aplikacja.Dane;

import jdk.jfr.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ZamowienieTest {
    static Dane dane;

    @BeforeAll
    public static void setDane(){
        dane = new Dane();
    }

    @Test
    void testWykonajZamowienia() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for(int i = 0; i < 5; i++) {
            Zamowienie zamowienie = new Zamowienie(
                    Integer.parseInt(dane.daneZamowien[i][0]),
                    Float.parseFloat(dane.daneZamowien[i][1]),
                    LocalDateTime.parse(dane.daneZamowien[i][2], formatter),
                    dane.daneZamowien[i][3],
                    null
                    );

           Assertions.assertEquals(zamowienie.getNumerZamowienia(), dane.daneZamowien[i][3]);
        }
    }

    @Test
    void testZmianaStatusu() {
        Zamowienie zamowienie = new Zamowienie(500, 20000, null, "10", null);

        Assertions.assertFalse(zamowienie.zmianaStatusu());
    }
}