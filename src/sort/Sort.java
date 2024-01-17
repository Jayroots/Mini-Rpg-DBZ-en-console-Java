package sort;

public class Sort {

    public String nom;

    public int coutEnMana;

    public int puissance;


    public Sort(String nom, int coutEnMana, int puissance) {
        this.nom = nom;
        this.coutEnMana = coutEnMana;
        this.puissance = puissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoutEnMana() {
        return coutEnMana;
    }

    public void setCoutEnMana(int coutEnMana) {
        this.coutEnMana = coutEnMana;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
