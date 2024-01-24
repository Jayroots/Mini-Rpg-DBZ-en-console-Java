package sort;

import personnages.Heros;

public class CoupSpecial {

    protected String nom;

    protected int coutEnMana;

    protected int puissance;




    public CoupSpecial(String nom, int coutEnMana, int puissance) {
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
