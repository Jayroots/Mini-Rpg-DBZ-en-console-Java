package personnages;

import boutiqueDePotions.Potions;
import sort.CoupSpecial;

import java.util.ArrayList;

public class Heros extends Personnage{

    public int experience = 0;

    public int or = 0;

    public int niv = 1;

    public int magie = 20;

    public ArrayList<Potions> potions = new ArrayList<>();

    public ArrayList<CoupSpecial> coupSpeciaux = new ArrayList<>();




    public Heros(){};
    public Heros(int experience, int or) {
        this.experience = experience;
        this.or = or;
    }
    public void lirePotions(){
        for(int i = 0; i < potions.size();i++) {
            System.out.println(potions.get(i).index + " :");
            System.out.println(potions.get(i).nom);
            System.out.println(potions.get(i).prix + " pièces d'or");
            System.out.println("redonne "+ potions.get(i).gainDePv + " points de vie\n");
        }
    }

    public void lireCoupsSpeciaux(Heros joueur){
        for(int i = 0; i < joueur.coupSpeciaux.size();i++) {
            System.out.println(i);
            System.out.println(joueur.coupSpeciaux.get(i).nom);
            System.out.println(joueur.coupSpeciaux.get(i).puissance + " d'attaque");
            System.out.println(joueur.coupSpeciaux.get(i).coutEnMana + " de mana");

        }
    }
    public Heros(String nom, int pvMax, int pv, int attaque, int armure, int vitesse, int or, int niv, int magie) {
        super(nom, pvMax, pv, attaque, armure, vitesse);
        this.or = or;
        this.niv = niv;
        this.magie = magie;
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

    public ArrayList<CoupSpecial> getSorts() {
        return coupSpeciaux;
    }

    public void setSorts(ArrayList<CoupSpecial> coupSpecials) {
        this.coupSpeciaux = coupSpecials;
    }

    public ArrayList<Potions> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potions> potions) {
        this.potions = potions;
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
