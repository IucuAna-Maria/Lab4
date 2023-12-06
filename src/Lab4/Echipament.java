package Lab4;

enum situatieEchipament {
    achizitionat, expus, vandut
}
public class Echipament {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private situatieEchipament situatie;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, situatieEchipament situatie) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = situatie;
    }
    public String getDenumire() {
        return denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public situatieEchipament getSituatie() {
        return situatie;
    }

    public void setSituatie(situatieEchipament situatie) {
        this.situatie = situatie;
    }

    @Override
    public String toString() {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", situatie=" + situatie +
                '}';
    }
}
