package ohtu.verkkokauppa;

public class Kauppa {

//    private Varasto varasto;
//    private Pankki pankki;
//    private Ostoskori ostoskori;
//    private Viitegeneraattori viitegeneraattori;
//    private String kaupanTili;
    private Singleton varasto;
    private Singleton pankki;
    private Ostoskori ostoskori;
    private Singleton viitegeneraattori;
    private String kaupanTili;
//    public Kauppa() {
//        varasto = Varasto.getInstance();
//        pankki = Pankki.getInstance();
//        viitegeneraattori = Viitegeneraattori.getInstance();
//        kaupanTili = "33333-44455";
//    }
    public Kauppa(Singleton v, Singleton p, Singleton vg) {
        varasto = v.getInstance();
        pankki = p.getInstance();
        viitegeneraattori = vg.getInstance();
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
