import aplikacja.Aplikacja;
import aplikacja.Dane;
import aplikacja.dostawy.Dostawa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AplikacjaTest {
    static Dane dane;
    static Aplikacja aplikacja;

    @BeforeAll
    static public void SetUp(){
        aplikacja = new Aplikacja();
        dane = new Dane();
    }

    @Test
    void testDodajDostawe(){
        aplikacja.dodajDostawe(dane.dostawy[0]);
        Assertions.assertEquals(dane.dostawy[0], aplikacja.sprawdzCzyDostawaWLiscie(dane.dostawy[0]));
        Assertions.assertEquals(null, aplikacja.sprawdzCzyDostawaWLiscie(dane.dostawy[1]));
    }

    @Test
    void testDodajZamowienie(){
        aplikacja.dodajZamowienie(dane.zamowienia[0]);
        String nrZamowienia1 = dane.zamowienia[0].getNumerZamowienia();
        String nrZamowienia2 = dane.zamowienia[1].getNumerZamowienia();

        Assertions.assertEquals(dane.zamowienia[0], aplikacja.szukajZamowienie(nrZamowienia1));
        Assertions.assertEquals(null, aplikacja.szukajZamowienie(nrZamowienia2));
    }

    @Test
    void testDodajZamowienieDoDostawy() {
        Dostawa dostawa = dane.dostawy[0];
        Assertions.assertTrue(dostawa.dodajZamowienieDoDostawy(dane.zamowienia[0]));
        Assertions.assertTrue(dostawa.dodajZamowienieDoDostawy(dane.zamowienia[1]));
        Assertions.assertFalse(dostawa.dodajZamowienieDoDostawy(dane.zamowienia[2]));
    }
}
