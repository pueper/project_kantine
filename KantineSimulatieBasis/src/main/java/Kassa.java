import java.util.Iterator;
public class Kassa {

    private double geldInKassa;
    private int totaalArtikelen;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        // method body omitted
        geldInKassa = 0;
        totaalArtikelen = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        totaalArtikelen = totaalArtikelen + klant.getArtikelen().size();
        Iterator<Artikel> it = klant.getArtikelen().iterator();
        while(it.hasNext()){
            Artikel a = it.next();
            geldInKassa = geldInKassa + a.getPrijs();
        }
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen(Dienblad dienblad) {
        return totaalArtikelen;
    }




    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geldInKassa;

    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        totaalArtikelen = 0;
        geldInKassa = 0;
    }

}