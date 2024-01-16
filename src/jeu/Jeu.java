package jeu;

import boutiqueDePotions.Boutique;
import personnages.Monstre;
import personnages.Heros;

import java.util.Random;
import java.util.Scanner;

public class Jeu {


    static boolean combatFini = false;

    public static void combattre(Heros joueur, Monstre adversaire, Boutique boutique) {

        combatFini = false;
        String vainqueur = "";

        achatPotions(joueur,boutique);

        if (joueur.vitesse > adversaire.vitesse) {
            joueurCommence(joueur, adversaire);
        } else {
            adversaireCommence(joueur, adversaire);
        }


        if (joueur.pv > 0 && !combatFini) vainqueur += joueur.nom;
        if (adversaire.pv > 0 && !combatFini) vainqueur += adversaire.nom;
        if (!combatFini)
            System.out.println("Le combat est fini ! Le vainqueur est " + vainqueur.toUpperCase() + " !!!\n");


        if (joueur.pv > 0 && !combatFini) {
            gainXpEtOr(joueur, adversaire, vainqueur);
            gainNiveau(joueur);
            infoGainDXp(joueur);
        }
        joueur.pv = joueur.pvMax;
        joueur.magie = 20;
    }


    public static void joueurCommence(Heros joueur, Monstre adversaire) {
        while (joueur.pv > 0 && adversaire.pv > 0 && !combatFini) {


            if (joueur.pv > 0 && !combatFini) {

                Scanner scan = new Scanner(System.in);
                System.out.println(joueur.nom + ", veux-tu attaquer (1), fuir (2) ou utiliser la magie (3) ?");
                int choix = scan.nextInt();


                switch (choix) {
                    case 1:
                        int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.attaque) + 1) - adversaire.armure;

                        if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                        adversaire.pv -= attaqueAleatoireJoueur;

                        if (adversaire.pv <= 0) adversaire.pv = 0;
                        System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");

                        break;

                    case 2:
                        uneChanceSurDeuxDeFuir(joueur);
                        break;

                    case 3:
                        if (joueur.magie >= 5){
                            int attaqueAleatoireMagiqueJoueur = ((int) (Math.random() * joueur.attaque) + 1);

                            if (attaqueAleatoireMagiqueJoueur <= 0) attaqueAleatoireMagiqueJoueur = 1;
                            adversaire.pv -= attaqueAleatoireMagiqueJoueur;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                            joueur.magie -= 5;
                        } else {
                            System.out.println("Le personnage n'a plus de magie ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }

                        break;

                    default:
                        System.out.println("saisie invalide");
                        joueurCommence(joueur, adversaire);

                }


            }


            if (adversaire.pv > 0 && !combatFini) {
                int attaqueAleatoireAttaquant = ((int) (Math.random() * adversaire.attaque) + 1) - joueur.armure;
                if (attaqueAleatoireAttaquant <= 0) {
                    attaqueAleatoireAttaquant = 1;
                }
                joueur.pv -= attaqueAleatoireAttaquant;

                if (joueur.pv <= 0) joueur.pv = 0;
                System.out.println(adversaire.nom + " attaque ! \n" + "BAM !  PV de " + joueur.nom + " = " + joueur.pv);
            }

        }
    }

    public static void adversaireCommence(Heros joueur, Monstre adversaire) {
        {
            while (joueur.pv > 0 && adversaire.pv > 0 && !combatFini) {

                if (adversaire.pv > 0 && !combatFini) {
                    int attaqueAleatoireAttaquant = ((int) (Math.random() * adversaire.attaque) + 1) - joueur.armure;
                    if (attaqueAleatoireAttaquant <= 0) {
                        attaqueAleatoireAttaquant = 1;
                    }
                    joueur.pv -= attaqueAleatoireAttaquant;

                    if (joueur.pv <= 0) joueur.pv = 0;
                    System.out.println(adversaire.nom + " attaque ! \n" + "BAM !  PV de " + joueur.nom + " = " + joueur.pv);
                }

                if (joueur.pv > 0 && !combatFini) {

                    Scanner scan = new Scanner(System.in);
                    System.out.println(joueur.nom + ", veux-tu attaquer (1), fuir (2) ou utiliser la magie (3)  ?");
                    int choix = scan.nextInt();

                    switch (choix) {

                        case 1:

                            int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.attaque) + 1) - adversaire.armure;

                            if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                            adversaire.pv -= attaqueAleatoireJoueur;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");

                            break;

                        case 2:
                            uneChanceSurDeuxDeFuir(joueur);
                            break;

                        case 3:
                            if (joueur.magie >= 5){
                                int attaqueAleatoireMagiqueJoueur = ((int) (Math.random() * joueur.attaque) + 1);

                                if (attaqueAleatoireMagiqueJoueur <= 0) attaqueAleatoireMagiqueJoueur = 1;
                                adversaire.pv -= attaqueAleatoireMagiqueJoueur;

                                if (adversaire.pv <= 0) adversaire.pv = 0;
                                System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                                joueur.magie -= 5;
                            } else {
                                System.out.println("Le personnage n'a plus de magie ! Saisir une autre action :");
                                joueurCommence(joueur, adversaire);
                            }
                            break;

                        default:
                            System.out.println("saisie invalide");
                            joueurCommence(joueur, adversaire);


                    }

                }

            }
        }
    }

    public static void gainXpEtOr(Heros joueur, Monstre adversaire, String vainqueur) {
        joueur.experience += adversaire.niv * 20;
        int piecesGagnees = (int) Math.pow((int) (Math.random() * (10 + adversaire.niv) + 1), 2);
        joueur.or += piecesGagnees;
        joueur.pv = joueur.pvMax;
        System.out.println(vainqueur + " a gagné " + adversaire.niv * 20 + " points d'experience et "
                + piecesGagnees + " pièces d'or.\nSon total de pièces s'élève à "
                + joueur.or + " pièces d'or.");

    }

    public static void gainNiveau(Heros joueur) {
        while (joueur.experience >= (10 * Math.pow(joueur.niv, 2))) {
            int xpPourProchainNiveau = 10 * (int) (Math.pow(joueur.niv, 2));
            if (joueur.experience >= xpPourProchainNiveau)
                joueur.niv += 1;
            joueur.pvMax += 10;
            joueur.attaque += 1;
            joueur.armure += 1;
            joueur.experience = (joueur.experience - xpPourProchainNiveau);
        }
    }

    public static void infoGainDXp(Heros joueur) {
        int xpManquantePourProchainNiveau = (int) (10 * Math.pow(joueur.niv, 2)) - joueur.experience;
        System.out.println(joueur.nom + " est passé niveau " + joueur.niv + ".");
        System.out.println("Il manque " + xpManquantePourProchainNiveau + " d'xp pour passer au prochain niveau.");

    }

    public static void uneChanceSurDeuxDeFuir(Heros joueur) {
        Random r = new Random();
        int resultatTirage = r.nextInt(2);

        combatFini = false;


        if (resultatTirage == 0) {
            System.out.println("Le combat est fini !  " + joueur.nom + " a pris la fuite !\n");
            combatFini = true;
        }
        if (resultatTirage == 1) {
            System.out.println("fuite ratée, " + joueur.nom + " n'a fait aucun dégât ! Le combat continue..");
        }

    }

        public static void achatPotions(Heros joueur,Boutique boutique){
            boutique.lireBoutique();
            Scanner scan = new Scanner(System.in);
            System.out.println("Veux tu acheter une potion parmi la liste ci-dessus : tape (1), (2), (3) ou aucune (4) ?");
            int choix = scan.nextInt();

            switch(choix){
                case 1 :
                    joueur.or =- boutique.getBoutique().getFirst().prix;
                    joueur.potions.add(boutique.getBoutique().getFirst());
//                    System.out.println(joueur.potions.getFirst().nom);


                    break ;
                case 2 :
                    joueur.or =- boutique.getBoutique().get(1).prix;
                    joueur.potions.add(boutique.getBoutique().get(1));


                    break ;
                case 3 :
                    joueur.or =- boutique.getBoutique().get(2).prix;
                    joueur.potions.add(boutique.getBoutique().get(2));

                    break;
                case 4 :
                    System.out.println("C'est noté! Nous espérons vous revoir bientôt dans notre boutique :) ");
                    break;
                default :
                    System.out.println("saisie invalide");
                    achatPotions(joueur,boutique);
                    break;
            }
        }

}
