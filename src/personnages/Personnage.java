package personnages;

public abstract class Personnage {
    public String nom;
    public int pvMax;
    public int pv = pvMax;
    public int attaque;
    public int armure;

    public int vitesse;




    @Override
    public String toString() {
        return "joueurs.Personnage{" +
                "nom='" + nom + '\'' +
                ", pvMax=" + pvMax +
                ", pv=" + pv +
                ", attaque=" + attaque +
                '}';
    }

    public Personnage() {
    }

    public Personnage(String nom, int pvMax, int pv, int attaque, int armure, int vitesse) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.attaque = attaque;
        this.armure = armure;
        this.vitesse = vitesse;
    }

    public Personnage(String nom, int pvMax, int pv, int attaque, int armure) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.attaque = attaque;
        this.armure = armure;
    }


    public Personnage(String nom, int pvMax, int attaque) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.attaque = attaque;
    }

    public Personnage(String nom, int pvMax, int pv, int attaque) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.attaque = attaque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

}
