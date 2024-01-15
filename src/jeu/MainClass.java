package jeu;

import personnages.Heros;
import personnages.Monstre;
import personnages.Personnage;

public class MainClass {



    public static void main(String[] args) {


        Heros sangoku = new Heros("San Goku", 100,100,10,3,0,0);
        Heros vegeta = new Heros("Vegeta", 90, 90,12,4,0,0);
        Heros sangohan = new Heros("San Gohan", 50, 50, 8,2,0,0);

        Monstre freezer = new Monstre("Freezer", 50,50,9,4,4);
        Monstre cell = new Monstre("Cell",70,70 , 8,4,8);
        Monstre buu = new Monstre("Buu",80,80,7,6,22);

    Combat.combattre(vegeta,freezer );
    Combat.combattre(vegeta,cell);
    Combat.combattre(vegeta,buu);
    }




}
