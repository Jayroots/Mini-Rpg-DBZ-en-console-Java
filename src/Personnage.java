import java.util.ArrayList;

public class Personnage {
    protected String nom;
    protected int pvMax;
    protected int pv = pvMax;
    protected int attaque;



    public void combat(Personnage adversaire){

        String vainqueur = "";

        while (pv > 0 && adversaire.pv > 0){
            if(pv > 0){
                adversaire.pv -= attaque;
                System.out.println("BIM ! PV de " + adversaire.nom + " = "+ adversaire.pv);
            }
            if(adversaire.pv > 0){
                pv -= adversaire.attaque;
                System.out.println("BAM !  PV de " + nom + " = "+ pv );
            }

        }
        if(pv > 0) vainqueur += nom;
        if(adversaire.pv > 0) vainqueur += adversaire.nom;
        System.out.println("le combat est fini ! Le vainqueur est " + vainqueur +" !!!");
    }




    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", pvMax=" + pvMax +
                ", pv=" + pv +
                ", attaque=" + attaque +
                '}';
    }

    public Personnage() {
    }


    public Personnage(String nom, int pvMax, int attaque) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.attaque = attaque;
    }

    public Personnage(String nom, int pvMax, int pv, int attaque) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.attaque = attaque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
}
