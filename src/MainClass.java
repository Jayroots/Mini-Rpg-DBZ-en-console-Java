public class MainClass {



    public static void main(String[] args) {


        Personnage sangoku = new Personnage("San Goku", 100,100, 10);
        Personnage vegeta = new Personnage("Vegeta", 90, 90,12);
        Personnage sangohan = new Personnage("San Gohan", 50, 50, 5);

    Combat.combattre(sangoku,vegeta);

    }




}
