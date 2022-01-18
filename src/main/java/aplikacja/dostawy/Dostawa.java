package aplikacja.dostawy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Dostawa {
    private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();
    private LocalDateTime terminOdplywu;
    private LocalDateTime terminPrzyplywu;
    private String numerDostawy;
    private int maksymalneZapelnienie;
    private int aktualneZapelnienie;
    private String portPoczatkowy;
    private String portDocelowy;

    public Dostawa(LocalDateTime terminOdplywu, LocalDateTime terminPrzyplywu, String numerDostawy, int maksymalneZapelnienie, String portPoczatkowy, String portDocelowy) {
        this.terminOdplywu = terminOdplywu;
        this.terminPrzyplywu = terminPrzyplywu;
        this.numerDostawy = numerDostawy;
        this.maksymalneZapelnienie = maksymalneZapelnienie;
        this.aktualneZapelnienie = 0;
        this.portPoczatkowy = portPoczatkowy;
        this.portDocelowy = portDocelowy;
    }

    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    public LocalDateTime getTerminOdplywu() {
        return terminOdplywu;
    }

    public void setTerminOdplywu(LocalDateTime terminOdplywu) {
        this.terminOdplywu = terminOdplywu;
    }

    public LocalDateTime getTerminPrzyplywu() {
        return terminPrzyplywu;
    }

    public void setTerminPrzyplywu(LocalDateTime terminPrzyplywu) {
        this.terminPrzyplywu = terminPrzyplywu;
    }

    public String getNumerDostawy() {
        return numerDostawy;
    }

    public int getMaksymalneZapelnienie() {
        return maksymalneZapelnienie;
    }

    public void setMaksymalneZapelnienie(int maksymalneZapelnienie) {
        this.maksymalneZapelnienie = maksymalneZapelnienie;
    }

    public int getAktualneZapelnienie() {
        return aktualneZapelnienie;
    }

    public void setAktualneZapelnienie(int aktualneZapelnienie) {
        this.aktualneZapelnienie = aktualneZapelnienie;
    }

    public String getPortPoczatkowy() {
        return portPoczatkowy;
    }

    public void setPortPoczatkowy(String portPoczatkowy) {
        this.portPoczatkowy = portPoczatkowy;
    }

    public String getPortDocelowy() {
        return portDocelowy;
    }

    public void setPortDocelowy(String portDocelowy) {
        this.portDocelowy = portDocelowy;
    }

    public boolean sprawdzMiejsceNaStatku(int rozmiarKontenera){
        if(this.aktualneZapelnienie + rozmiarKontenera <= this.maksymalneZapelnienie){
            return true;
        }
        return false;
    }

    public boolean dodajZamowienieDoDostawy(Zamowienie zamowienie){
        if(this.zamowienia.contains(zamowienie)) return false;

        int rozmiarKontenera = zamowienie.getRozmiarKontenera();
        if(sprawdzMiejsceNaStatku(rozmiarKontenera)){
            this.zamowienia.add(zamowienie);
            this.aktualneZapelnienie += rozmiarKontenera;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return numerDostawy + " " + portPoczatkowy + " " + portDocelowy;
    }
}
