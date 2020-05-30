public class Docent extends Persoon{

    private String afkorting;
    private String afdeling;

    /*
     * constructor
     */
    public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String afkorting, String afdeling) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.afdeling = afdeling;
        this.afkorting = afkorting;
    }

    //getters en setters
    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}