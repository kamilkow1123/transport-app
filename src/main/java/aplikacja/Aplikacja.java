package aplikacja;

import aplikacja.dostawy.Dostawa;
import aplikacja.dostawy.Zamowienie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Aplikacja {
    private List<Dostawa> dostawy = new ArrayList<Dostawa>();
    private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();

    public List<Dostawa> getDostawy() { return dostawy; }

    public void setDostawy(List<Dostawa> dostawy) { this.dostawy = dostawy; }

    public List<Zamowienie> getZamowienia() { return zamowienia; }

    public void setZamowienia(List<Zamowienie> zamowienia) { this.zamowienia = zamowienia; }

    public void dodajDostawe(Dostawa dostawa){
        this.dostawy.add(dostawa);
    }

    public void dodajZamowienie(Zamowienie zamowienie){
        String tempNr = zamowienie.getNumerZamowienia();
        Zamowienie tempZamowienie = szukajZamowienie(tempNr);
        if(tempZamowienie == null) this.zamowienia.add(zamowienie);
    }

    public void podajDane(int rozmiarKontenera, float waga, LocalDateTime oczekiwanyCzasDostawy, String numerDostawy) {}

    public Dostawa sprawdzCzyDostawaWLiscie(Dostawa dostawa){
        int idx;
        if((idx = dostawy.indexOf(dostawa)) != -1) return dostawy.get(idx);
        return null;
    }

    public Zamowienie szukajZamowienie(String nr){
        for(int i = 0; i < zamowienia.size(); i++){
            Zamowienie tempZamowienie = zamowienia.get(i);
            String tempNr = tempZamowienie.getNumerZamowienia();
            if(tempNr.equals(nr)) return tempZamowienie;
        }
        return null;
    }

    public void zaloguj(){}

    public void zarejestruj(){}

    public void zarzadzajZamowieniem(String numerZamowienia){
        Zamowienie zamowienie = szukajZamowienie(numerZamowienia);
        if(zamowienie == null){
            System.out.println("Nie ma takiego zamowienia");
            return;
        }

        System.out.println("\nSzczegoly zamowienia: ");
        wyswietlSzczegolyZamowienia(zamowienie);

        boolean czyZmieniony = zamowienie.zmianaStatusu();

        if(!czyZmieniony) {
            System.out.println("Status nie zostal zmieniony");
            return;
        }

        poinformujKlienta();
    }

    public void zmienStatusZamowienia(Zamowienie zamowienie){}

    public void zarzadzajDostawa(Dostawa dostawa){}

    public void wyswietlSzczegolyZamowienia(Zamowienie zamowienie){
        System.out.println(zamowienie.toString());
    }

    public void poinformujKlienta(){
        System.out.println("Klient poinformowany");
    }

    public boolean dodajZamowienieDoDostawy(Dostawa dostawa, Zamowienie zamowienie){
        return dostawa.dodajZamowienieDoDostawy(zamowienie);
    }
}
