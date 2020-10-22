package ba.unsa.etf.rpr;

public class CudnaKlasaZaTestiranje {

    private static Korpa korpa = new Korpa();
    private static Supermarket supermarket = new Supermarket();

    private static void unosArtikalaUMarket() {
        int brojArtikala = 1000;
        // Ako brojAritkala++ baca izuzetak jer ima previse artikala :)
        for (int i = 1; i <= brojArtikala; i++)
            supermarket.dodajArtikl(new Artikl("Magicno jaje", i * 2, Integer.toString(i)));
    }

    public static void ispisArtikala(Artikl[] artikli) {
        for (Artikl a : artikli) {
            if (a != null)
                System.out.println("Naziv: " + a.getNaziv() + ", Kod: " + a.getKod() + ", Cijena: " + a.getCijena() + " KM");
        }
    }

    public static void main(String[] args) {

        unosArtikalaUMarket();
        // Kupovina prvih N artikala, nek je N izmedju [0,50]
        int N = 50;
        for (int i = 1; i <= N; i++) {
            Artikl a = supermarket.izbaciArtiklSaKodom(Integer.toString(i));
            if (a != null && !korpa.dodajArtikl(a)) supermarket.dodajArtikl(a);
        }
        // Ispis prije izbacivanja
        System.out.println("Trenutno stanje artikala: ");
        ispisArtikala(korpa.getArtikli());
        System.out.println("Ukupna cijena je " + korpa.dajUkupnuCijenuArtikala() + " KM.");

        // Izbacivanje prvih M artikala, nek je M izmedju [0,N]
        int M = 15;
        for (int i = 1; i <= M; i++) {
            Artikl a = korpa.izbaciArtiklSaKodom(Integer.toString(i));
            if (a != null) supermarket.dodajArtikl(a);
        }

        // Ispis preostalih artikala u korpi
        System.out.println("Trenutno stanje artikala: ");
        ispisArtikala(korpa.getArtikli());
        System.out.println("Ukupna cijena je " + korpa.dajUkupnuCijenuArtikala() + " KM.");

        // Ispis preostalih artikala u supermarketu
        System.out.println("U supermarketu su preostali: ");
        ispisArtikala(supermarket.getArtikli());

        // Provjera da li je ostao neki artikal koji je kupljen
        boolean uspjeh = true;
        for (int i = M + 1; i <= N; i++) {
            Artikl a = supermarket.izbaciArtiklSaKodom(Integer.toString(i));
            if (a != null) {
                uspjeh = false;
                break;
            }
        }
        if (!uspjeh) System.out.println("Program ne radi kako treba");
    }
}
