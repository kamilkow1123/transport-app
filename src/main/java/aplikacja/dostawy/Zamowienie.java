package aplikacja.dostawy;
import aplikacja.uzytkownik.Uzytkownik;

import java.time.LocalDateTime;

public class Zamowienie {
    private int rozmiarKontenera;
    private float waga;
    private LocalDateTime oczekiwanyCzasDostawy;
    private String numerZamowienia;
    private Uzytkownik zlecajacy;
    private String status;

    public Zamowienie(int rozmiarKontenera, float waga, LocalDateTime oczekiwanyCzasDostawy, String numerZamowienia, Uzytkownik zlecajacy) {
        this.rozmiarKontenera = rozmiarKontenera;
        this.waga = waga;
        this.oczekiwanyCzasDostawy = oczekiwanyCzasDostawy;
        this.numerZamowienia = numerZamowienia;
        this.zlecajacy = zlecajacy;
        this.status = "created";
    }

    public int getRozmiarKontenera() {
        return rozmiarKontenera;
    }

    public void setRozmiarKontenera(int rozmiarKontenera) {
        this.rozmiarKontenera = rozmiarKontenera;
    }

    public float getWaga() {
        return waga;
    }

    public void setWaga(float waga) {
        this.waga = waga;
    }

    public LocalDateTime getOczekiwanyCzasDostawy() {
        return oczekiwanyCzasDostawy;
    }

    public void setOczekiwanyCzasDostawy(LocalDateTime oczekiwanyCzasDostawy) {
        this.oczekiwanyCzasDostawy = oczekiwanyCzasDostawy;
    }

    public String getNumerZamowienia() {
        return numerZamowienia;
    }

    public Uzytkownik getZlecajacy() {
        return zlecajacy;
    }

    public void setZlecajacy(Uzytkownik zlecajacy) {
        this.zlecajacy = zlecajacy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean zmianaStatusu() {
        System.out.println("Nie zmieniam statusu");
        return false;
    }

    @Override
    public String toString(){
        return numerZamowienia + " " + status;
    }
}