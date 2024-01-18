package jeu;

import boutiqueDePotions.Boutique;
import boutiqueDePotions.Potions;
import personnages.Heros;
import personnages.Monstre;
import sort.CoupSpecial;

import java.util.ArrayList;

public class MainClass {



    public static void main(String[] args) {


        Potions fioleVerte = new Potions(1,"Fiole Verte",10,10,0);
        Potions fioleBleue = new Potions(2,"Fiole Bleue", 20, 40,0);
        Potions fioleRouge = new Potions(3,"Fiole Rouge", 50, 100 ,0);
        Potions fioleViolette = new Potions(4,"Fiole Violette", 100,0,20);
        Potions fioleOrange = new Potions(5, "Fiole Orange",20,0,20);

        Boutique boutiqueDePotions = new Boutique();
        boutiqueDePotions.ajouterPotion(fioleVerte);
        boutiqueDePotions.ajouterPotion(fioleBleue);
        boutiqueDePotions.ajouterPotion(fioleRouge);
        boutiqueDePotions.ajouterPotion(fioleViolette);
        boutiqueDePotions.ajouterPotion(fioleOrange);

        CoupSpecial kamehameha = new CoupSpecial("Kamehameha",5,10);
        CoupSpecial genkidama = new CoupSpecial("Genkidama", 20,40);
        CoupSpecial finalFlash = new CoupSpecial("Final Flash", 7,12);
        CoupSpecial canonGarric = new CoupSpecial("Canon Garric", 3,8);
        CoupSpecial kamehamehaPereFils = new CoupSpecial("Kamehameha Père Fils",15,30);


        Heros sangoku = new Heros("San Goku", 100,100,15,3,20,100,1,20);
        Heros vegeta = new Heros("Vegeta", 90, 90,12,4,40, 0,1,20);
        Heros sangohan = new Heros("San Gohan", 50, 50, 8,2,60,0,1,20);

        Monstre freezer = new Monstre("Freezer", 90,90,11,4,10,4);
        Monstre cell = new Monstre("Cell",70,70 , 8,4,30,8);
        Monstre buu = new Monstre("Buu",80,80,7,6,70,22);

        ArrayList<Monstre> tableauDesMonstres = new ArrayList<>();
        tableauDesMonstres.add(freezer);
        tableauDesMonstres.add(cell);
        tableauDesMonstres.add(buu);

        sangoku.coupSpeciaux.add(kamehameha);
        sangoku.coupSpeciaux.add(genkidama);
        vegeta.coupSpeciaux.add(canonGarric);
        vegeta.coupSpeciaux.add(finalFlash);
        sangohan.coupSpeciaux.add(kamehameha);
        sangohan.coupSpeciaux.add(kamehamehaPereFils);

    Jeu.lancerPartie(sangoku,tableauDesMonstres,boutiqueDePotions);




    }




}
