package jeu;

import objets.Boutique;
import personnages.Monstre;
import personnages.Heros;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jeu {


    static boolean combatFini = false;


    public static void lancerPartie(Heros joueur, ArrayList tableau, Boutique boutique) {

        miseEnPlaceEquipement(joueur);

        Monstre adversaire1 = genererAdversaire(tableau);
        combattre(joueur, adversaire1, boutique);
        Monstre adversaire2 = genererAdversaire(tableau);
        combattre(joueur, adversaire2, boutique);
        Monstre adversaire3 = genererAdversaire(tableau);
        combattre(joueur, adversaire3, boutique);
        Monstre adversaire4 = genererAdversaire(tableau);
        combattre(joueur, adversaire4, boutique);
        Monstre adversaire5 = genererAdversaire(tableau);
        combattre(joueur, adversaire5, boutique);

    }


    public static Monstre genererAdversaire(ArrayList<Monstre> tableau) {
        Random r = new Random();
        int resultatRandom = r.nextInt(tableau.size());


        return tableau.get(resultatRandom);

    }

    public static void combattre(Heros joueur, Monstre adversaire, Boutique boutique) {

        combatFini = false;
        String vainqueur = "";


        boutique.lireBoutique();
        System.out.println("Le combat va bientôt commencer contre " + adversaire.nom.toUpperCase() + " !");
        achatPotions(joueur, adversaire, boutique);

        if (joueur.vitesse >= adversaire.vitesse) {
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
        joueur.magie = joueur.magieMax;
        adversaire.pv = adversaire.pvMax;

    }


    public static void joueurCommence(Heros joueur, Monstre adversaire) {
        while (joueur.pv > 0 && adversaire.pv > 0 && !combatFini) {


            if (joueur.pv > 0 && !combatFini) {

                Scanner scan = new Scanner(System.in);
                System.out.println(joueur.nom + ", veux-tu attaquer (1), fuir (2) utiliser la magie (3) une potion (4) ou un COUP SPECIAL (5) ?");
                System.out.println("(Solde de mana :" + joueur.magie + " )");
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
                        if (joueur.magie >= 5) {
                            int attaqueAleatoireMagiqueJoueur = ((int) (Math.random() * joueur.attaque) + 1);

                            if (attaqueAleatoireMagiqueJoueur <= 0) attaqueAleatoireMagiqueJoueur = 1;
                            adversaire.pv -= attaqueAleatoireMagiqueJoueur;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom + " utilise sa magie ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                            joueur.magie -= 5;
                        } else {
                            System.out.println("Le personnage n'a pas assez de magie (magie : " + joueur.magie + " ) ! Saisir une autre action :");
                            joueurCommence(joueur, adversaire);
                        }

                        break;

                    case 4:
                        if (joueur.potions.size() != 0) {
                            joueur.lirePotions();
                            System.out.println(joueur.nom + ", quelle potion voulez-vous utiliser : la 1ere (1), 2eme (2), 3eme (3)..? ");
                            int choixPotion = scan.nextInt();
                            switch (choixPotion) {
                                case 1:
                                    joueur.pv += joueur.potions.getFirst().gainDePv;
                                    if (joueur.pv > joueur.pvMax) {
                                        joueur.pv = joueur.pvMax;
                                    }
                                    ;
                                    joueur.magie += joueur.potions.getFirst().gainDeMana;
                                    if (joueur.magie > joueur.magieMax) {
                                        joueur.magie = joueur.magieMax;
                                    }
                                    ;
                                    System.out.println("Une " + joueur.potions.getFirst().nom + " a été utlisée.");
                                    joueur.potions.removeFirst();
                                    System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                    break;

                                case 2:
                                    if (joueur.potions.get(1) != null) {
                                        joueur.pv += joueur.potions.get(1).gainDePv;
                                        if (joueur.pv > joueur.pvMax) {
                                            joueur.pv = joueur.pvMax;
                                        }
                                        ;
                                        joueur.magie += joueur.potions.get(1).gainDeMana;
                                        if (joueur.magie > joueur.magieMax) {
                                            joueur.magie = joueur.magieMax;
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(1).nom + " a été utlisée.");
                                        joueur.potions.remove(1);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;

                                case 3:
                                    if (joueur.potions.get(2) != null) {
                                        joueur.pv += joueur.potions.get(2).gainDePv;
                                        if (joueur.pv > joueur.pvMax) {
                                            joueur.pv = joueur.pvMax;
                                        }
                                        ;
                                        joueur.magie += joueur.potions.get(2).gainDeMana;
                                        if (joueur.magie > joueur.magieMax) {
                                            joueur.magie = joueur.magieMax;
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(2).nom + " a été utlisée.");
                                        joueur.potions.remove(2);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;
                                case 4:
                                    if (joueur.potions.get(3) != null) {
                                        joueur.pv += joueur.potions.get(3).gainDePv;
                                        if (joueur.pv > joueur.pvMax) {
                                            joueur.pv = joueur.pvMax;
                                        }
                                        ;
                                        joueur.magie += joueur.potions.get(3).gainDeMana;
                                        if (joueur.magie > joueur.magieMax) {
                                            joueur.magie = joueur.magieMax;
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(3).nom + " a été utlisée.");
                                        joueur.potions.remove(3);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                    } else {
                                        System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                        joueurCommence(joueur, adversaire);
                                    }

                                    break;

                                case 5:
                                    if (joueur.potions.get(4) != null) {
                                        joueur.pv += joueur.potions.get(4).gainDePv;
                                        if (joueur.pv > joueur.pvMax) {
                                            joueur.pv = joueur.pvMax;
                                        }
                                        ;
                                        joueur.magie += joueur.potions.get(4).gainDeMana;
                                        if (joueur.magie > joueur.magieMax) {
                                            joueur.magie = joueur.magieMax;
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.get(4).nom + " a été utlisée.");
                                        joueur.potions.remove(4);
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
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

                        System.out.println("Veux-tu utiliser le 1er coup special (0) ou le 2e (1) ?");
                        int choixCoup = scan.nextInt();

                        if (joueur.magie >= joueur.coupSpeciaux.get(choixCoup).coutEnMana) {

                            adversaire.pv -= joueur.coupSpeciaux.get(choixCoup).puissance;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom.toUpperCase() + " attaque avec son ".toUpperCase() + joueur.coupSpeciaux.get(choixCoup).nom.toUpperCase() + "! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                            joueur.magie -= joueur.coupSpeciaux.get(choixCoup).coutEnMana;
                        } else {
                            System.out.println("Le personnage n'a pas assez de magie (magie : " + joueur.magie + " ) ! Saisir une autre action :");
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
                    System.out.println("\n" + adversaire.nom + " attaque ! \n" + "BAM !  PV de " + joueur.nom + " = " + joueur.pv);
                }

                if (joueur.pv > 0 && !combatFini) {

                    Scanner scan = new Scanner(System.in);
                    System.out.println(joueur.nom + ", veux-tu attaquer (1), fuir (2) utiliser la magie (3) ou une potion (4) ou un COUP SPECIAL (5)  ?");
                    System.out.println("(Solde de mana :" + joueur.magie + " )");
                    int choix = scan.nextInt();

                    switch (choix) {

                        case 1:

                            int attaqueAleatoireJoueur = ((int) (Math.random() * joueur.attaque) + 1) - adversaire.armure;

                            if (attaqueAleatoireJoueur <= 0) attaqueAleatoireJoueur = 1;
                            adversaire.pv -= attaqueAleatoireJoueur;

                            if (adversaire.pv <= 0) adversaire.pv = 0;
                            System.out.println(joueur.nom + " attaque ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv);

                            break;

                        case 2:
                            uneChanceSurDeuxDeFuir(joueur);
                            break;

                        case 3:
                            if (joueur.magie >= 5) {
                                int attaqueAleatoireMagiqueJoueur = ((int) (Math.random() * joueur.attaque) + 1);

                                if (attaqueAleatoireMagiqueJoueur <= 0) attaqueAleatoireMagiqueJoueur = 1;
                                adversaire.pv -= attaqueAleatoireMagiqueJoueur;

                                if (adversaire.pv <= 0) adversaire.pv = 0;
                                System.out.println("\n" + joueur.nom + " utilise sa magie ! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv);
                                joueur.magie -= 5;
                            } else {
                                System.out.println("Le personnage n'a plus de magie (magie : " + joueur.magie + " )! Saisir une autre action :");
                                joueurCommence(joueur, adversaire);
                            }
                            break;

                        case 4:
                            if (joueur.potions.size() != 0) {
                                joueur.lirePotions();
                                System.out.println(joueur.nom + ", quelle potion voulez-vous utiliser : la 1ere (1), 2eme (2), 3eme (3)..? ");
                                int choixPotion = scan.nextInt();
                                switch (choixPotion) {
                                    case 1:
                                        joueur.pv += joueur.potions.getFirst().gainDePv;
                                        if (joueur.pv > joueur.pvMax) {
                                            joueur.pv = joueur.pvMax;
                                        }
                                        ;
                                        joueur.magie += joueur.potions.getFirst().gainDeMana;
                                        if (joueur.magie > joueur.magieMax) {
                                            joueur.magie = joueur.magieMax;
                                        }
                                        ;
                                        System.out.println("Une " + joueur.potions.getFirst().nom + " a été utlisée.");
                                        joueur.potions.removeFirst();
                                        System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                        break;

                                    case 2:
                                        if (joueur.potions.get(1) != null) {
                                            joueur.pv += joueur.potions.get(1).gainDePv;
                                            if (joueur.pv > joueur.pvMax) {
                                                joueur.pv = joueur.pvMax;
                                            }
                                            ;
                                            joueur.magie += joueur.potions.get(1).gainDeMana;
                                            if (joueur.magie > joueur.magieMax) {
                                                joueur.magie = joueur.magieMax;
                                            }
                                            ;
                                            System.out.println("Une " + joueur.potions.get(1).nom + " a été utlisée.");
                                            joueur.potions.remove(1);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                        } else {
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;

                                    case 3:
                                        if (joueur.potions.get(2) != null) {
                                            joueur.pv += joueur.potions.get(2).gainDePv;
                                            if (joueur.pv > joueur.pvMax) {
                                                joueur.pv = joueur.pvMax;
                                            }
                                            ;
                                            joueur.magie += joueur.potions.get(2).gainDeMana;
                                            if (joueur.magie > joueur.magieMax) {
                                                joueur.magie = joueur.magieMax;
                                            }
                                            ;
                                            System.out.println("Une " + joueur.potions.get(2).nom + " a été utlisée.");
                                            joueur.potions.remove(2);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                        } else {
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;
                                    case 4:
                                        if (joueur.potions.get(3) != null) {
                                            joueur.pv += joueur.potions.get(3).gainDePv;
                                            if (joueur.pv > joueur.pvMax) {
                                                joueur.pv = joueur.pvMax;
                                            }
                                            ;
                                            joueur.magie += joueur.potions.get(3).gainDeMana;
                                            if (joueur.magie > joueur.magieMax) {
                                                joueur.magie = joueur.magieMax;
                                            }
                                            ;
                                            System.out.println("Une " + joueur.potions.get(3).nom + " a été utlisée.");
                                            joueur.potions.remove(3);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
                                        } else {
                                            System.out.println("Le personnage n'a pas cette potion ! Saisir une autre action :");
                                            joueurCommence(joueur, adversaire);
                                        }

                                        break;

                                    case 5:
                                        if (joueur.potions.get(4) != null) {
                                            joueur.pv += joueur.potions.get(4).gainDePv;
                                            if (joueur.pv > joueur.pvMax) {
                                                joueur.pv = joueur.pvMax;
                                            }
                                            ;
                                            joueur.magie += joueur.potions.get(4).gainDeMana;
                                            if (joueur.magie > joueur.magieMax) {
                                                joueur.magie = joueur.magieMax;
                                            }
                                            ;
                                            System.out.println("Une " + joueur.potions.get(4).nom + " a été utlisée.");
                                            joueur.potions.remove(4);
                                            System.out.println("Le joueur a maintenant " + joueur.pv + " pv et " + joueur.magie + " points de mana");
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

                            System.out.println("Veux-tu utiliser le 1er coup special (0) ou le 2e (1) ?");
                            int choixCoup = scan.nextInt();

                            if (joueur.magie >= joueur.coupSpeciaux.get(choixCoup).coutEnMana) {

                                adversaire.pv -= joueur.coupSpeciaux.get(choixCoup).puissance;

                                if (adversaire.pv <= 0) adversaire.pv = 0;
                                System.out.println(joueur.nom.toUpperCase() + " attaque avec son ".toUpperCase() + joueur.coupSpeciaux.get(choixCoup).nom.toUpperCase() + "! \n" + "BIM ! PV de " + adversaire.nom + " = " + adversaire.pv + "\n");
                                joueur.magie -= joueur.coupSpeciaux.get(choixCoup).coutEnMana;
                            } else {
                                System.out.println("Le personnage n'a pas assez de magie (magie : " + joueur.magie + " ) ! Saisir une autre action :");
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

    public static void miseEnPlaceEquipement(Heros joueur) {

        System.out.println("\nEquipements du Héros :");

        if (joueur.inventaireEquipements.get("casque") == null) {
            System.out.println("Le héros n'a pas de Casque équipé.");;
        } else {
            joueur.pvMax += joueur.inventaireEquipements.get("casque").bonusPv;
            joueur.pv = joueur.pvMax;
            System.out.println("Le casque équipé est le "+ joueur.inventaireEquipements.get("casque").nom+".");
        }


        if (joueur.inventaireEquipements.get("arme") == null) {
            System.out.println("Le héros n'a pas d'Arme équipée.");;

        } else {
            joueur.attaque += joueur.inventaireEquipements.get("arme").bonusAttaque;
            System.out.println("L'arme équipée est la "+ joueur.inventaireEquipements.get("arme").nom+".");
        }


        if (joueur.inventaireEquipements.get("amulette") == null) {
            System.out.println("Le héros n'a pas d'Amulette équipée.");

        } else {
            joueur.magieMax += joueur.inventaireEquipements.get("amulette").bonusMagie;
            joueur.magie = joueur.magieMax;
            System.out.println("L'amulette équipée est l'"+ joueur.inventaireEquipements.get("amulette").nom+".");
        }


        if (joueur.inventaireEquipements.get("armure") == null) {
            System.out.println("Le héros n'a pas d'Armure équipée.");;

        } else {
            joueur.armure += joueur.inventaireEquipements.get("armure").bonusArmure;
            System.out.println("L'armure équipée est l'"+ joueur.inventaireEquipements.get("armure").nom+".");
        }

        System.out.println("\nStatistiques du Héros :\n"+
                "Attaque :" +joueur.attaque+", Magie :"+joueur.magie+", Armure: "+joueur.armure+", Pv : "+joueur.pv);
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
            joueur.pvMax += 20;
            joueur.attaque += 1;
            joueur.magieMax += 10;
            joueur.armure += 1;
            joueur.experience = (joueur.experience - xpPourProchainNiveau);
        }
    }

    public static void infoGainDXp(Heros joueur) {
        int xpManquantePourProchainNiveau = (int) (10 * Math.pow(joueur.niv, 2)) - joueur.experience;
        System.out.println(joueur.nom + " est passé niveau " + joueur.niv + ".");
        System.out.println("Voici les nouvelles statistiques de " + joueur.nom + " :");
        System.out.println("Attaque : " + joueur.attaque);
        System.out.println("Pv Max : " + joueur.pvMax);
        System.out.println("Magie Max : " + joueur.magieMax);
        System.out.println("Armure : " + joueur.armure + "\n");
        System.out.println("Il manque " + xpManquantePourProchainNiveau + " d'xp pour passer au prochain niveau.\n");


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

    public static void achatPotions(Heros joueur, Monstre adversaire, Boutique boutique) {

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Veux tu acheter une potion parmi la liste ci-dessus ? Votre solde est de " + joueur.or + " pièces d'or." +
                        "\nTape (1), (2), (3), (4), (5) ou aucune (6) ?");
        int choix = scan.nextInt();

        switch (choix) {
            case 1:
                if (joueur.or >= boutique.getBoutique().getFirst().prix) {
                    joueur.or -= boutique.getBoutique().getFirst().prix;
                    joueur.potions.add(boutique.getBoutique().getFirst());
                    System.out.println("La " + boutique.getBoutique().getFirst().nom + " a bien été ajoutée à votre inventaire." +
                            " Votre nouveau solde de pièces est de " + joueur.or + ".");
                    achatPotions(joueur, adversaire, boutique);

                } else {
                    System.out.println("Vous n'avez pas assez de pièces d'or. Votre solde est de " + joueur.or + " pièces d'or.");
                    achatPotions(joueur, adversaire, boutique);
                }
                break;
            case 2:
                if (joueur.or >= boutique.getBoutique().get(1).prix) {
                    joueur.or -= boutique.getBoutique().get(1).prix;
                    joueur.potions.add(boutique.getBoutique().get(1));
                    System.out.println("La " + boutique.getBoutique().get(1).nom + " a bien été ajoutée à votre inventaire."
                            + " Votre nouveau solde de pièces est de " + joueur.or + ".");
                    achatPotions(joueur, adversaire, boutique);
                } else {
                    System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                    achatPotions(joueur, adversaire, boutique);
                }

                break;
            case 3:
                if (joueur.or >= boutique.getBoutique().get(2).prix) {
                    joueur.or -= boutique.getBoutique().get(2).prix;
                    joueur.potions.add(boutique.getBoutique().get(2));
                    System.out.println("La " + boutique.getBoutique().get(2).nom + " a bien été ajoutée à votre inventaire."
                            + " Votre nouveau solde de pièces est de " + joueur.or + ".");
                    achatPotions(joueur, adversaire, boutique);
                } else {
                    System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                    achatPotions(joueur, adversaire, boutique);
                }
                break;
            case 4:
                if (joueur.or >= boutique.getBoutique().get(3).prix) {
                    joueur.or -= boutique.getBoutique().get(3).prix;
                    joueur.potions.add(boutique.getBoutique().get(3));
                    System.out.println("La " + boutique.getBoutique().get(3).nom + " a bien été ajoutée à votre inventaire."
                            + " Votre nouveau solde de pièces est de " + joueur.or + ".");
                    achatPotions(joueur, adversaire, boutique);
                } else {
                    System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
                    achatPotions(joueur, adversaire, boutique);
                }
                break;

            case 5:
                if (joueur.or >= boutique.getBoutique().get(4).prix) {
                    joueur.or -= boutique.getBoutique().get(4).prix;
                    joueur.potions.add(boutique.getBoutique().get(4));
                    System.out.println("La " + boutique.getBoutique().get(4).nom + " a bien été ajoutée à votre inventaire."
                            + " Votre nouveau solde de pièces est de " + joueur.or + ".");
                    achatPotions(joueur, adversaire, boutique);
                } else {
                    System.out.println("Vous n'avez pas assez de pièces d'or.Votre solde est de " + joueur.or + " pièces d'or.");
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
    }

}
