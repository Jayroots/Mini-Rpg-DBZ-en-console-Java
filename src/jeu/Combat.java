package jeu;

import personnages.Personnage;
public class Combat {





    public static void combattre(Personnage joueur, Personnage adversaire){

        String vainqueur = "";
//        int attaqueAleatoireJoueur = (int)(Math.random()* joueur.attaque+1);
//        int attaqueAleatoireAdversaire = (int)(Math.random()* adversaire.attaque+1);

        while (joueur.pv > 0 && adversaire.pv > 0){
            if(joueur.pv > 0){
                int attaqueAleatoireJoueur = ((int) (Math.random()* joueur.attaque )+1)- adversaire.armure;
                boolean attaqueNegativeJoueur = true;

                if(attaqueAleatoireJoueur <= 0 ) {attaqueAleatoireJoueur += 1;}
                adversaire.pv -= attaqueAleatoireJoueur ;
                System.out.println(attaqueAleatoireJoueur);
                System.out.println("BIM ! PV de " + adversaire.nom + " = "+ adversaire.pv);
            }
            if(adversaire.pv > 0){
                int attaqueAleatoireAttaquant = ((int)(Math.random()* adversaire.attaque)+1)- joueur.armure;
                if(attaqueAleatoireAttaquant <= 0) {attaqueAleatoireAttaquant += 1;}
                joueur.pv -= attaqueAleatoireAttaquant;
                System.out.println(attaqueAleatoireAttaquant);
                System.out.println("BAM !  PV de " + joueur.nom + " = "+ joueur.pv );
            }

        }
        if(joueur.pv > 0) vainqueur += joueur.nom;
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
