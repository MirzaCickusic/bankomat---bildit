public class Racun {

    int brojRacuna;
    String imeNosiocaRacuna;
    int stanjeNaRacunu;

    public Racun() {

    }

    public Racun(int brojRacuna, String imeNosiocaRacuna, int stanjeNaRacunu) {
        this.brojRacuna = brojRacuna;
        this.imeNosiocaRacuna = imeNosiocaRacuna;
        this.stanjeNaRacunu = stanjeNaRacunu;
    }

    public int getStanjeNaRacunu() {
        return stanjeNaRacunu;
    }

    public void setStanjeNaRacunu(int stanjeNaRacunu) {
        this.stanjeNaRacunu = stanjeNaRacunu;
        return;
    }

    @Override
    public String toString() {
        return "Racun{" +
                "brojRacuna=" + brojRacuna +
                ", imeNosiocaRacuna='" + imeNosiocaRacuna + '\'' +
                ", stanjeNaRacunu=" + stanjeNaRacunu + " KM" +
                '}';
    }
}
