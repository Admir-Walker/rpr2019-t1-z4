package ba.unsa.etf.rpr;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {


    @Test
    void dodajArtikl() {
        Supermarket sm = new Supermarket();
        for (int i = 0; i < 1000; i++) {
            sm.dodajArtikl(new Artikl("Test", 1, Integer.toString(i)));
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> sm.dodajArtikl(new Artikl("Test", 1, Integer.toString(1001))));
    }

    @Test
    void izbaciArtiklSaKodom() {
        Artikl artikl = new Artikl("Test", 123, "123");
        Supermarket sm = new Supermarket();
        sm.dodajArtikl(artikl);
        Artikl lazni = new Artikl("Test", 123, "124");
        assertAll(() -> {
            assertEquals(sm.izbaciArtiklSaKodom("123"), artikl);
            assertNotEquals(sm.izbaciArtiklSaKodom("123"), lazni);
        });
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
    // Bolje AfterAll, kada sve metode rade zasebno, pogledati da li rade zajedno kada se primjene
    //@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @AfterAll
    static void integracijskiTest(){
        final Supermarket supermarket = new Supermarket();
        final Korpa korpa = new Korpa();
        supermarket.dodajArtikl(new Artikl("Oreo keks",2,"#123"));
        supermarket.dodajArtikl(new Artikl("Milka sa jagodom",2,"#124"));
        supermarket.dodajArtikl(new Artikl("Olovka",1,"#125"));
        supermarket.dodajArtikl(new Artikl("Miš",22,"#126"));
        supermarket.dodajArtikl(new Artikl("Tastatura",21,"#127"));

        supermarket.izbaciArtiklSaKodom("#126");
        // Opet je artikal tu
        supermarket.dodajArtikl(new Artikl("Miš",22,"#126"));


        korpa.dodajArtikl(supermarket.izbaciArtiklSaKodom("#123"));

        assertAll(() ->{
            assertEquals(2, korpa.dajUkupnuCijenuArtikala());
        });
    }
}