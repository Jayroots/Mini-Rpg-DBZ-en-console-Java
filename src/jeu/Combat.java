package jeu;

import personnages.Monstre;
import personnages.Personnage;
import personnages.Heros;
import personnages.Personnage;
public class Combat {





    public static void combattre(Heros joueur, Monstre adversaire){

        String vainqueur = "";


        while (joueur.pv > 0 && adversaire.pv > 0){
            if(joueur.pv > 0){
                int attaqueAleatoireJoueur = ((int) (Math.random()* joueur.attaque )+1)- adversaire.armure;

                if(attaqueAleatoireJoueur <= 0 )  attaqueAleatoireJoueur = 1;
                adversaire.pv -= attaqueAleatoireJoueur ;

                if(adversaire.pv <= 0) adversaire.pv = 0;
                System.out.println("BIM ! PV de " + adversaire.nom + " = "+ adversaire.pv);
            }
            if(adversaire.pv > 0){
                int attaqueAleatoireAttaquant = ((int)(Math.random()* adversaire.attaque)+1)- joueur.armure;
                if(attaqueAleatoireAttaquant <= 0) {attaqueAleatoireAttaquant = 1;}
                joueur.pv -= attaqueAleatoireAttaquant;

                if(joueur.pv <= 0) joueur.pv = 0;
                System.out.println("BAM !  PV de " + joueur.nom + " = "+ joueur.pv );
            }

        }
        if(joueur.pv > 0) vainqueur += joueur.nom;
        if(adversaire.pv > 0) vainqueur += adversaire.nom;
        System.out.println("Le combat est fini ! Le vainqueur est " + vainqueur.toUpperCase() +" !!!");
        if(joueur.pv > 0){
            joueur.experience = adversaire.niv * 20;
//            joueur.or =
            joueur.or = (int)Math.pow((int)(Math.random()*(10 + adversaire.niv)+1),2);
            joueur.pv = joueur.pvMax;
            System.out.println(vainqueur + " a gagné " + joueur.experience + " points d'experience et "
            + joueur.or + " pièces d'or.");


            while(joueur.experience >= ( 10*Math.pow(2,joueur.niv))){
                int xpPourProchainNiveau = (int)( 10*Math.pow(2,joueur.niv));
                if(joueur.experience >= xpPourProchainNiveau  ) joueur.niv +=1;
                joueur.experience = (joueur.experience - xpPourProchainNiveau);
            }

            System.out.println("le niveau du joueur est de " + joueur.niv);
            System.out.println("Il reste " + joueur.experience + " points d'xp.");
        }
    }


}
