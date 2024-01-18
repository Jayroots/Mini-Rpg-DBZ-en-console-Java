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

        boutique.lireBoutique();
        achatPotions(joueur, adversaire,boutique);

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
                System.out.println(joueur.nom + ", veux-tu attaquer (1), fuir (2) utiliser la magie (3) une potion (4) ou un COUP SPECIAL (5) ?");
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
                            System.out.println("Le personnage n'a pas assez de magie (magie : "+joueur.magie+" ) ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }

                        break;

                    case 4 :
                        if(joueur.potions.size() != 0){
                            joueur.lirePotions();
                            System.out.println(joueur.nom + ", quelle potion voulez-vous utiliser : la 1ere (1), 2eme (2), 3eme (3)..? ");
                            int choixPotion = scan.nextInt();
                            switch(choixPotion){
                                case 1 :
                                    joueur.pv += joueur.potions.getFirst().gainDePv;
                                    joueur.magie += joueur.potions.getFirst().gainDeMana;
                                    joueur.potions.removeFirst();
                                    System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                    break;

                                case 2 :
                                    if(joueur.potions.get(1) != null){
                                        joueur.pv += joueur.potions.get(1).gainDePv;
                                        joueur.magie += joueur.potions.get(1).gainDeMana;
                                        joueur.potions.remove(1);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana" );
                                    }else{
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;

                                case 3 :
                                    if(joueur.potions.get(2) != null){
                                        joueur.pv += joueur.potions.get(2).gainDePv;
                                        joueur.magie += joueur.potions.get(2).gainDeMana;
                                        joueur.potions.remove(2);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                    }else{
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;
                                case 4 :
                                    if(joueur.potions.get(3) != null){
                                        joueur.pv += joueur.potions.get(3).gainDePv;
                                        joueur.magie += joueur.potions.get(3).gainDeMana;
                                        joueur.potions.remove(3);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                    }else{
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;

                                case 5 :
                                    if(joueur.potions.get(4) != null){
                                        joueur.pv += joueur.potions.get(4).gainDePv;
                                        joueur.magie += joueur.potions.get(4).gainDeMana;
                                        joueur.potions.remove(4);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                    }else{
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;





                                default:
                                    System.out.println("saisie invalide");
                                    joueurCommence(joueur,adversaire);
                                    break;
                            }
                        }else{
                            System.out.println("Le personnage n'a pas de potions ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }
                        break;

                    case 5:
                        joueur.lireCoupsSpeciaux(joueur);

                        System.out.println("Veux-tu utiliser le 1er coup special (0) ou le 2e (1) ?");
                        int choixCoup = scan.nextInt();

                        if (joueur.magie >= joueur.coupSpeciaux.get(choixCoup).coutEnMana){

                            adversaire.pv -= joueur.coupSpeciaux.get(choixCoup).puissance ;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom.toUpperCase() + " attaque avec son ".toUpperCase() + joueur.coupSpeciaux.get(choixCoup).nom.toUpperCase()   +"! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                            joueur.magie -= joueur.coupSpeciaux.get(choixCoup).coutEnMana;
                        } else {
                            System.out.println("Le personnage n'a pas assez de magie ! Saisir une autre action :");
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
                    System.out.println("\n"+adversaire.nom + " attaque ! \n" + "BAM !  PV de " + joueur.nom + " = " + joueur.pv);
                }

                if (joueur.pv > 0 && !combatFini) {

                    Scanner scan = new Scanner(System.in);
                    System.out.println(joueur.nom + ", veux-tu attaquer (1), fuir (2) utiliser la magie (3) ou une potion (4)  ?");
                    int choix = scan.nextInt();

                    switch (choix) {

                        case 1:

                            int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.attaque) + 1) - adversaire.armure;

                            if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                            adversaire.pv -= attaqueAleatoireJoueur;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv );

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
                                System.out.println("\n"+joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv );
                                joueur.magie -= 5;
                            } else {
                                System.out.println("Le personnage n'a plus de magie ! Saisir une autre action :");
                                joueurCommence(joueur, adversaire);
                            }
                            break;

                        case 4 :
                            if(joueur.potions.size() != 0){
                                joueur.lirePotions();
                                System.out.println(joueur.nom + ", quelle potion voulez-vous utiliser : la 1ere (1), 2eme (2), 3eme (3)..? ");
                                int choixPotion = scan.nextInt();
                                switch(choixPotion){
                                    case 1 :
                                        joueur.pv += joueur.potions.getFirst().gainDePv;
                                        joueur.magie += joueur.potions.getFirst().gainDeMana;
                                        joueur.potions.removeFirst();
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                        break;

                                    case 2 :
                                        if(joueur.potions.get(1) != null){
                                            joueur.pv += joueur.potions.get(1).gainDePv;
                                            joueur.magie += joueur.potions.get(1).gainDeMana;
                                            joueur.potions.remove(1);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana" );
                                        }else{
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;

                                    case 3 :
                                        if(joueur.potions.get(2) != null){
                                            joueur.pv += joueur.potions.get(2).gainDePv;
                                            joueur.magie += joueur.potions.get(2).gainDeMana;
                                            joueur.potions.remove(2);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                        }else{
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;
                                    case 4 :
                                        if(joueur.potions.get(3) != null){
                                            joueur.pv += joueur.potions.get(3).gainDePv;
                                            joueur.magie += joueur.potions.get(3).gainDeMana;
                                            joueur.potions.remove(3);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                        }else{
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;

                                    case 5 :
                                        if(joueur.potions.get(4) != null){
                                            joueur.pv += joueur.potions.get(4).gainDePv;
                                            joueur.magie += joueur.potions.get(4).gainDeMana;
                                            joueur.potions.remove(4);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et "+ joueur.magie + " points de mana");
                                        }else{
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;

                                    default:
                                        System.out.println("saisie invalide");
                                        joueurCommence(joueur,adversaire);
                                        break;
                                }
                        }else{
                            System.out.println("Le personnage n'a pas de potions ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }
                            break;

                        case 5:
                            joueur.lireCoupsSpeciaux(joueur);

                            System.out.println("Veux-tu utiliser le 1er coup special (0) ou le 2e (1) ?");
                            int choixCoup = scan.nextInt();

                            if (joueur.magie >= joueur.coupSpeciaux.get(choixCoup).coutEnMana){

                                adversaire.pv -= joueur.coupSpeciaux.get(choixCoup).puissance ;

                                if (adversaire.pv <= 0) adversaire.pv = 0;
                                System.out.println(joueur.nom.toUpperCase() + " attaque avec son ".toUpperCase() + joueur.coupSpeciaux.get(choixCoup).nom.toUpperCase()   +"! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                                joueur.magie -= joueur.coupSpeciaux.get(choixCoup).coutEnMana;
                            } else {
                                System.out.println("Le personnage n'a pas assez de magie ! Saisir une autre action :");
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

        public static void achatPotions(Heros joueur,Monstre adversaire,Boutique boutique){

            Scanner scan = new Scanner(System.in);
            System.out.println("Le combat va bientôt commencer contre " + adversaire.nom.toUpperCase()+
                    " ! Veux tu acheter une potion parmi la liste ci-dessus : tape (1), (2), (3), (4), (5) ou aucune (6) ?");
            int choix = scan.nextInt();

            switch(choix){
                case 1 :
                    if(joueur.or >= boutique.getBoutique().getFirst().prix){
                        joueur.or -= boutique.getBoutique().getFirst().prix;
                        joueur.potions.add(boutique.getBoutique().getFirst());
                        System.out.println("La " + boutique.getBoutique().getFirst().nom + " a bien été ajoutée à votre inventaire."+
                                " Votre nouveau solde de pièces est de " + joueur.or);

//                    System.out.println(joueur.potions.getFirst().nom);
                    }else{
                        System.out.println("Vous n'avez pas assez de pièces d'or. Votre solde est de " + joueur.or + " pièces d'or.");
                        achatPotions(joueur,adversaire,boutique);
                    }
                    break ;
                case 2 :
                if(joueur.or >= boutique.getBoutique().get(1).prix){
                    joueur.or -= boutique.getBoutique().get(1).prix;
                    joueur.potions.add(boutique.getBoutique().get(1));
                    System.out.println("La " + boutique.getBoutique().get(1).nom + " a bien été ajoutée à votre inventaire."
                            + " Votre nouveau solde de pièces est de " + joueur.or);
                }
                    else{
                    System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                    achatPotions(joueur,adversaire,boutique);
                }

                    break ;
                case 3 :
                    if(joueur.or >= boutique.getBoutique().get(2).prix){
                    joueur.or -= boutique.getBoutique().get(2).prix;
                    joueur.potions.add(boutique.getBoutique().get(2));
                        System.out.println("La " + boutique.getBoutique().get(2).nom + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.or);
                } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                        achatPotions(joueur,adversaire,boutique);
                    }
                    break;
                case 4 :
                    if(joueur.or >= boutique.getBoutique().get(3).prix){
                        joueur.or -= boutique.getBoutique().get(3).prix;
                        joueur.potions.add(boutique.getBoutique().get(3));
                        System.out.println("La " + boutique.getBoutique().get(3).nom + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.or);
                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                        achatPotions(joueur,adversaire,boutique);
                    }
                    break;

                case 5 :
                    if(joueur.or >= boutique.getBoutique().get(4).prix){
                        joueur.or -= boutique.getBoutique().get(4).prix;
                        joueur.potions.add(boutique.getBoutique().get(4));
                        System.out.println("La " + boutique.getBoutique().get(4).nom + " a bien été ajoutée à votre inventaire."
                                + " Votre nouveau solde de pièces est de " + joueur.or);
                    } else {
                        System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                        achatPotions(joueur,adversaire,boutique);
                    }
                    break;


                case 6 :
                    System.out.println("C'est noté! Nous espérons vous revoir bientôt dans notre boutique :) ");
                    break;
                default :
                    System.out.println("saisie invalide");
                    achatPotions(joueur,adversaire,boutique);
                    break;
            }
        }

}
