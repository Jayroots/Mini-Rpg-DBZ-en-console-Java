package jeu;

import personnages.Personnage;
public class Combat {





    public static void combattre(Personnage attaquant, Personnage adversaire){

        String vainqueur = "";
        int attaqueAleatoireAttaquant = (int)(Math.random()* attaquant.attaque+1);
        int attaqueAleatoireAdversaire = (int)(Math.random()* adversaire.attaque+1);

        while (attaquant.pv > 0 && adversaire.pv > 0){
            if(attaquant.pv > 0){
                adversaire.pv -= attaqueAleatoireAttaquant;
                System.out.println("BIM ! PV de " + adversaire.nom + " = "+ adversaire.pv);
            }
            if(adversaire.pv > 0){
                attaquant.pv -= attaqueAleatoireAdversaire;
                System.out.println("BAM !  PV de " + attaquant.nom + " = "+ attaquant.pv );
            }

        }
        if(attaquant.pv > 0) vainqueur += attaquant.nom;
        if(adversaire.pv > 0) vainqueur += adversaire.nom;
        System.out.println("Le combat est fini ! Le vainqueur est " + vainqueur.toUpperCase() +" !!!");
    }


//    public static void combattre(joueurs.Personnage attaquant, joueurs.Personnage adversaire){
//
//        String vainqueur = "";
//
//        while (attaquant.pv > 0 && adversaire.pv > 0){
//            if(attaquant.pv > 0){
//                adversaire.pv -= attaquant.attaque;
//                System.out.println("BIM ! PV de " + adversaire.nom + " = "+ adversaire.pv);
//            }
//            if(adversaire.pv > 0){
//                attaquant.pv -= adversaire.attaque;
//                System.out.println("BAM !  PV de " + attaquant.nom + " = "+ attaquant.pv );
//            }
//
//        }
//        if(attaquant.pv > 0) vainqueur += attaquant.nom;
//        if(adversaire.pv > 0) vainqueur += adversaire.nom;
//        System.out.println("Le combat est fini ! Le vainqueur est " + vainqueur.toUpperCase() +" !!!");
//    }



}
