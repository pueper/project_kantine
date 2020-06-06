import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.HashMap;

public class Dienblad {
    private Stack<Artikel> artikelen;
    Persoon klant;

    /**
     * Constructor zonder parameter
     */
    public Dienblad() {
        artikelen = new Stack<Artikel>();
    }

    //constructor met parameter klant (b)
    public Dienblad(Persoon klant) {
        artikelen = new Stack<Artikel>();
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
        artikelen.push(artikel);

    }

    /**
     * Methode om de Stack artikelen op dienblad te krijgen
     *
     * @return De artikelen
     */
    public Iterator<Artikel> getArtikelen() {
        return artikelen.iterator();
    }
}





