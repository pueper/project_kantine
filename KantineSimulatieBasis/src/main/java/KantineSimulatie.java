import java.util.*;

public class KantineSimulatie {

    // administratie
    private Administratie administratie;

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    //aantal dagen
    public static final int DAGEN = 7;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    //verhouding van soorten personen
    private static final int AANTAL_STUDENTEN = 89;
    private static final int AANTAL_DOCENTEN = 10;
    private static final int AANTAL_KANTINEMEDEWERKERS = 1;

    //saldo en kredietlimiet van personen
    private static final int MIN_SALDO = 5;
    private static final int MAX_SALDO = 100;
    private static final int MIN_KREDIET = 0;
    private static final int MAX_KREDIET = 100;


    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
       // administratie = new Administratie();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        double[] omzet = new double[dagen];
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
            //dagaanduiding
            System.out.println("Dag " + (i+1));
            //ArrayList personen
            ArrayList<Persoon> klanten = new ArrayList<>();
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalPersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            for(int j = 0; j < aantalPersonen; j++){
                int r = getRandomValue(1, AANTAL_STUDENTEN + AANTAL_DOCENTEN + AANTAL_KANTINEMEDEWERKERS);

                if(r <= AANTAL_KANTINEMEDEWERKERS){
                    klanten.add(new KantineMedewerker());
                }
                else if(r <= AANTAL_STUDENTEN + AANTAL_KANTINEMEDEWERKERS){
                    klanten.add(new Student());
                }
                else if(r <= AANTAL_DOCENTEN + AANTAL_STUDENTEN + AANTAL_KANTINEMEDEWERKERS){
                    klanten.add(new Docent());
                }
            }

            //pak een persoon uit de arraylist, koppel er een dienblad aam
            for (Persoon klant : klanten){
                //betaalwijze voor persoon instellen
                int rando = getRandomValue(1, 2);
                Betaalwijze type;
                if(rando == 1){
                    Contant temp = new Contant();
                    type = temp;
                } else {
                    Pinpas temp = new Pinpas();
                    temp.setKredietLimiet(getRandomValue(MIN_KREDIET, MAX_KREDIET));
                    type = temp;
                }

                type.setSaldo(getRandomValue(MIN_SALDO, MAX_SALDO));
                klant.setBetaalwijze(type);
                Dienblad dienblad = new Dienblad(klant);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                int dagaanbieding = getRandomValue(0,aantalartikelen);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }

            // verwerk rij voor de kassa
            try {
                kantine.verwerkRijVoorKassa();
            }
            catch(TeWeinigGeldException e) {
            }

            int verkochteArtikelenDagelijks = kantine.getKassa().aantalArtikelen();
            double omzetDagelijks = kantine.getKassa().hoeveelheidGeldInKassa();


            // druk de dagtotalen af en hoeveel personen binnen zijn gekomen
            System.out.println("Aantal verkochte artikelen: " + verkochteArtikelenDagelijks);
            System.out.println("Aantal personen: " + aantalPersonen);
            System.out.println("De omzet was: " + omzetDagelijks);
            System.out.println();
            // noteer dagomzet
            omzet[i] = omzetDagelijks;
            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
        }
        double[] dagomzet = Administratie.berekenDagOmzet(omzet);
        System.out.println();
        System.out.println("Maandagen: " + dagomzet[0]);
        System.out.println("Dinsdagen: " + dagomzet[1]);
        System.out.println("Woensdagen: " + dagomzet[2]);
        System.out.println("Donderdagen: " + dagomzet[3]);
        System.out.println("Vrijdagen: " + dagomzet[4]);
        System.out.println("Zaterdagen: " + dagomzet[5]);
        System.out.println("Zondagen: " + dagomzet[6]);
        System.out.println("Gemiddelde omzet: " + Administratie.berekenGemiddeldeOmzet(omzet));

    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        KantineSimulatie simulatie = new KantineSimulatie();
        simulatie.simuleer(dagen);
    }
}
