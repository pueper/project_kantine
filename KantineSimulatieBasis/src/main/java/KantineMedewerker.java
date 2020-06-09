public class KantineMedewerker extends Persoon implements KortingskaartHouder{

    private int medewerkerNummer;
    private boolean kassaDienst;

    /*
     * constructor zonder parameters
     */
    public KantineMedewerker() {
        medewerkerNummer = 0;
        kassaDienst = false;
    }

    /*
     * constructor met parameters
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
    public boolean isEenKortingskaartHouder(){return true;}

    public double geefKortingsPercentage(){
        return 0.35;
    }

    public boolean heeftMaximum(){
        return false;
    }

    public double geefMaximum(){
        return 300.00;
    }
}