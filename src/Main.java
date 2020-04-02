public class Main {

    public static void main(String[] args) {

        // OVDJE JE ZADATAK: https://docs.google.com/document/d/1tp2OF27r7NXJ_BQPu37d9PrHEsMvRRvmVcc3Sv47ctA/edit

        Bankomat bankomat = new Bankomat();

        Racun racun1 = new Racun(1, "Mirza Cickusic", 1000);

        bankomat.kreirajRacun(racun1);

        Racun racun2 = new Racun(2, "Samir Kamenjakovic", 1000);

        bankomat.kreirajRacun(racun2);



        bankomat.ispisiDetaljeSvihRacuna();



        bankomat.posaljiNovac(2, 1, -500);

        bankomat.ispisiDetaljeSvihRacuna();







    }
}
