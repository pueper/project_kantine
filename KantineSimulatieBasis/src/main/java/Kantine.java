public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan() {
        Persoon persoon1 = new Persoon();
        Dienblad dienblad1 = new Dienblad(persoon1);
        Artikel artikel1 = new Artikel("iets", 3);
        Artikel artikel2 = new Artikel("nog iets", 3);
        dienblad1.voegToe(artikel1);
        dienblad1.voegToe(artikel2);
        kassarij.sluitAchteraan(dienblad1);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
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
