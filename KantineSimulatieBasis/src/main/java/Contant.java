public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        if(tebetalen <= saldo){
            return true;
        }
        return false;
    }
}
