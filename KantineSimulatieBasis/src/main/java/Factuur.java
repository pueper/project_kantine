import jdk.jfr.Name;

import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Entity
@Table(name = "factuur")
@NamedQuery(name = "Factuur.alleKortingen",
            query = "select korting from Factuur")
@NamedQuery(name = "Factuur.gemiddeldeOmzet",
            query = "select avg(totaal) from Factuur")
@NamedQuery(name = "Factuur.totaleOmzet",
            query = "select sum(totaal) from Factuur")
@NamedQuery(name = "Factuur.totaleKorting",
            query = "select sum(korting) from Factuur")
@NamedQuery(name = "Factuur.top3Facturen",
            query = "from Factuur order by totaal desc")
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

    @OneToMany(targetEntity = FactuurRegel.class, mappedBy = "factuur",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FactuurRegel> regels;

    public Factuur() {
        totaal = 0;
        korting = 0;
        regels =  new ArrayList<>();
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
        //personeelskorting bepalen
        double pKorting = geefKorting(klant);
        //korting en prijs uitrekenen
        Iterator<Artikel> it = klant.getArtikelen();
        while(it.hasNext()){
            Artikel a = it.next();
            korting += a.getPrijs() * (pKorting) + a.getKorting();
            totaal += a.getPrijs() * (1 - pKorting) - a.getKorting();
            FactuurRegel regel = new FactuurRegel(this, a);
            regels.add(regel);
        }
    }

    /**
     * Deze methode wordt gebruikt om personeelskorting te bepalen
     * @param dienblad
     * @return personeelskorting
     */
    public double geefKorting(Dienblad dienblad){
        Persoon klant = dienblad.getKlant();
        if (klant instanceof Docent){
            Docent docent = new Docent();
            double korting = docent.geefKortingsPercentage();
            return korting;
        }
        else if (klant instanceof KantineMedewerker){
            KantineMedewerker kantineMedewerker = new KantineMedewerker();
            double korting = kantineMedewerker.geefKortingsPercentage();
            return korting;
        }
        else
            return 0.00;
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
        String artikelen = "Artikelen: ";
        for(FactuurRegel regel : regels) {
            artikelen += "\r\n" + regel.toString();
        }
        return "Totaal: " + totaal + ", korting: " + korting + ", datum: " + datum + "\r\n" + artikelen;
    }

}
