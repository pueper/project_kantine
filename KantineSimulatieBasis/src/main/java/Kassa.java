import java.util.Iterator;
public class Kassa {
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        // method body omitted
        totaalPrijs = Dienblad.getTotaalPrijs();
        totaalArtikelen = Dienblad.getAantalArtikelen();
        bestelling = Dienblad.artikelen;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        // method body omitted
        int controleTotaalArtikelen = 0;
        int controlePrijs = 0;
        aantal = aantalArtikelen();
        prijs = totaalPrijs;
        controlePrijs + prijs;
        controleTotaalArtikelen + aantal;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen(Dienblad dienblad) {
        resetKassa();
        for(int i = 0; i < bestelling; i++) {
            return i;
        }
    }




    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        // method body omitted
        int kassaInhoud = 0
        resetKassa();
        kassaInhoud = totaalprijs + kassaInhoud;
        return kassaInhoud;

    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        // method body omitted
        dienblad.clear();

    }

}