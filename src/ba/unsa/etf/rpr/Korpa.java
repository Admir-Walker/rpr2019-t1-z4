package ba.unsa.etf.rpr;

public class Korpa {
    private int trenutnoStanje = 0;
    final static int MAX_BROJ_ARTIKALA = 50;
    private Artikl[] artikli = new Artikl[MAX_BROJ_ARTIKALA];

    public boolean dodajArtikl(Artikl a) {
        if (trenutnoStanje + 1 > MAX_BROJ_ARTIKALA) return false; // Indikator da je korpa puna
        boolean dodan = false;
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] == null) {
                artikli[i] = a;
                dodan = true;
                trenutnoStanje = trenutnoStanje + 1;
                break;
            }
        }
        return dodan;
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

    public int dajUkupnuCijenuArtikala() {
        int ukupnaCijena = 0;
        for (Artikl a : artikli) {
            if (a != null) ukupnaCijena = ukupnaCijena + a.getCijena();
        }
        return ukupnaCijena;
    }
}
