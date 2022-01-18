package aplikacja.dostawy;

import aplikacja.Dane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DostawaTest {
    static Dane dane;
    static Dostawa dostawa1, dostawa2, dostawa3;

    @BeforeAll
    public static void setUp(){
        dane = new Dane();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        dostawa1 = new Dostawa(
                LocalDateTime.parse(dane.daneDostaw[0][0], formatter),
                LocalDateTime.parse(dane.daneDostaw[0][1], formatter),
                dane.daneDostaw[0][2],
                Integer.parseInt(dane.daneDostaw[0][3]),
                dane.daneDostaw[0][4],
                dane.daneDostaw[0][5]
        );

        dostawa2 = new Dostawa(
                LocalDateTime.parse(dane.daneDostaw[1][0], formatter),
                LocalDateTime.parse(dane.daneDostaw[1][1], formatter),
                dane.daneDostaw[1][2],
                Integer.parseInt(dane.daneDostaw[1][3]),
                dane.daneDostaw[1][4],
                dane.daneDostaw[1][5]
        );

        dostawa3 = new Dostawa(
                LocalDateTime.parse(dane.daneDostaw[2][0], formatter),
                LocalDateTime.parse(dane.daneDostaw[2][1], formatter),
                dane.daneDostaw[2][2],
                Integer.parseInt(dane.daneDostaw[2][3]),
                dane.daneDostaw[2][4],
                dane.daneDostaw[2][5]
        );

    }

    @Test
    void testSprawdzMiejsceNaStatku() {
        dostawa1.setAktualneZapelnienie(800);
        Assertions.assertFalse(dostawa1.sprawdzMiejsceNaStatku(300));
        Assertions.assertTrue(dostawa2.sprawdzMiejsceNaStatku(500));
    }

    @Test
    void testDodajZamowienieDoDostawy() {
        Assertions.assertTrue(dostawa3.dodajZamowienieDoDostawy(dane.zamowienia[0]));
        Assertions.assertTrue(dostawa3.dodajZamowienieDoDostawy(dane.zamowienia[1]));
        Assertions.assertFalse(dostawa3.dodajZamowienieDoDostawy(dane.zamowienia[2]));
    }
}