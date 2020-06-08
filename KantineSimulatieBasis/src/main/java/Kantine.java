public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    public KantineAanbod getKantineaanbod(){
       return kantineaanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineaanbod){
        this.kantineaanbod = kantineaanbod;
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        for(String artikelnaam : artikelnamen){
            Artikel artikel = kantineaanbod.getArtikel(artikelnaam);
            dienblad.voegToe(artikel);
        }
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() throws TeWeinigGeldException{
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    /**
     * Deze geeft het kassa-object terug
     *
     * @return hoeveelheid geld in kassa
     */
    public Kassa getKassa(){
        return kassa;
    }
}
