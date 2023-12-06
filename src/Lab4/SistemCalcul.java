package Lab4;

enum sistemOperare{
    windows, linux
}

public class SistemCalcul extends Echipament{
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private sistemOperare s_operare;

    public SistemCalcul(String denumire, int nr_inv, double pret, String zona_mag, situatieEchipament situatie, String tip_mon, double vit_proc, int c_hdd, sistemOperare s_operare) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.s_operare = s_operare;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public double getVit_proc() {
        return vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public sistemOperare getS_operare() {
        return s_operare;
    }

    public void setS_operare(sistemOperare s_operare) {
        this.s_operare = s_operare;
    }

    @Override
    public String toString() {
        return "SistemCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", s_operare=" + s_operare +
                '}' + super.toString();
    }
}
