package aplikacja.uzytkownik;

import aplikacja.dostawy.Zamowienie;
import java.util.List;

public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String email;
    private String numerTelefonu;
    private boolean czyPracownik;

    public Uzytkownik(String imie, String nazwisko, String email, String numerTelefonu, boolean czyPracownik) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.numerTelefonu = numerTelefonu;
        this.czyPracownik = czyPracownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public boolean getCzyPracownik() {
        return czyPracownik;
    }

    public void setCzyPracownik(boolean czyPracownik) {
        this.czyPracownik = czyPracownik;
    }

    public List<Zamowienie> pobierzHistorieZamowien(){return null;}

    @Override
    public boolean equals(Object aUzytkownik){
        Uzytkownik uzytkownik = (Uzytkownik)aUzytkownik;
        return email != uzytkownik.email;
    }
}
