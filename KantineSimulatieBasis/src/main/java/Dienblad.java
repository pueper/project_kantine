import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.HashMap;

public class Dienblad {
    public static void main(String[] args) {
        private ArrayList<Artikel> artikelen;
        private HashMap<Artikel, prijs> prijslijst;
        /**
         * Constructor
         */
    public Dienblad() {
            ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
            HashMap<Artikel, prijs> prijslijst = new HashMap<Artikel, prijs>();
        }

        /**
         * Methode om artikel aan dienblad toe te voegen
         *
         * @param artikel
         */
        public void voegToe (Artikel artikel){
            artikelen.add(artikel);

        }

        /**
         * Methode om aantal artikelen op dienblad te tellen
         *
         * @return Het aantal artikelen
         */
        public int getAantalArtikelen () {
            aantal = artikelen.size();
            return aantal;
        }

        /**
         * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
         *
         * @return De totaalprijs
         */
        public double getTotaalPrijs () {
            double totaal = 0;
            if (artikel in artikelen) {
                for (double i : prijslijst.values(); i > totaal; i++) {
                    return totaal;
                    }

                }
            }
        }
    }
}


