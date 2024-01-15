package personnages;

public class Monstre extends Personnage{
    public int niv ;





    public Monstre(){};
    public Monstre(int niv) {
        this.niv = niv;
    }

    public Monstre(String nom, int pvMax, int pv, int attaque, int armure, int niv) {
        super(nom, pvMax, pv, attaque, armure);
        this.niv = niv;
    }

    public Monstre(String nom, int pvMax, int pv, int attaque, int armure, int vitesse, int niv) {
        super(nom, pvMax, pv, attaque, armure, vitesse);
        this.niv = niv;
    }

    public Monstre(String nom, int pvMax, int attaque, int niv) {
        super(nom, pvMax, attaque);
        this.niv = niv;
    }

    public Monstre(String nom, int pvMax, int pv, int attaque, int niv) {
        super(nom, pvMax, pv, attaque);
        this.niv = niv;
    }

    public int getNiv() {
        return niv;
    }

    public void setNiv(int niv) {
        this.niv = niv;
    }
}
