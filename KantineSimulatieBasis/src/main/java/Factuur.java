import java.time.LocalDate;
import java.io.Serializable;
import java.util.Iterator;

public class Factuur implements Serializable {

    private Long id;
    private LocalDate datum;
    private double korting;
    private double totaal;

    public Factuur() {
        totaal = 0;
        korting = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    /**
     * verwerk artikelen en pas kortingen toe
     *
     * zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant) {
        Iterator<Artikel> it = klant.getArtikelen();
        while(it.hasNext()){
            Artikel a = it.next();
            korting += a.getPrijs() * a.getKorting();
            totaal += a.getPrijs() * (1-a.getKorting());
        }
    }

    /**
     * @return het totaalbedrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
     * @return de toegepaste korting
     */
    public double getKorting() {
        return korting;
    }

    /**
     * @return een printbaar bonnetje
     */
    public String toString() {
        return "Totaal = " + totaal + ", korting = " + korting;
    }

}
