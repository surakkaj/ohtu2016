package ohtu.verkkokauppa;

public class Pankki  {

    
    private Kirjanpito kirjanpito;

    public Pankki() {
        kirjanpito = new Kirjanpito();
    }

    public Pankki(Kirjanpito k) {
    }

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
