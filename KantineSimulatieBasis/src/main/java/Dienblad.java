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
        ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
    }

    //constructor met parameter klant (b)
    public Dienblad(Persoon klant) {
        Stack<Artikel> artikelen = new Stack<Artikel>();
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
     * Methode om de Stack artikelen op dienblad te krijgen
     *
     * @return De artikelen
     */
    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }
}





