package Lab4;

enum modTiparire {
    color, alb_negru
}
public class Imprimanta extends Echipament{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private modTiparire m_tiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, situatieEchipament situatie, int ppm, String rezolutie, int p_car, modTiparire m_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.m_tiparire = m_tiparire;
    }

    public int getPpm() {
        return ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public int getP_car() {
        return p_car;
    }

    public modTiparire getM_tiparire() {
        return m_tiparire;
    }

    public void setM_tiparire(modTiparire m_tiparire) {
        this.m_tiparire = m_tiparire;
    }

    @Override
    public String toString() {
        return "Imprimanta{" +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", m_tiparire='" + m_tiparire + '\'' +
                '}' + super.toString();
    }
}
