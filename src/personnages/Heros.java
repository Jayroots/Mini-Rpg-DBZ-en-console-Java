package personnages;

import objets.Equipement;
import objets.Potions;
import sort.CoupSpecial;
import java.util.ArrayList;
import java.util.HashMap;


public class Heros extends Personnage{

    public int experience = 0;

    public int or = 0;

    public int niv = 1;

    public int magieMax ;
    public int magie = magieMax;



    public ArrayList<Potions> potions = new ArrayList<>();

    public ArrayList<CoupSpecial> coupSpeciaux = new ArrayList<>();

    public HashMap<String, Equipement> inventaireEquipements = new HashMap<>();



    public Heros(){}

    public Heros(int experience, int or) {
        this.experience = experience;
        this.or = or;
    }
    public void lirePotions(){
        for(int i = 0; i < potions.size();i++) {
            System.out.println(i+1);
            System.out.println(potions.get(i).getNom());
            System.out.println(potions.get(i).getPrix() + " pièces d'or");
            System.out.println("redonne "+ potions.get(i).getGainDePv() + " points de vie");
            System.out.println("redonne "+ potions.get(i).getGainDeMana() + " points de magie\n");

        }
    }

    public void lireCoupsSpeciaux(Heros joueur){
        for(int i = 0; i < joueur.coupSpeciaux.size();i++) {
            System.out.println(i+" :");
            System.out.println(joueur.coupSpeciaux.get(i).nom);
            System.out.println(joueur.coupSpeciaux.get(i).puissance + " d'attaque");
            System.out.println(joueur.coupSpeciaux.get(i).coutEnMana + " de mana\n");

        }
    }



    public Heros(String nom, int pvMax, int pv, int attaque, int armure, int vitesse, int or, int niv, int magieMax,int magie) {
        super(nom, pvMax, pv, attaque, armure, vitesse);
        this.or = or;
        this.niv = niv;
        this.magieMax = magieMax;
        this.magie = magie;
    }

    @Override
    public String toString() {
        return "Heros{" +
                "experience=" + experience +
                ", or=" + or +
                ", niv=" + niv +
                ", magieMax=" + magieMax +
                ", magie=" + magie +
                ", potions=" + potions +
                ", coupSpeciaux=" + coupSpeciaux +
                ", inventaireEquipements=" + inventaireEquipements +
                '}';
    }

    public HashMap<String, Equipement> getInventaireEquipements() {
        return inventaireEquipements;
    }

    public void setInventaireEquipements(HashMap<String, Equipement> inventaireEquipements) {
        this.inventaireEquipements = inventaireEquipements;
    }

    public ArrayList<CoupSpecial> getSorts() {
        return coupSpeciaux;
    }

    public int getMagieMax() {
        return magieMax;
    }

    public void setMagieMax(int magieMax) {
        this.magieMax = magieMax;
    }

    public int getMagie() {
        return magie;
    }

    public void setMagie(int magie) {
        this.magie = magie;
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
