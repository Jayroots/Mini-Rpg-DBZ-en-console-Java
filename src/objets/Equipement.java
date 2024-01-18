package objets;

public class Equipement {
    public String nom ;
    public int bonusAttaque;
    public int bonusMagie;
    public int bonusArmure;


    public Equipement(String nom, int bonusAttaque, int bonusMagie, int bonusArmure) {
        this.nom = nom;
        this.bonusAttaque = bonusAttaque;
        this.bonusMagie = bonusMagie;
        this.bonusArmure = bonusArmure;
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
