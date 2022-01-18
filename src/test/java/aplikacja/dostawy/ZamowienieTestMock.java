package aplikacja.dostawy;
import aplikacja.uzytkownik.Uzytkownik;
import mockit.FullVerifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import mockit.Mocked;
import mockit.VerificationsInOrder;
import mockit.Expectations;


public class ZamowienieTestMock {
    @Mocked
    Uzytkownik uzytkownik;

    @Test
    public void testEquals(){
        Uzytkownik uzytkownik2 = new Uzytkownik("John", "Smith", "john@gmail.com", "987654321", false);

        Zamowienie zamowienia[] = {
                new Zamowienie(100, 2000, null, "10", uzytkownik),
                new Zamowienie(100, 2000, null, "11", uzytkownik2)
        };

        for(int i = 0; i < 1; i++) {
            for (int j = i; j < 2; j++) {
                if (j == i) {
                    Assertions.assertTrue(zamowienia[i].equals(zamowienia[i]));
                } else {
                    Assertions.assertFalse(zamowienia[i].equals(zamowienia[j]));
                }
            }
        }

        new VerificationsInOrder(){
            //uzytkownik.equals(any);
        };
    }

}
