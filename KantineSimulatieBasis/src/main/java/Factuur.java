import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Iterator;

@Entity
public class Factuur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "datum")
    private LocalDate datum;

    @Column(name = "korting")
    private double korting;

    @Column(name = "totaal")
    private double totaal;

    @Column(name = "regels")
    @ElementCollection(targetClass = FactuurRegel.class)

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
    @Override
    public String toString() {
        return "Totaal = " + totaal + ", korting = " + korting + ", datum = " + datum;
    }

}
