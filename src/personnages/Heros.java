package personnages;

public class Heros extends Personnage{

    public int experience = 0;

    public int or = 0;

    public int niv = 1;


    public Heros(){};
    public Heros(int experience, int or) {
        this.experience = experience;
        this.or = or;
    }

    public Heros(String nom, int pvMax, int pv, int attaque, int armure, int vitesse, int or, int niv) {
        super(nom, pvMax, pv, attaque, armure, vitesse);
        this.or = or;
        this.niv = niv;
    }

    public Heros(String nom, int pvMax, int pv, int attaque, int armure, int experience, int or) {
        super(nom, pvMax, pv, attaque, armure);
        this.experience = experience;
        this.or = or;
    }

    public Heros(String nom, int pvMax, int attaque, int experience, int or) {
        super(nom, pvMax, attaque);
        this.experience = experience;
        this.or = or;
    }

    public Heros(String nom, int pvMax, int pv, int attaque, int experience, int or) {
        super(nom, pvMax, pv, attaque);
        this.experience = experience;
        this.or = or;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }
}
