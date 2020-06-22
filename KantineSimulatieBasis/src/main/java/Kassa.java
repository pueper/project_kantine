import javax.persistence.EntityTransaction;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Iterator;
import javax.persistence.EntityManager;

public class Kassa{

    private double geldInKassa;
    private double totalekorting;
    private int totaalArtikelen;
    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager manager) {
        this.manager = manager;
        geldInKassa = 0;
        totaalArtikelen = 0;
        totalekorting = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) throws TeWeinigGeldException{
        //factuur en database transactie aanmaken
        LocalDate date = LocalDate.now();
        Factuur factuur = new Factuur(klant, date);
        double uitkomst = factuur.getTotaal();
        EntityTransaction transaction = null;
        try {
            // betalen en waarden aan velden toevoegen
            klant.getKlant().getBetaalwijze().betaal(uitkomst);
            geldInKassa += uitkomst;
            totalekorting += factuur.getKorting();
            totaalArtikelen += klant.getAantalArtikelen();
            // voer de transactie uit
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(factuur);
            transaction.commit();
        } catch (TeWeinigGeldException e){
            //bij exception worden veranderingen gerollbackt
            if (transaction != null) {
                transaction.rollback();
            }
            //geef het bericht dat iemand te weinig geld heeft (publieke vernedering, dat zal ze leren!)
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