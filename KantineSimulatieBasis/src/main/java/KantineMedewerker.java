public class KantineMedewerker extends Persoon{

    private int medewerkerNummer;
    private boolean kassaDienst;

    /*
     * constructor
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkerNummer, boolean kassaDienst) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkerNummer = medewerkerNummer;
        this.kassaDienst = kassaDienst;
    }

    //getters en setters

    public int getMedewerkerNummer() {
        return medewerkerNummer;
    }

    public void setMedewerkerNummer(int medewerkerNummer) {
        this.medewerkerNummer = medewerkerNummer;
    }

    public boolean isKassaDienst() {
        return kassaDienst;
    }

    public void setKassaDienst(boolean kassaDienst) {
        this.kassaDienst = kassaDienst;
    }
}