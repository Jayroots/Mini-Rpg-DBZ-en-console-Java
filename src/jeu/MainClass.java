package jeu;

import objets.Boutique;
import objets.Equipement;
import objets.Potions;
import personnages.Heros;
import personnages.Monstre;
import sort.CoupSpecial;

import java.util.ArrayList;


public class MainClass {



    public static void main(String[] args) {


        Potions fioleVerte = new Potions(1,"Fiole Verte",10,10,0);
        Potions fioleBleue = new Potions(2,"Fiole Bleue", 20, 40,0);
        Potions fioleRouge = new Potions(3,"Fiole Rouge", 50, 100 ,0);
        Potions fioleViolette = new Potions(4,"Fiole Violette", 100,50,50);
        Potions fioleOrange = new Potions(5, "Fiole Orange",20,0,20);

        Boutique boutiqueDePotions = new Boutique();
        boutiqueDePotions.ajouterPotion(fioleVerte);
        boutiqueDePotions.ajouterPotion(fioleBleue);
        boutiqueDePotions.ajouterPotion(fioleRouge);
        boutiqueDePotions.ajouterPotion(fioleViolette);
        boutiqueDePotions.ajouterPotion(fioleOrange);


        Heros sangoku = new Heros("San Goku", 150,150,20,3,20,40,1,20,20);
        Heros vegeta = new Heros("Vegeta", 130, 130,18,3,40, 40,1,20,20);
        Heros sangohan = new Heros("San Gohan", 100, 100, 13,2,60,40,1,20,20);




        ArrayList<Heros> tableauDesHeros = new ArrayList<>();
        tableauDesHeros.add(sangoku);
        tableauDesHeros.add(vegeta);
        tableauDesHeros.add(sangohan);



        Monstre freezer = new Monstre("Freezer", 90,90,12,4,10,4);
        Monstre cell = new Monstre("Cell",100,100 , 14,4,30,8);
        Monstre buu = new Monstre("Buu",130,130,15,6,70,22);
        Monstre broly = new Monstre("Broly", 200,200,20,6,2,28);
        Monstre beerus = new Monstre("Beerus",150,150,24,10,70,40);


        ArrayList<Monstre> tableauDesMonstres = new ArrayList<>();
        tableauDesMonstres.add(freezer);
        tableauDesMonstres.add(cell);
        tableauDesMonstres.add(buu);
        tableauDesMonstres.add(beerus);
        tableauDesMonstres.add(broly);

        CoupSpecial kamehameha = new CoupSpecial("Kamehameha",5,10);
        CoupSpecial genkidama = new CoupSpecial("Genkidama", 20,40);
        CoupSpecial finalFlash = new CoupSpecial("Final Flash", 7,12);
        CoupSpecial canonGarric = new CoupSpecial("Canon Garric", 3,8);
        CoupSpecial kamehamehaPereFils = new CoupSpecial("Kamehameha Père Fils",15,30);

        sangoku.coupSpeciaux.add(kamehameha);
        sangoku.coupSpeciaux.add(genkidama);
        vegeta.coupSpeciaux.add(canonGarric);
        vegeta.coupSpeciaux.add(finalFlash);
        sangohan.coupSpeciaux.add(kamehameha);
        sangohan.coupSpeciaux.add(kamehamehaPereFils);


        Equipement armureDuSoleil = new Equipement("Armure du Soleil", 0,0,2,0);
        Equipement lameDuSoleil = new Equipement("Lame du Soleil", 5,0,0,0);
        Equipement casqueDuSoleil = new Equipement("Casque du Soleil", 0,0,0,5);
        Equipement amuletteDuSoleil = new Equipement("Amulette du Soleil",0,5,0,0);

        sangoku.inventaireEquipements.put("armure",armureDuSoleil);
        sangoku.inventaireEquipements.put("casque",casqueDuSoleil);
        sangoku.inventaireEquipements.put("amulette",amuletteDuSoleil);
        sangoku.inventaireEquipements.put("arme",lameDuSoleil);

        sangohan.inventaireEquipements.put("armure",armureDuSoleil);
        sangohan.inventaireEquipements.put("casque",casqueDuSoleil);
        sangohan.inventaireEquipements.put("amulette",amuletteDuSoleil);
        sangohan.inventaireEquipements.put("arme",lameDuSoleil);

        vegeta.inventaireEquipements.put("armure",armureDuSoleil);
        vegeta.inventaireEquipements.put("casque",casqueDuSoleil);
        vegeta.inventaireEquipements.put("amulette",amuletteDuSoleil);
        vegeta.inventaireEquipements.put("arme",lameDuSoleil);



        String imageVegeta = "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡏⠛⢿⣿⣿⣿⣿⣿⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠸⠀⠀⠈⠙⢿⣿⣌⢃⠈⠑⠝⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡆⢀⡀⠀⠀⠈⠻⣿⣈⣄⡀⠹⢿⠛⢿⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢁⠟⠀⣠⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡙⢿⣿⣷⠈⣿⣶⣄⢀⠀⠈⢻⣿⣿⣦⡈⠢⡘⡄⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣮⣶⣾⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⡇⠀⠹⣻⡆⢻⣿⣿⣿⣷⣆⠀⠹⣿⠈⢵⡄⠑⡇⡷⠀⠈⠻⠛⣋⣭⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠻⢿⣿⣿⡇⢀⠀⠈⢳⠘⣿⣿⣿⣿⣿⣧⡀⢸⠀⠈⠆⠀⠸⠀⠁⠀⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⢈⣙⣣⠸⣦⠀⠀⢃⢻⣿⣿⣿⣿⣿⡷⡼⠀⠀⠀⠀⠀⢄⣰⠀⠑⡘⡏⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⢿⣿⣆⢿⣧⠘⣶⡆⢿⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⢣⠸⡟⠀⠀⠈⢇⡀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠘⣯⠻⡜⢿⠧⠈⠛⡜⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠡⡇⣾⣷⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠉⠛⠧⠈⠆⠈⠊⠁⠀⠀⠘⡌⠈⠃⠀⠀⡆⢠⣾⣶⣿⣦⠀⢹⣿⣿⡆⠀⣿⢸⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣆⠀⠀⢀⣠⡀⠀⠀⠀⠀⢀⣠⣤⢀⣶⣤⣧⣾⣿⣿⣿⣿⣧⠈⣿⣿⡇⠀⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠤⡀⣾⣿⣧⠀⠀⠀⣈⡻⣿⣿⣷⣻⣿⣿⣿⣿⣿⣿⣿⣿⣆⣿⣿⡇⢰⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⣠⣦⣀⠲⣾⣽⣿⣿⣷⡘⣿⣿⣿⣾⣽⠛⠋⠙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⢫⣏⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢀⣾⣿⣿⣿⣷⣮⣑⢄⠉⣍⣿⣾⣿⣿⣿⡇⠀⠀⠀⠀⠀⠈⠛⣿⣿⣿⣿⣿⡿⠁⠀⠸⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢠⣿⣿⣿⣿⣿⣭⣉⠉⣉⣓⣜⢿⣿⣿⣿⣿⡅⠀⠀⠀⠠⠀⠀⠀⠈⠻⣿⣿⣿⠃⠀⠀⡀⣿⣿⣿⣿⣿⣿⣿⠟⣵⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⢿⣿⡟⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣯⣿⣷⣯⣿⣿⣿⣿⣄⠀⡀⠀⠀⠀⠀⠀⢀⠹⣿⠏⠀⠀⠀⠀⢹⣿⣿⣿⣿⠟⠁⠸⣿⣿⣿⡿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡀⠈⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣤⣐⠶⣿⣿⣟⣷⡝⠟⠁⢁⣀⠀⠀⠀⡄⠈⡷⡈⡴⠀⡀⡠⣂⣿⣿⠿⠋⠁⣀⣀⡀⠉⠉⢉⣾⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣯⣽⣹⣿⡀⠀⠉⠹⡿⢶⣤⡈⠐⠃⠘⠘⣨⠞⡸⡌⠉⠀⠀⣠⣿⣿⣿⣇⠀⢠⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣷⡀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣙⣀⡀⠀⠁⠀⠭⠕⠡⡶⡐⠛⠙⠀⢰⣶⣶⡆⣰⣿⣿⣿⣿⡏⠀⣾⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣷⡀⢻⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⣛⣛⠿⣿⣿⣿⣿⣿⡏⠀⠉⡆⠀⠀⠀⠀⠀⠀⣀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⢻⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣿⣿⣿⣿⡿⠏⠡⡄⠀⡘⠁⠀⠱⣄⠙⣿⣿⣿⡇⠀⡀⢰⢤⡀⠀⠀⠀⠀⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⢰⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠄⢀⠔⠒⠙⡄⢀⠀⠈⢮⣹⣿⣿⡇⠀⠀⢸⠀⡨⠳⣦⣤⣤⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⣨⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠔⠁⠀⡀⠌⠚⢢⠀⠀⠀⠳⡤⠽⡇⠒⠀⠸⣦⣸⣦⣌⣂⢄⠀⠘⠉⠛⣿⣿⣟⡻⢿⣿⣿⠟⠁⣠⣾⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⢈⠀⠀⡠⠔⠱⡀⠈⠀⠘⠁⠁⠀⠀⠰⣿⣦⣤⣤⣄⠨⠍⠒⠔⡉⠀⠈⣛⣿⣶⡬⢃⣴⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣀⢈⣠⡎⠀⡠⠐⠛⠂⢀⡀⠄⠀⠈⠁⠀⠈⠻⠿⠿⠿⠷⠒⠉⠉⣯⣦⣸⣿⠟⠉⣠⣿⠹⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⡿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣾⡆⢰⠀⠀⠀⠀⠠⡀⢀⠈⡐⠁⠀⠀⠀⢀⠀⠀⢠⣀⣤⣴⣿⣿⠟⢁⣤⣾⣿⣿⣦⢹⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣟⣡⣤⣤⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢳⠾⠓⠤⡀⠀⠀⠈⡷⡔⠀⠀⡀⠀⠀⢀⣶⣾⣿⣿⣿⣿⠟⣡⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⡟⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠈⠙⢿⣿⣿⡃⠀⠀⠇⠀⠀⣼⣿⣿⣿⣿⡿⢁⣾⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⠋⡙⢉⣥⣾⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⡄⠉⠉⠛⠛⠛⠉⣁⣨⣿⣿⣿⣿⣶⣶⣤⣶⣾⣿⣯⣤⣶⣶⠖⠛⠉⣱⣿⣿⣿⢏⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣤⣾⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣶⣦⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";


        String imageSangoku = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣶⣦⡄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⣀⣀⣀⡀⢀⠀⢹⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣷⣄⠨⣿⣿⣿⡌⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣷⣿⣿⣿⣿⣿⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣠⣴⣾⣿⣮⣝⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠈⠉⠙⠻⢿⣿⣿⣿⣿⣿⣿⠟⣹⣿⡿⢿⣿⣿⣬⣶⣶⡶⠦⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣀⣢⣙⣻⢿⣿⣿⣿⠎⢸⣿⠕⢹⣿⣿⡿⣛⣥⣀⣀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠈⠉⠛⠿⡏⣿⡏⠿⢄⣜⣡⠞⠛⡽⣸⡿⣟⡋⠉⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠾⠿⣿⠁⠀⡄⠀⠀⠰⠾⠿⠛⠓⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠠⢐⢉⢷⣀⠛⠠⠐⠐⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣀⣠⣴⣶⣿⣧⣾⠡⠼⠎⢎⣋⡄⠆⠀⠱⡄⢉⠃⣦⡤⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠐⠙⠻⢿⣿⣿⣿⣿⣿⣿⣄⡀⠀⢩⠀⢀⠠⠂⢀⡌⠀⣿⡇⠟⠀⠀⢄⠀\n" +
                "⠀⣴⣇⠀⡇⠀⠸⣿⣿⣿⣿⣽⣟⣲⡤⠀⣀⣠⣴⡾⠟⠀⠀⠟⠀⠀⠀⠀⡰⡀\n" +
                "⣼⣿⠋⢀⣇⢸⡄⢻⣟⠻⣿⣿⣿⣿⣿⣿⠿⡿⠟⢁⠀⠀⠀⠀⠀⢰⠀⣠⠀⠰\n" +
                "⢸⣿⡣⣜⣿⣼⣿⣄⠻⡄⡀⠉⠛⠿⠿⠛⣉⡤⠖⣡⣶⠁⠀⠀⠀⣾⣶⣿⠐⡀\n" +
                "⣾⡇⠈⠛⠛⠿⣿⣿⣦⠁⠘⢷⣶⣶⡶⠟⢋⣠⣾⡿⠃⠀⠀⠀⠰⠛⠉⠉⠀⠀";


        String imageSangohan = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⡢⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠐⢶⣒⠢⠤⣀⡀⠀⠀⠀⠠⣄⠀⠀⠀⠀⠀⢹⢻⡌⠳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠻⣷⣄⠑⢮⣕⣢⣄⡀⢹⣿⠢⡀⠀⠀⢸⠈⣿⣆⠹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣷⣄⠙⠻⣿⣯⣷⣯⢧⠈⠲⣄⢸⠀⣿⣿⡄⢹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣧⡀⠙⢿⣿⣿⡎⣇⣧⡈⢺⡀⣿⣿⣷⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣄⠀⠙⢿⣧⠸⣿⣷⡀⢱⣿⣿⣿⡆⢹⠀⣆⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢀⣀⠤⠔⠒⠒⠛⠻⢿⣿⣧⠀⠈⢻⠀⢿⣿⣷⡀⢿⣿⣿⡇⠸⣷⣿⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣀⡤⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀⣠⠬⣙⡣⠄⢸⠀⠸⣿⣿⣷⠘⣿⣿⡇⠀⠿⢹⡷⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠚⠛⠶⠶⣶⣶⣤⣤⣀⡐⠲⢤⣄⣀⠙⠺⢿⣶⣾⠀⠀⢻⣿⣿⡇⢻⣿⡇⠀⢀⣿⣧⣤⣤⣀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠈⢙⣿⣿⣿⣿⣶⣬⣙⣿⠦⠤⠽⠟⣀⠴⠚⠉⢻⣧⠈⢿⣇⣀⠀⠀⣉⣉⡒⠤⣀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⣴⡾⠟⣋⡽⠿⢿⣿⡿⠉⠀⠀⣀⡴⠊⠁⠀⠀⠐⣺⣿⠦⠚⠛⢬⡹⣿⣿⣿⣿⣿⣾⣷⣄\n" +
                "⠀⠀⢀⣴⠗⠁⠀⢈⣠⣤⣴⣶⡟⢠⠄⡴⣫⠞⠁⡀⢀⣤⣒⣭⣿⡿⠔⢦⠀⢸⣷⡘⢿⣿⣟⠋⠉⠉⠙\n" +
                "⠀⢠⣾⠏⣠⣴⣾⣿⣿⣿⣿⡿⢀⡞⢀⣼⡟⠀⡴⠁⣾⡾⠿⠿⢿⣤⣦⢸⠄⣾⣿⣷⡘⣿⡙⢧⡀⠀⠀\n" +
                "⠀⣾⠷⠚⠉⠁⢾⡟⣡⠈⢻⡇⣼⢠⣿⢿⠀⡼⣥⡾⠋⠀⠀⠀⠀⠀⢸⢸⢰⣿⣿⣿⣷⣿⡿⠀⠀⠀⠀\n" +
                "⠈⠁⠀⠀⠀⠀⠀⠉⠣⢄⣀⣷⣿⢸⠇⢸⢸⣱⣟⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣏⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡿⣿⣾⡶⣾⣾⡟⠀⠑⠤⠀⣀⠔⠊⠀⣿⣿⣿⣿⣿⣾⡏⠛⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣇⢹⣿⣇⠹⣿⣿⣗⣄⢀⡀⠀⣠⣴⠮⣿⠟⢱⣿⠃⡾⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢎⢿⣧⠀⠹⠭⠷⠾⠉⢓⠋⠭⠥⠜⠃⠀⣿⢋⠜⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢆⠀⠀⠀⠀⠀⠼⠇⠀⠀⠀⢀⡜⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣱⢤⡀⠀⠉⠟⠃⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⠴⠇⠀⢉⠒⢤⣀⣠⣴⡿⣗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣴⣾⡟⠁⠀⠀⠀⠈⢣⡀⠉⢉⡅⠀⠿⠻⣷⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣤⣴⣾⣿⣿⣿⣿⣿⣿⣆⠀⠀⢀⣈⣦⣙⣄⠀⠀⠀⣤⢀⡨⠝⢿⣿⣿⣷⡆⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠈⣿⠟⠉⠛⢿⣿⣿⣿⣿⣿⣿⣉⠁⠀⠀⠀⠈⠉⠒⠦⠛⠁⠀⠀⠈⣿⣿⣿⣿⠳⡀⠀⠀⠀\n" +
                "⠀⠀⣿⠀⠀⢘⠆⠀⠀⠀⠀⠠⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⢵⠖⠁⠣⠀⠀";



        vegeta.setImage(imageVegeta);
        sangoku.setImage(imageSangoku);
        sangohan.setImage(imageSangohan);




        Jeu.lancerPartie(tableauDesHeros,tableauDesMonstres,boutiqueDePotions);




    }




}
