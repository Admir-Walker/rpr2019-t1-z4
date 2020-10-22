package ba.unsa.etf.rpr;

public class Supermarket {
    private int trenutnoStanje = 0;
    final static int MAX_BROJ_ARTIKALA = 1000;
    private Artikl[] artikli = new Artikl[MAX_BROJ_ARTIKALA];

    public void dodajArtikl(Artikl artikl) {
        if (trenutnoStanje + 1 > MAX_BROJ_ARTIKALA) throw new ArrayIndexOutOfBoundsException("Niz vec popunjen");
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] == null) {
                artikli[i] = artikl;
                break;
            }
        }
        trenutnoStanje = trenutnoStanje + 1;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] != null && artikli[i].getKod().equals(kod)) {
                Artikl kopija = artikli[i];
                artikli[i] = null;
                trenutnoStanje = trenutnoStanje - 1;
                return kopija;
            }
        }
        return null;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }
}
