import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "factuurregel")
public class FactuurRegel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL);
    @JoinColumn(name = "factuur_id")
    private Factuur factuur;

    @Column(name = "artikel_naam")
    private Artikel artikel;

    public FactuurRegel() {}

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.artikel = artikel;
        this.factuur = factuur;
    }

    /**
     * @return een printbare factuurregel
     */
    @Override
    public String toString() {

    }
}
