public class Combat {





    public static void combattre(Personnage attaquant, Personnage adversaire){

        String vainqueur = "";

        while (attaquant.pv > 0 && adversaire.pv > 0){
            if(attaquant.pv > 0){
                adversaire.pv -= attaquant.attaque;
                System.out.println("BIM ! PV de " + adversaire.nom + " = "+ adversaire.pv);
            }
            if(adversaire.pv > 0){
                attaquant.pv -= adversaire.attaque;
                System.out.println("BAM !  PV de " + attaquant.nom + " = "+ attaquant.pv );
            }

        }
        if(attaquant.pv > 0) vainqueur += attaquant.nom;
        if(adversaire.pv > 0) vainqueur += adversaire.nom;
        System.out.println("le combat est fini ! Le vainqueur est " + vainqueur +" !!!");
    }


//    public void combattre(Personnage attaquant, Personnage adversaire){
//
//        while (attaquant.pv > 0 && adversaire.pv > 0){
//            adversaire.pv -= attaquant.attaque;
//            System.out.println("Il reste "+ adversaire.pv + " pv à "+ adversaire.nom);
//            attaquant.pv -= adversaire.attaque;
//            System.out.println("Il reste "+ attaquant.pv + " pv à " + attaquant.nom);
//        }
//
//        System.out.println("le combat est fini");
//    }
//


}
