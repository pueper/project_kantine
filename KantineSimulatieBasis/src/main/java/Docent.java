public class Docent extends Persoon implements KortingskaartHouder{

    private String afkorting;
    private String afdeling;

    /*
     * constructor zonder parameters
     */
    public Docent() {
        afkorting = "lul";
        afdeling = "onderwijs";
    }

    /*
     * constructor met parameters
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

    public boolean isEenKortingskaartHouder(){
        return true;
    }

    public double geefKortingsPercentage(){
        return 0.25;
    }

    public boolean heeftMaximum(){
        return true;
    }

    public double geefMaximum(){
        return 1.00;
    }


}