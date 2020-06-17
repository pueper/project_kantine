import javax.swing.*;
import java.util.Iterator;

public class Kassa{

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
    public void rekenAf(Dienblad klant) throws TeWeinigGeldException{
        Iterator<Artikel> it = klant.getArtikelen();
        double uitkomst = 0;
        while(it.hasNext()){
            Artikel a = it.next();
            //if(a == dagaanbieding) {
                //double prijs = a.getPrijs() * 0.8;
                //uikomst += prijs;
            //}
            //else{
            uitkomst += a.getPrijs();
            //}
        }
        try {
            /*
            if (klant instanceof Docent){
                Docent docent = new Docent();
                double korting = docent.geefKortingsPercentage();
                uitkomst = uitkomst * 0.75;
            }
            else if (klant instanceof KantineMedewerker){
                KantineMedewerker kantineMedewerker = new KantineMedewerker();
                double korting = kantineMedewerker.geefKortingsPercentage();
                uitkomst = uitkomst* 0.65;
            }
            else{
            uitkomst = uitkomst;
            }
             */
            klant.getKlant().getBetaalwijze().betaal(uitkomst);
            geldInKassa += uitkomst;
            totaalArtikelen += klant.getAantalArtikelen();

        } catch (TeWeinigGeldException e){
            /*JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Betaling mislukt", "Alert", JOptionPane.WARNING_MESSAGE);*/
            e.setNaam(klant.getKlant().getVolledigeNaam());
            System.out.println(e);
        }
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
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