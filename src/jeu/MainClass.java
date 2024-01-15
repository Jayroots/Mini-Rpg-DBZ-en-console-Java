package jeu;

import personnages.Personnage;

public class MainClass {



    public static void main(String[] args) {


        Personnage sangoku = new Personnage("San Goku", 100,100, 10,3);
        Personnage vegeta = new Personnage("Vegeta", 90, 90,12,4);
        Personnage sangohan = new Personnage("San Gohan", 50, 50, 5,2);

    Combat.combattre(sangoku,vegeta);

    }




}
