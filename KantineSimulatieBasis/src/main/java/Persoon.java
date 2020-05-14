public class Persoon {

    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;

    public char getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(char geslacht) {
        geslacht = toUpperCase(geslacht);
        if ((geslacht = 'V') || (geslacht = 'M')) {
            this.geslacht = geslacht;
        } else {
            System.out.println("Vul een 'V' voor vrouwelijk of een 'M' voor mannelijk in.");
        }
    }

    public Datum getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public int getBsn() {
        return bsn;
    }

    public void setBsn(int bsn) {
        this.bsn = bsn;
    }
}