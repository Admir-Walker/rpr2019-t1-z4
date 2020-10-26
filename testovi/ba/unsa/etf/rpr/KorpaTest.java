package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    @Test
    void dodajArtikl() {
        Artikl a = new Artikl("Test", 123, "123");
        Korpa k = new Korpa();
        assertTrue(k.dodajArtikl(a));
    }

    @Test
    void dodajArtikl2() {
        Korpa k = new Korpa();
        for (int i = 0; i < 50; i++) k.dodajArtikl(new Artikl("Test", 123, Integer.toString(i)));
        assertFalse(k.dodajArtikl(new Artikl("Test", 123, "51")));
    }

    @Test
    void izbaciArtiklSaKodom() {
        Artikl a = new Artikl("Test", 123, "123");
        Artikl b = new Artikl("Test", 123, "1234");
        Korpa k = new Korpa();
        k.dodajArtikl(a);
        k.dodajArtikl(b);
        assertTrue(a.equals(k.izbaciArtiklSaKodom("123")));
    }

    @Test
    void getArtikli() {
        Artikl a = new Artikl("Test", 123, "123");
        Artikl b = new Artikl("Test", 123, "1234");
        Korpa k = new Korpa();
        k.dodajArtikl(a);
        k.dodajArtikl(b);
        int velicina = 0;
        for (Artikl artikl : k.getArtikli()) if (artikl != null) velicina = velicina + 1;
        assertEquals(2,velicina);
    }

    @Test
    void dajUkupnuCijenuArtikala() {
        Artikl a = new Artikl("Test", 100, "123");
        Artikl b = new Artikl("Test", 99, "1234");
        Korpa k = new Korpa();
        k.dodajArtikl(a);
        k.dodajArtikl(b);
        assertEquals(a.getCijena()+b.getCijena(), k.dajUkupnuCijenuArtikala());
    }
}