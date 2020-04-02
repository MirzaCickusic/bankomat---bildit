import java.util.ArrayList;

public class Bankomat {

    ArrayList<Racun> listaRacuna = new ArrayList<>();

    public Bankomat() {

    }

    public void kreirajRacun(Racun racun) {

        if (racun.brojRacuna < 0) {
            System.out.println("\nNije dozvoljeno kreiranje računa sa negativnim brojem! ");
            return;
        }

        if (racun.stanjeNaRacunu < 0) {
            System.out.println("\nNije dozvoljeno kreiranje računa sa negativnim iznosom novca na računu!");
            return;
        }

        if (listaRacuna.isEmpty()) {
            listaRacuna.add(racun);
            return;
        }

        for (int i = 0; i < listaRacuna.size(); i++) {
            Racun ovajRacun = listaRacuna.get(i);
            int ovajBrojRacuna = ovajRacun.brojRacuna;
            if (ovajBrojRacuna == racun.brojRacuna) {
                System.out.println("\nVeć postoji račun sa istim brojem računa!");
                return;
            }
        }

        listaRacuna.add(racun);

    }

    public void posaljiNovac(int racunPosiljaoca, int racunPrimaoca, int iznosKojiSePrenosi) {

        if (iznosKojiSePrenosi <0){
            System.out.println("\nNe možete poslati negativnu količinu novca!");
            return;
        }

        for (int a = 0; a < listaRacuna.size(); a++) {
            Racun ovajRacun = listaRacuna.get(a);
            int brojOvogRacuna = ovajRacun.brojRacuna;
            int stanjeOvogRacuna = ovajRacun.stanjeNaRacunu;
            if (racunPosiljaoca == brojOvogRacuna && iznosKojiSePrenosi > stanjeOvogRacuna) {
                System.out.println("\nUneseni iznos novca za prenos prekoračuje sumu novca sa datog računa! ");
                return;
            }
        }

        for (int i = 0; i < listaRacuna.size(); i++) {
            Racun ovajRacun = listaRacuna.get(i);
            int ovajBrojRacuna = ovajRacun.brojRacuna;
            if (racunPosiljaoca == ovajBrojRacuna) {
                //račun pošiljaoca se poklopio s tim računom u listi računa
                Racun trazeniRacun = ovajRacun;
                int stanjeNaTrazenomRacunu = trazeniRacun.getStanjeNaRacunu();
                int novoStanjeNaTrazenomRacunu = stanjeNaTrazenomRacunu - iznosKojiSePrenosi;
                trazeniRacun.setStanjeNaRacunu(novoStanjeNaTrazenomRacunu);
                for (int s = 0; s < listaRacuna.size(); s++) {
                    Racun ovajDrugiRacun = listaRacuna.get(s);
                    int ovajBrojDrugogRacuna = ovajDrugiRacun.brojRacuna;
                    if (racunPrimaoca == ovajBrojDrugogRacuna) {
                        //račun primaoca se poklopio sa traženim računom iz liste računa
                        Racun trazeniDrugiRacun = ovajDrugiRacun;
                        int stanjeNaTrazenomDrugomRacunu = trazeniDrugiRacun.getStanjeNaRacunu();
                        int novoStanjeNaDrugomTrazenomRacunu = stanjeNaTrazenomDrugomRacunu + iznosKojiSePrenosi;
                        trazeniDrugiRacun.setStanjeNaRacunu(novoStanjeNaDrugomTrazenomRacunu);
                        System.out.println("\nTRANSAKCIJA JE USPJEŠNO OBAVLJENA! ");
                        return;
                    }
                }
            }
        }

        System.out.println("\nBroj pošiljaoca ili primaoca se ne poklapa niti sa jednim računom!");
        System.out.println("Pogledajte detalje svih računa kako bi vidjeli ko kome može poslati novac: ");
        ispisiDetaljeSvihRacuna();
        return;
    }

    public void ispisiDetaljeSvihRacuna() {
        System.out.println("\nDetalji svi računa: ");
        for (int i = 0; i < listaRacuna.size(); i++) {
            Racun ovajRacun = listaRacuna.get(i);

            System.out.println("\n- broj računa: " + ovajRacun.brojRacuna + "\n- ime nosioca" +
                    " računa: " + ovajRacun.imeNosiocaRacuna + "\n- stanje računa: " + ovajRacun.stanjeNaRacunu);

        }
    }
}

