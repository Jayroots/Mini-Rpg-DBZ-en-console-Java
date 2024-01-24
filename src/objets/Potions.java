package objets;

public class Potions {

    protected int index;

    protected String nom;
    protected int prix ;
    protected int gainDePv;

    protected int gainDeMana;


    public int getGainDeMana() {
        return gainDeMana;
    }

    public void setGainDeMana(int gainDeMana) {
        this.gainDeMana = gainDeMana;
    }

    public Potions(int index, String nom, int prix, int gainDePv, int gainDeMana) {
        this.index = index;
        this.nom = nom;
        this.prix = prix;
        this.gainDePv = gainDePv;
        this.gainDeMana = gainDeMana;
    }

    public Potions(int index, String nom, int prix, int gainDePv) {
        this.index = index;
        this.nom = nom;
        this.prix = prix;
        this.gainDePv = gainDePv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getGainDePv() {
        return gainDePv;
    }

    public void setGainDePv(int gainDePv) {
        this.gainDePv = gainDePv;
    }
}
