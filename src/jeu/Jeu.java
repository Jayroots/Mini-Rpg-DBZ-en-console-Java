package jeu;

import objets.Boutique;
import objets.Equipement;
import personnages.Monstre;
import personnages.Heros;
import sort.CoupSpecial;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jeu {


    static boolean combatFini = false;


    public static void lancerPartie(ArrayList<Heros> tableauDesHeros, ArrayList<Monstre> tableauDesMonstres, Boutique boutique) {

        imageAccueil();
        Heros joueur = choixHeros(tableauDesHeros);

        miseEnPlaceEquipement(joueur);

//
//        for (int i = 0; i < 10; i++)
//

        Monstre adversaire1 = genererAdversaire(tableauDesMonstres);
        combattre(joueur, adversaire1, boutique);
        Monstre adversaire2 = genererAdversaire(tableauDesMonstres);
        combattre(joueur, adversaire2, boutique);
        Monstre adversaire3 = genererAdversaire(tableauDesMonstres);
        combattre(joueur, adversaire3, boutique);
        Monstre adversaire4 = genererAdversaire(tableauDesMonstres);
        combattre(joueur, adversaire4, boutique);
        Monstre adversaire5 = genererAdversaire(tableauDesMonstres);
        combattre(joueur, adversaire5, boutique);

    }

    public static void imageAccueil(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⣠⣤⣀⡀⠀⠀⠀⠀⠀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠘⠉⠛⢻⣿⣿⣿⣿⣿⣿⣿⣿⠛⠻⠿⠿⣿⣶⣶⣾⣿⣿⣿⣿⣿⣿⣛⣓⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣷⣤⡀⣀⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⡲⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠉⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠻⠿⣿⣿⣿⣦⣄⡀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⠁⠙⠿⠁⠀⠀⠘⠋⠁⠀⠀⢀⣉⣛⣿⣿⣿⣿⣿⣯⡛⠓⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣦⡀⠀⢀⣼⣿⣿⣿⣿⣿⠿⠿⠿⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠻⢿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⠷⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣦⡀⠀⠀⢀⠀⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠸⣿⣷⣾⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣏⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣷⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠉⠛⢿⣄⠀⠀⠀⠀⠀⠀\n" +
                "⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣾⣿⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠈⠂⠀⠀⠀⠀⠀\n" +
                "⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠈⠛⠛⠋⠙⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠛⠃⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⡏⠀⠀⠀⠀⢸⣿⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣍⠉⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢻⣿⣿⣿⣇⠀⠀⠀⠀⣾⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⠳⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⠀⠀⠀⠀⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠘⣿⣿⠀⠀⠀⠀⢿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠛⠋⠉⠉⠉⠉⠉⠉⠉⠻⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡆⠀⠀⠀⠈⢿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣾⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡗⠉⠻⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣷⡶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⠀⣠⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣿⠟⠋⠀⠀⣠⣴⣾⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀\n" +
                "⠀⠀⠀⣰⣿⣿⣿⣿⡿⠋⠁⠀⣀⣴⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀\n" +
                "⠀⠀⢠⣿⣿⣿⣿⡟⠁⠀⣠⣾⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀\n" +
                "⠀⢀⣿⣿⣿⣿⣿⠁⠀⠀⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀\n" +
                "⠀⣸⣿⣿⣿⣿⣿⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠘⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀\n" +
                "⠀⣿⣿⣿⣿⣿⣿⣧⣀⣀⣀⣸⣿⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠄⠀⠀⠀⠀⠀⠠⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n" +
                "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁\n" +
                "⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠐⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                "⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⣠⣶⣾⣿⣿⣿⡟⠛⣿⣿⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠛⠉⠁⠀⠀⠈⠁⠉⠁⠀\n" +
                "⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣾⣿⠿⠿⠿⠿⢿⡇⠀⠘⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣾⣿⠟⠁⠈⠛⠛⠛⠛⠋⠁⠉⠉⠻⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
                "           BIENVENUE DRAGON BALL Z RPG !!!!!!!!!!!!\n");
    }


    public static void imageSangoku(){
        System.out.println(
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣶⣦⡄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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
        "⣾⡇⠈⠛⠛⠿⣿⣿⣦⠁⠘⢷⣶⣶⡶⠟⢋⣠⣾⡿⠃⠀⠀⠀⠰⠛⠉⠉⠀⠀"

        );
    }

    public static void imageSangohan(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⡢⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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
                "⠀⠀⣿⠀⠀⢘⠆⠀⠀⠀⠀⠠⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⢵⠖⠁⠣⠀⠀");
    }

    public static void imageVegeta(){
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡏⠛⢿⣿⣿⣿⣿⣿⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿\n" +
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
                "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣶⣦⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
    }
    public static Heros choixHeros(ArrayList<Heros> tableauDesHeros) {

        int choixJoueur = 0;

        try {


            System.out.println("\nVoici les héros disponibles :\n");
            for (int i = 0; i < tableauDesHeros.size(); i++) {
                System.out.println("Choix " + i + " => " + tableauDesHeros.get(i).getNom().toUpperCase());
                System.out.println("Attaque : " + tableauDesHeros.get(i).getAttaque());
                System.out.println("Magie : " + tableauDesHeros.get(i).getMagie());
                System.out.println("PV : " + tableauDesHeros.get(i).getPv());
                System.out.println("Armure : " + tableauDesHeros.get(i).getArmure() + "\n");


            }
            System.out.println("Quel héros voulez vous choisir ? ");
            Scanner scan = new Scanner(System.in);
            choixJoueur = scan.nextInt();

            System.out.println("C'est noté ! Vous avez choisi : " + tableauDesHeros.get(choixJoueur).getNom().toUpperCase());
            return tableauDesHeros.get(choixJoueur);

        } catch (Exception e) {
            System.out.println("Erreur de saisie : " + e.getMessage());
            choixHeros(tableauDesHeros);

        }
        return tableauDesHeros.get(choixJoueur);
    }

    public static void miseEnPlaceEquipement(Heros joueur) {

        System.out.println("\nEquipements du Héros :");

        if (joueur.inventaireEquipements.get("casque") == null) {
            System.out.println("Le héros n'a pas de Casque équipé.");
            ;
        } else {

            joueur.setPvMax(joueur.getPvMax() + joueur.inventaireEquipements.get("casque").getBonusPv());
            joueur.setPv(joueur.getPvMax());
            System.out.println("Le casque équipé est le " + joueur.inventaireEquipements.get("casque").getNom() + ".");
        }


        if (joueur.inventaireEquipements.get("arme") == null) {
            System.out.println("Le héros n'a pas d'Arme équipée.");
            ;

        } else {
            joueur.setAttaque(joueur.getAttaque() + joueur.inventaireEquipements.get("arme").getBonusAttaque());
            System.out.println("L'arme équipée est la " + joueur.inventaireEquipements.get("arme").getNom() + ".");
        }


        if (joueur.inventaireEquipements.get("amulette") == null) {
            System.out.println("Le héros n'a pas d'Amulette équipée.");

        } else {
            joueur.setMagieMax(joueur.getMagieMax() + joueur.inventaireEquipements.get("amulette").getBonusMagie());
            joueur.setMagie(joueur.getMagieMax());
            System.out.println("L'amulette équipée est l'" + joueur.inventaireEquipements.get("amulette").getNom() + ".");
        }


        if (joueur.inventaireEquipements.get("armure") == null) {
            System.out.println("Le héros n'a pas d'Armure équipée.");
            ;

        } else {
            joueur.setArmure(joueur.getArmure() + joueur.inventaireEquipements.get("armure").getBonusArmure());
            System.out.println("L'armure équipée est l'" + joueur.inventaireEquipements.get("armure").getNom() + ".");
        }

        System.out.println("\nStatistiques du Héros :\n" +
                "Attaque :" + joueur.getAttaque() + ", Magie :" + joueur.getMagie() + ", Armure: " + joueur.getArmure() + ", Pv : " + joueur.getPv() + "\n");
    }


    public static Monstre genererAdversaire(ArrayList<Monstre> tableau) {
        Random r = new Random();
        int resultatRandom = r.nextInt(tableau.size());


        return tableau.get(resultatRandom);

    }

    public static void combattre(Heros joueur, Monstre adversaire, Boutique boutique) {

        combatFini = false;
        String vainqueur = "";


        System.out.println("Le combat va bientôt commencer contre " + adversaire.getNom().toUpperCase() + " !");

        try {
            Scanner scan = new Scanner(System.in);
            System.out.println(joueur.getNom() + ", veux tu faire un achat dans la boutique OUI (1) ou NON (2) ?");
            int choixBoutique = scan.nextInt();
            switch (choixBoutique) {
                case 1:
                    boutique.lireBoutique();
                    achatPotions(joueur, adversaire, boutique);
                    break;

                case 2:
                    System.out.println("C'est noté ! ");
                    break;

                default:
                    System.out.println("Erreur de saisie ");
                    combattre(joueur, adversaire, boutique);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Saisie Invalide : " + e.getMessage());
        }


        if (joueur.getVitesse() >= adversaire.getVitesse()) {

            joueurCommence(joueur, adversaire);

        } else {

            adversaireCommence(joueur, adversaire);
        }


        if (joueur.getPv() > 0 && !combatFini) vainqueur += joueur.getNom();
        if (adversaire.getPv() > 0 && !combatFini) vainqueur += adversaire.getNom();
        if (!combatFini)
            System.out.println("Le combat est fini ! Le vainqueur est " + vainqueur.toUpperCase() + " !!!\n");


        if (joueur.getPv() > 0 && !combatFini) {

            gainXpEtOr(joueur, adversaire, vainqueur);
            gainNiveau(joueur);
            infoGainDXp(joueur);
            chanceDeGagnerCoupSpecial(joueur);
            chanceDeGagnerEquipement(joueur);

        }

        joueur.setPv(joueur.getPvMax());
        joueur.setMagie(joueur.getMagieMax());
        adversaire.setPv(adversaire.getPvMax());

    }


    public static void joueurCommence(Heros joueur, Monstre adversaire) {
        while (joueur.getPv() > 0 && adversaire.getPv() > 0 && !combatFini) {

            try {
                tourJoueur(joueur, adversaire);

                tourAdversaire(joueur, adversaire);
            } catch (Exception e) {

                System.out.println("Erreur de saisie :" + e.getMessage());
                joueurCommence(joueur, adversaire);

            }
        }
    }

    public static void adversaireCommence(Heros joueur, Monstre adversaire) {
        {
            while (joueur.getPv() > 0 && adversaire.getPv() > 0 && !combatFini) {

                try {

                    tourAdversaire(joueur, adversaire);

                    tourJoueur(joueur, adversaire);


                } catch (Exception e) {

                    System.out.println("Erreur de saisie :" + e.getMessage());
                    joueurCommence(joueur, adversaire);
                }
            }
        }
    }

    public static void tourJoueur(Heros joueur, Monstre adversaire) {
        if (joueur.getPv() > 0 && !combatFini) {

            try {

                Scanner scan = new Scanner(System.in);
                System.out.println(joueur.getNom() + ", veux-tu attaquer (1), fuir (2) utiliser la magie (3) une potion (4) ou un COUP SPECIAL (5) ?");
                System.out.println("(Solde de mana :" + joueur.getMagie() + " )");
                int choix = scan.nextInt();


                switch (choix) {
                    case 1:
                        int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.getAttaque()) + 1) - adversaire.getArmure();

                        if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                        adversaire.setPv(adversaire.getPv() - attaqueAleatoireJoueur);

                        if (adversaire.getPv() <= 0) adversaire.setPv(0);
                        System.out.println(joueur.getNom() + " attaque ! \n" + "BIM ! PV de " + adversaire.getNom() + " = " + adversaire.getPv() + "\n");

                        break;

                    case 2:
                        uneChanceSurDeuxDeFuir(joueur);
                        break;

                    case 3:
                        if (joueur.getMagie() >= 5) {
                            int attaqueAleatoireMagiqueJoueur = ((int) (Math.random() * joueur.getAttaque()) + 1);

                            if (attaqueAleatoireMagiqueJoueur <= 0) attaqueAleatoireMagiqueJoueur = 1;
                            adversaire.setPv(adversaire.getPv() - attaqueAleatoireMagiqueJoueur);

                            if (adversaire.getPv() <= 0) adversaire.setPv(0);
                            System.out.println(joueur.getNom() + " utilise sa magie ! \n" + "BIM ! PV de " + adversaire.getNom() + " = " + adversaire.getPv() + "\n");
                            joueur.setMagie(joueur.getMagie() + 5);
                        } else {
                            System.out.println("Le personnage n'a pas assez de magie (magie : " + joueur.getMagie() + " ) ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }

                        break;

                    case 4:
                        if (joueur.potions.size() != 0) {
                            joueur.lirePotions();
                            System.out.println(joueur.getNom() + ", quelle potion voulez-vous utiliser : la 1ere (1), 2eme (2).. ou annuler l'opération (0) ? ");
                            int choixPotion = scan.nextInt();
                            switch (choixPotion) {

                                case 0:
                                    System.out.println("Vous avez annulé l'utilisation de potions");
                                    joueurCommence(joueur, adversaire);
                                    break;

                                case 1:
                                    joueur.setPv(joueur.getPv() + joueur.potions.getFirst().getGainDePv());
                                    if (joueur.getPv() > joueur.getPvMax()) {
                                        joueur.setPv(joueur.getPvMax());
                                    }
                                    ;
                                    joueur.setMagie(joueur.getMagie() + joueur.potions.getFirst().getGainDeMana());
                                    if (joueur.getMagie() > joueur.getMagieMax()) {
                                        joueur.setMagie(joueur.getMagieMax());
                                    }
                                    ;
                                    System.out.println("Une " + joueur.potions.getFirst().getNom() + " a été utlisée.");
                                    joueur.potions.removeFirst();
                                    System.out.println("Le joueur a maintenant " + joueur.getPv() + " pv et " + joueur.getMagie() + " points de mana");
                                    break;

                                case 2:
                                    if (joueur.potions.get(1) != null) {
                                        joueur.setPv(joueur.getPv() + joueur.potions.get(1).getGainDePv());
                                        if (joueur.getPv() > joueur.getPvMax()) {
                                            joueur.setPv(joueur.getPvMax());
                                        }
                                        ;
                                        joueur.setMagie(joueur.getMagie() + joueur.potions.get(1).getGainDeMana());
                                        if (joueur.getMagie() > joueur.getMagieMax()) {
                                            joueur.setMagie(joueur.getMagieMax());
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(1).getNom() + " a été utlisée.");
                                        joueur.potions.remove(1);
                                        System.out.println("Le joueur a maintenant " + joueur.getPv() + " pv et " + joueur.getMagie() + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;

                                case 3:
                                    if (joueur.potions.get(2) != null) {
                                        joueur.setPv(joueur.getPv() + joueur.potions.get(2).getGainDePv());
                                        if (joueur.getPv() > joueur.getPvMax()) {
                                            joueur.setPv(joueur.getPvMax());
                                        }
                                        ;
                                        joueur.setMagie(joueur.getMagie() + joueur.potions.get(2).getGainDeMana());
                                        if (joueur.getMagie() > joueur.getMagieMax()) {
                                            joueur.setMagie(joueur.getMagieMax());
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(2).getNom() + " a été utlisée.");
                                        joueur.potions.remove(2);
                                        System.out.println("Le joueur a maintenant " + joueur.getPv() + " pv et " + joueur.getMagie() + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;
                                case 4:
                                    if (joueur.potions.get(3) != null) {
                                        joueur.setPv(joueur.getPv() + joueur.potions.get(3).getGainDePv());
                                        if (joueur.getPv() > joueur.getPvMax()) {
                                            joueur.setPv(joueur.getPv() + joueur.getPvMax());
                                        }
                                        ;
                                        joueur.setMagie(joueur.getMagie() + joueur.potions.get(3).getGainDeMana());
                                        if (joueur.getMagie() > joueur.getMagieMax()) {
                                            joueur.setMagie(joueur.getMagieMax());
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(3).getNom() + " a été utlisée.");
                                        joueur.potions.remove(3);
                                        System.out.println("Le joueur a maintenant " + joueur.getPv() + " pv et " + joueur.getMagie() + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;

                                case 5:
                                    if (joueur.potions.get(4) != null) {
                                        joueur.setPv(joueur.getPv() + joueur.potions.get(4).getGainDePv());
                                        if (joueur.getPv() > joueur.getPvMax()) {
                                            joueur.setPv(joueur.getPvMax());
                                        }
                                        ;
                                        joueur.setMagie(joueur.getMagie() + joueur.potions.get(4).getGainDeMana());
                                        if (joueur.getMagie() > joueur.getMagieMax()) {
                                            joueur.setMagie(joueur.getMagieMax());
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(4).getNom() + " a été utlisée.");
                                        joueur.potions.remove(4);
                                        System.out.println("Le joueur a maintenant " + joueur.getPv() + " pv et " + joueur.getMagie() + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;


                                default:
                                    System.out.println("saisie invalide");
                                    joueurCommence(joueur, adversaire);
                                    break;
                            }
                        } else {
                            System.out.println("Le personnage n'a pas de potions ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }
                        break;

                    case 5:
                        joueur.lireCoupsSpeciaux(joueur);

                        System.out.println("Veux-tu utiliser le 1er coup special (0) ou le 2e (1).. ou annuler (9) ?");
                        int choixCoup = scan.nextInt();

                        if (choixCoup == 9) {
                            System.out.println("Vous avez annulé l'utilisation de coup spécial");
                            joueurCommence(joueur, adversaire);
                        }
                        if (joueur.getMagie() >= joueur.coupSpeciaux.get(choixCoup).getCoutEnMana()) {

                            adversaire.setPv(adversaire.getPv() - joueur.coupSpeciaux.get(choixCoup).getPuissance());

                            if (adversaire.getPv() <= 0) adversaire.setPv(0);
                            System.out.println(joueur.getNom().toUpperCase() + " attaque avec son ".toUpperCase() + joueur.coupSpeciaux.get(choixCoup).getNom().toUpperCase() + "! \n" + "BIM ! PV de " + adversaire.getNom() + " = " + adversaire.getPv() + "\n");
                            joueur.setMagie(joueur.getMagie() - joueur.coupSpeciaux.get(choixCoup).getCoutEnMana());
                        } else {
                            System.out.println("Le personnage n'a pas assez de magie (magie : " + joueur.getMagie() + " ) ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }


                        break;

                    default:
                        System.out.println("saisie invalide");
                        joueurCommence(joueur, adversaire);

                }
            } catch (Exception e) {
                System.out.println("Erreur de saisie : " + e.getMessage());
                joueurCommence(joueur, adversaire);
            }

        }
    }

    public static void tourAdversaire(Heros joueur, Monstre adversaire) {
        if (adversaire.getPv() > 0 && !combatFini) {
            int attaqueAleatoireAttaquant = ((int) (Math.random() * adversaire.getAttaque()) + 1) - joueur.getArmure();
            if (attaqueAleatoireAttaquant <= 0) {
                attaqueAleatoireAttaquant = 1;
            }
            joueur.setPv(joueur.getPv() - attaqueAleatoireAttaquant);

            if (joueur.getPv() <= 0) joueur.setPv(0);
            System.out.println(adversaire.getNom() + " attaque ! \n" + "BAM !  PV de " + joueur.getNom() + " = " + joueur.getPv());
        }
    }


    public static void gainXpEtOr(Heros joueur, Monstre adversaire, String vainqueur) {
        joueur.setExperience(joueur.getExperience() + (adversaire.getNiv() * 20));
        int piecesGagnees = (int) Math.pow((int) (Math.random() * (10 + adversaire.getNiv()) + 1), 2);
        joueur.setOr(joueur.getOr() + piecesGagnees);
        joueur.setPv(joueur.getPvMax());
        System.out.println(vainqueur + " a gagné " + adversaire.getNiv() * 20 + " points d'experience et "
                + piecesGagnees + " pièces d'or.\nSon total de pièces s'élève à "
                + joueur.getOr() + " pièces d'or.");

    }

    public static void gainNiveau(Heros joueur) {
        while (joueur.getExperience() >= (10 * Math.pow(joueur.getNiv(), 2))) {
            int xpPourProchainNiveau = 10 * (int) (Math.pow(joueur.getNiv(), 2));
            if (joueur.getExperience() >= xpPourProchainNiveau)
                joueur.setNiv(joueur.getNiv() + 1);
            joueur.setPvMax(joueur.getPvMax() + 20);
            joueur.setAttaque(joueur.getAttaque() + 1);
            joueur.setMagieMax(joueur.getMagieMax() + 10);
            joueur.setArmure(joueur.getArmure() + 1);
            joueur.setExperience(joueur.getExperience() - xpPourProchainNiveau);
        }
    }

    public static void infoGainDXp(Heros joueur) {
        int xpManquantePourProchainNiveau = (int) (10 * Math.pow(joueur.getNiv(), 2)) - joueur.getExperience();
        System.out.println(joueur.getNom() + " est passé niveau " + joueur.getNiv() + ".");
        System.out.println("Voici les nouvelles statistiques de " + joueur.getNom() + " :");
        System.out.println("Attaque : " + joueur.getAttaque());
        System.out.println("Pv Max : " + joueur.getPvMax());
        System.out.println("Magie Max : " + joueur.getMagieMax());
        System.out.println("Armure : " + joueur.getArmure() + "\n");
        System.out.println("Il manque " + xpManquantePourProchainNiveau + " d'xp pour passer au prochain niveau.\n");


    }

    public static void uneChanceSurDeuxDeFuir(Heros joueur) {
        Random r = new Random();
        int resultatTirage = r.nextInt(2);

        combatFini = false;


        if (resultatTirage == 0) {
            System.out.println("Le combat est fini !  " + joueur.getNom() + " a pris la fuite !\n");
            combatFini = true;
        }
        if (resultatTirage == 1) {
            System.out.println("fuite ratée, " + joueur.getNom() + " n'a fait aucun dégât ! Le combat continue..");
        }

    }

    public static void achatPotions(Heros joueur, Monstre adversaire, Boutique boutique) {


        try {
            Scanner scan = new Scanner(System.in);
            System.out.println(
                    "Veux tu acheter une potion parmi la liste ci-dessus ? Votre solde est de " + joueur.getOr() + " pièces d'or." +
                            "\nTape (1), (2), (3), (4), (5) ou aucune (6) ?");
            int choix = scan.nextInt();

            switch (choix) {
                case 1:
                    if (joueur.getOr() >= boutique.getBoutique().getFirst().getPrix()) {
                        joueur.setOr(joueur.getOr() - boutique.getBoutique().getFirst().getPrix());
                        joueur.potions.add(boutique.getBoutique().getFirst());
                        System.out.println("La " + boutique.getBoutique().getFirst().getNom() + " a bien été ajoutée à votre inventaire." +
                                " Votre nouveau solde de pièces est de " + joueur.getOr() + ".");
                        achatPotions(joueur, adversaire, boutique);

                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or. Votre solde est de " + joueur.getOr() + " pièces d'or.");
                        achatPotions(joueur, adversaire, boutique);
                    }
                    break;
                case 2:
                    if (joueur.getOr() >= boutique.getBoutique().get(1).getPrix()) {
                        joueur.setOr(joueur.getOr() - boutique.getBoutique().get(1).getPrix());
                        joueur.potions.add(boutique.getBoutique().get(1));
                        System.out.println("La " + boutique.getBoutique().get(1).getNom() + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.getOr() + ".");
                        achatPotions(joueur, adversaire, boutique);
                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.getOr() + " pièces d'or.");
                        achatPotions(joueur, adversaire, boutique);
                    }

                    break;
                case 3:
                    if (joueur.getOr() >= boutique.getBoutique().get(2).getPrix()) {
                        joueur.setOr(joueur.getOr() - boutique.getBoutique().get(2).getPrix());
                        joueur.potions.add(boutique.getBoutique().get(2));
                        System.out.println("La " + boutique.getBoutique().get(2).getNom() + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.getOr() + ".");
                        achatPotions(joueur, adversaire, boutique);
                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.getOr() + " pièces d'or.");
                        achatPotions(joueur, adversaire, boutique);
                    }
                    break;
                case 4:
                    if (joueur.getOr() >= boutique.getBoutique().get(3).getPrix()) {
                        joueur.setOr(joueur.getOr() - boutique.getBoutique().get(3).getPrix());
                        joueur.potions.add(boutique.getBoutique().get(3));
                        System.out.println("La " + boutique.getBoutique().get(3).getNom() + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.getOr() + ".");
                        achatPotions(joueur, adversaire, boutique);
                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.getOr() + " pièces d'or.");
                        achatPotions(joueur, adversaire, boutique);
                    }
                    break;

                case 5:
                    if (joueur.getOr() >= boutique.getBoutique().get(4).getPrix()) {
                        joueur.setOr(joueur.getOr() - boutique.getBoutique().get(4).getPrix());
                        joueur.potions.add(boutique.getBoutique().get(4));
                        System.out.println("La " + boutique.getBoutique().get(4).getNom() + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.getOr() + ".");
                        achatPotions(joueur, adversaire, boutique);
                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.getOr() + " pièces d'or.");
                        achatPotions(joueur, adversaire, boutique);
                    }
                    break;


                case 6:
                    System.out.println("C'est noté! Nous espérons vous revoir bientôt dans notre boutique :) ");
                    break;

                default:
                    System.out.println("saisie invalide");
                    achatPotions(joueur, adversaire, boutique);
                    break;
            }
        } catch (Exception e) {
            System.out.println("erreur de saisie : " + e.getMessage());
            achatPotions(joueur, adversaire, boutique);
        }
    }

    public static void chanceDeGagnerEquipement(Heros joueur) {
        Random r = new Random();
        int resultatTirage = r.nextInt(101);


        if (resultatTirage <= 50) {
            System.out.println("Dommage ! Le héros n'a gagné aucun équipement .. :( \n");

        } else if (resultatTirage <= 65) {
            Equipement armureLunaire = new Equipement("Armure Lunaire", 0, 0, 5, 0);
            System.out.println("Le héros a gagné une nouvelle armure ! L' " + armureLunaire.getNom() + " !!!");
            joueur.setArmure(joueur.getArmure() - joueur.inventaireEquipements.get("armure").getBonusArmure());
            joueur.inventaireEquipements.put("armure", armureLunaire);
            joueur.setArmure(joueur.getArmure() + joueur.inventaireEquipements.get("armure").getBonusArmure());


        } else if (resultatTirage <= 80) {
            Equipement amuletteLunaire = new Equipement("Amulette Lunaire", 0, 50, 0, 0);
            System.out.println("Le héros a gagné une nouvelle amulette ! L' " + amuletteLunaire.getNom() + " !!!");
            joueur.setMagieMax(joueur.getMagieMax() - joueur.inventaireEquipements.get("amulette").getBonusMagie());
            joueur.inventaireEquipements.put("amulette", amuletteLunaire);
            joueur.setMagieMax(joueur.getMagieMax() + joueur.inventaireEquipements.get("amulette").getBonusMagie());

        } else if (resultatTirage <= 95) {
            Equipement casqueLunaire = new Equipement("Casque Lunaire", 0, 0, 0, 100);
            System.out.println("Le héros a gagné un nouveau casque ! Le " + casqueLunaire.getNom() + " !!!");
            joueur.setPvMax(joueur.getPvMax() - joueur.inventaireEquipements.get("casque").getBonusPv());
            joueur.inventaireEquipements.put("casque", casqueLunaire);
            joueur.setPvMax(joueur.getPvMax() + joueur.inventaireEquipements.get("casque").getBonusPv());

        } else {
            Equipement lameLunaire = new Equipement("Lame Lunaire", 30, 0, 0, 0);
            System.out.println("Le héros a gagné une nouvelle ARME LEGENDAIRE! La " + lameLunaire.getNom() + " !!!");
            joueur.setAttaque(joueur.getAttaque() - joueur.inventaireEquipements.get("arme").getBonusAttaque());
            joueur.inventaireEquipements.put("arme", lameLunaire);
            joueur.setAttaque(joueur.getAttaque() + joueur.inventaireEquipements.get("arme").getBonusAttaque());

        }

        System.out.println("\nNouvelles statistiques du Héros :\n" +
                "Attaque :" + joueur.getAttaque() + ", Magie :" + joueur.getMagieMax() + ", Armure: " + joueur.getArmure() + ", Pv : " + joueur.getPvMax() + "\n");
    }

    public static void chanceDeGagnerCoupSpecial(Heros joueur) {
        Random r = new Random();
        int resultatTirage = r.nextInt(101);


        if (resultatTirage <= 50) {
            System.out.println("Dommage ! Le héros n'a gagné aucun nouveau coup spécial .. :( \n");


        } else if (resultatTirage <= 65) {
            CoupSpecial poingDuDragon = new CoupSpecial("Poing du Dragon", 10, 30);
            System.out.println("Le héros a gagné un nouveau coup spécial ! Le " + poingDuDragon.getNom() + " !!!");
            System.out.println("Puissance : " + poingDuDragon.getPuissance() + ", Coût en mana : " + poingDuDragon.getCoutEnMana());
            if (joueur.coupSpeciaux.stream()
                    .anyMatch(coupSpecial -> coupSpecial.getNom().equals("Poing du Dragon"))
            ) {
                System.out.println("Mais le héros l'avait déjà ! :( \n");
            } else {
                joueur.coupSpeciaux.add(poingDuDragon);
            }


        } else if (resultatTirage <= 80) {
            CoupSpecial meteore = new CoupSpecial("Meteore", 20, 50);
            System.out.println("Le héros a gagné un nouveau coup spécial ! Le " + meteore.getNom() + " !!!");
            System.out.println("Puissance : " + meteore.getPuissance() + ", Coût en mana : " + meteore.getCoutEnMana());
            if (joueur.coupSpeciaux.stream()
                    .anyMatch(coupSpecial -> coupSpecial.getNom().equals("Meteore"))
            ) {
                System.out.println("Mais le héros l'avait déjà ! :( \n");
            } else {
                joueur.coupSpeciaux.add(meteore);
            }

        } else if (resultatTirage <= 95) {
            CoupSpecial bigBang = new CoupSpecial("Big Bang Attack ", 30, 70);
            System.out.println("Le héros a gagné un nouveau coup spécial ! Le " + bigBang.getNom() + " !!!");
            System.out.println("Puissance : " + bigBang.getPuissance() + ", Coût en mana : " + bigBang.getCoutEnMana());
            if (joueur.coupSpeciaux.stream()
                    .anyMatch(coupSpecial -> coupSpecial.getNom().equals("Big Bang Attack "))
            ) {
                System.out.println("Mais le héros l'avait déjà ! :( \n");
            } else {
                joueur.coupSpeciaux.add(bigBang);
            }

        } else {
            CoupSpecial fusion = new CoupSpecial("Fusion Ultime !! ", 50, 100);
            System.out.println("Le héros a gagné un nouveau coup spécial ! Le " + fusion.getNom() + " !!!");
            System.out.println("Puissance : " + fusion.getPuissance() + ", Coût en mana : " + fusion.getCoutEnMana());
            if (joueur.coupSpeciaux.stream()
                    .anyMatch(coupSpecial -> coupSpecial.getNom().equals("Fusion Ultime !! "))
            ) {
                System.out.println("Mais le héros l'avait déjà ! :( \n");
            } else {
                joueur.coupSpeciaux.add(fusion);
            }


        }

    }

}
