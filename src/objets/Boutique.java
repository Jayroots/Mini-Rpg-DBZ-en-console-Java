package objets;

import java.util.ArrayList;

public class Boutique {

    ArrayList<Potions> boutique = new ArrayList<>();

    @Override
    public String toString() {
        return "Boutique{" +
                "boutique=" + boutique +
                '}';
    }
    public void lireBoutique(){
        System.out.println("\nVoici ce que vous propose le marchand : ");
        for(int i = 0; i < boutique.size();i++) {
            System.out.println(boutique.get(i).index + " :");
            System.out.println(boutique.get(i).nom);
            System.out.println(boutique.get(i).prix + " pièces d'or");
            System.out.println("redonne "+ boutique.get(i).gainDePv + " points de vie");
            System.out.println("redonne "+ boutique.get(i).gainDeMana + " points de mana\n");
        }
    }
    public void ajouterPotion(Potions nouvellePotion) {
        boutique.add(nouvellePotion);
    }
    public Boutique (){}
    public Boutique(ArrayList<Potions> boutique) {
        this.boutique = boutique;
    }

    public ArrayList<Potions> getBoutique() {
        return boutique;
    }

    public void setBoutique(ArrayList<Potions> boutique) {
        this.boutique = boutique;
    }


}
