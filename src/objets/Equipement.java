package objets;

public class Equipement {
    protected String nom ;
    protected int bonusAttaque;
    protected int bonusMagie;
    protected int bonusArmure;
    protected int bonusPv;

    public int getBonusPv() {
        return bonusPv;
    }

    public void setBonusPv(int bonusPv) {
        this.bonusPv = bonusPv;
    }

    public Equipement(String nom, int bonusAttaque, int bonusMagie, int bonusArmure, int bonusPv) {
        this.nom = nom;
        this.bonusAttaque = bonusAttaque;
        this.bonusMagie = bonusMagie;
        this.bonusArmure = bonusArmure;
        this.bonusPv = bonusPv;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "nom='" + nom + '\'' +
                ", bonusAttaque=" + bonusAttaque +
                ", bonusMagie=" + bonusMagie +
                ", bonusArmure=" + bonusArmure +
                ", bonusPv=" + bonusPv +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public void setBonusAttaque(int bonusAttaque) {
        this.bonusAttaque = bonusAttaque;
    }

    public int getBonusMagie() {
        return bonusMagie;
    }

    public void setBonusMagie(int bonusMagie) {
        this.bonusMagie = bonusMagie;
    }

    public int getBonusArmure() {
        return bonusArmure;
    }

    public void setBonusArmure(int bonusArmure) {
        this.bonusArmure = bonusArmure;
    }
}
