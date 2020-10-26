package ba.unsa.etf.rpr;

public class Artikl {
    private String naziv;
    private int cijena;
    private String kod;

    public Artikl(String naziv, int cijena, String kod) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.kod = kod;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getCijena() {
        return cijena;
    }

    public String getKod() {
        return kod;
    }

    @Override
    public boolean equals(Object obj) {
        Artikl temp = (Artikl) (obj);

        return this.getNaziv().equals(temp.getNaziv()) &&  this.getCijena() == temp.getCijena() && this.getKod().equals(temp.getKod());
    }
}
