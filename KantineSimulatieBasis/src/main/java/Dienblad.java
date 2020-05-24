import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.HashMap;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    Persoon klant;

    /**
     * Constructor zonder parameter
     */
    public Dienblad() {
        ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
    }

    //constructor met parameter klant (b)
    public Dienblad(Persoon klant) {
        ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
        this.klant = klant;
    }

    //setter klant (b)
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    //getter klant (b)
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);

    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaal = 0;
        if (!artikelen.isEmpty()){
            for (Artikel artikel : artikelen){
                totaal = totaal + artikel.getPrijs();
            }
        }
        return totaal;
    }

}





