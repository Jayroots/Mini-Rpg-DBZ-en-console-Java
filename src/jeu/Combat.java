package jeu;

import personnages.Monstre;
import personnages.Personnage;
import personnages.Heros;
import personnages.Personnage;

public class Combat {


    public static void combattre(Heros joueur, Monstre adversaire) {

        String vainqueur = "";

        if (joueur.vitesse > adversaire.vitesse) {
            joueurCommence(joueur, adversaire);
        } else {
            adversaireCommence(joueur, adversaire);
        }


        if (joueur.pv > 0) vainqueur += joueur.nom;
        if (adversaire.pv > 0) vainqueur += adversaire.nom;
        System.out.println("Le combat est fini ! Le vainqueur est " + vainqueur.toUpperCase() + " !!!\n");


        if (joueur.pv > 0) {

            gainXpEtOr(joueur, adversaire, vainqueur);

            gainNiveau(joueur);

            infoGainDXp(joueur);

        }
        joueur.pv = joueur.pvMax;
    }

    public static void joueurCommence(Heros joueur, Monstre adversaire) {
        while (joueur.pv > 0 && adversaire.pv > 0) {
            if (joueur.pv > 0) {
                int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.attaque) + 1) - adversaire.armure;

                if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                adversaire.pv -= attaqueAleatoireJoueur;

                if (adversaire.pv <= 0) adversaire.pv = 0;
                System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
            }
            if (adversaire.pv > 0) {
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
            while (joueur.pv > 0 && adversaire.pv > 0) {

                if (adversaire.pv > 0) {
                    int attaqueAleatoireAttaquant = ((int) (Math.random() * adversaire.attaque) + 1) - joueur.armure;
                    if (attaqueAleatoireAttaquant <= 0) {
                        attaqueAleatoireAttaquant = 1;
                    }
                    joueur.pv -= attaqueAleatoireAttaquant;

                    if (joueur.pv <= 0) joueur.pv = 0;
                    System.out.println(adversaire.nom + " attaque ! \n" + "BAM !  PV de " + joueur.nom + " = " + joueur.pv);
                }
                if (joueur.pv > 0) {
                    int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.attaque) + 1) - adversaire.armure;

                    if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                    adversaire.pv -= attaqueAleatoireJoueur;

                    if (adversaire.pv <= 0) adversaire.pv = 0;
                    System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
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
}
