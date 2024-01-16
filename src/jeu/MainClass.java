package jeu;

import boutiqueDePotions.Boutique;
import boutiqueDePotions.Potions;
import personnages.Heros;
import personnages.Monstre;

public class MainClass {



    public static void main(String[] args) {


        Potions fioleVerte = new Potions(1,"Fiole Verte",10,10);
        Potions fioleBleue = new Potions(2,"Fiole Bleue", 20, 40);
        Potions fioleRouge = new Potions(3,"Fiole Rouge", 50, 100 );

        Boutique boutiqueDePotions = new Boutique();
        boutiqueDePotions.ajouterPotion(fioleVerte);
        boutiqueDePotions.ajouterPotion(fioleBleue);
        boutiqueDePotions.ajouterPotion(fioleRouge);





        Heros sangoku = new Heros("San Goku", 100,100,10,3,20,0,1,20);
        Heros vegeta = new Heros("Vegeta", 90, 90,12,4,40, 0,1,20);
        Heros sangohan = new Heros("San Gohan", 50, 50, 8,2,60,0,1,20);

        Monstre freezer = new Monstre("Freezer", 90,90,15,4,50,4);
        Monstre cell = new Monstre("Cell",70,70 , 8,4,30,8);
        Monstre buu = new Monstre("Buu",80,80,7,6,70,22);

    Jeu.combattre(sangoku,freezer,boutiqueDePotions );
    Jeu.combattre(sangoku,cell,boutiqueDePotions);
    Jeu.combattre(sangoku,buu,boutiqueDePotions);





    }




}
