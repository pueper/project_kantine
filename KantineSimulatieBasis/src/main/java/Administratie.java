public class Administratie {

    private static final int DAYS_IN_WEEK = 7;
    /*
     * private constructor, kan niet aangeroepen worden.
     */
    private Administratie(){}

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        if(aantal.length == 0){
            return 0;
        }
        double totaal = 0;
        for(int i = 0; i < aantal.length; i++) {
            totaal = totaal + aantal[i];
        }
        return totaal/aantal.length;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        if(omzet.length == 0){
            return 0;
        }
        double totaal = 0;
        for(int i = 0; i < omzet.length; i++) {
            totaal = totaal + omzet[i];
        }
        return totaal/omzet.length;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            while (i + DAYS_IN_WEEK * j < omzet.length) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j += 1;


            }
        }
        return temp;
    }
}
