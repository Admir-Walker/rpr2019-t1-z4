package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void dodajArtikl() {

        Supermarket sm = new Supermarket();
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            sm.dodajArtikl(new Artikl("Test", 1, Integer.toString(i)));
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> sm.dodajArtikl(new Artikl("Test", 1, Integer.toString(1001))));
    }

    @Test
    void izbaciArtiklSaKodom() {
        Artikl artikl = new Artikl("Test", 123, "123");
        Supermarket sm = new Supermarket();
        sm.dodajArtikl(artikl);
        assertEquals(sm.izbaciArtiklSaKodom("123"), artikl);
    }
    @Test
    void izbaciArtiklSaKodom2() {
        Artikl artikl = new Artikl("Test", 123, "123");
        Artikl lazni = new Artikl("Test", 123, "124");
        Supermarket sm = new Supermarket();
        sm.dodajArtikl(artikl);
        assertNotEquals(sm.izbaciArtiklSaKodom("123"), lazni);
    }
    @Test
    void getArtikli() {
        Supermarket sm = new Supermarket();
        sm.dodajArtikl(new Artikl("Test", 123, "123"));
        sm.dodajArtikl(new Artikl("Test", 123, "124"));
        sm.dodajArtikl(new Artikl("Test", 123, "124"));
        Artikl[] artikli = sm.getArtikli();
        int velicina = 0;
        for(Artikl artikl : artikli){
            if(artikl != null) velicina = velicina + 1;
        }
        assertEquals(3, velicina);
    }
}