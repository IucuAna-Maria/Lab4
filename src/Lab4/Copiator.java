package Lab4;

enum formatCopiere {
    A3,A4
}
public class Copiator extends Echipament
{
    private int p_ton;
    private formatCopiere f_copiere;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, situatieEchipament situatie, int p_ton, formatCopiere f_copiere) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.p_ton = p_ton;
        this.f_copiere = f_copiere;
    }

    public int getP_ton() {
        return p_ton;
    }

    public formatCopiere getF_copiere() {
        return f_copiere;
    }

    public void setF_copiere(formatCopiere f_copiere) {
        this.f_copiere = f_copiere;
    }

    @Override
    public String toString() {
        return "Copiator{" +
                "p_ton=" + p_ton +
                ", f_copiere=" + f_copiere +
                '}' + super.toString();
    }
}
