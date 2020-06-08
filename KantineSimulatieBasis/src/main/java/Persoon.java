import java.util.*;
public class Persoon {
    // random generator
    private Random random;

    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;
    private Betaalwijze betaalwijze;

    public Persoon() {
        bsn = 0;
        voornaam = "";
        achternaam = "";
        geboortedatum = new Datum();
        geslacht = 'o';
    }

    public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setGeslacht(geslacht);

    }

    /*
     * getter voor geslacht, waarbij de uitkomst een string is, niet een char zoals in het geslacht-veld opgeslagen
     *
     * @return geslacht
     */
    public String getGeslacht() {
        String uitkomst;
        if (geslacht == 'V') {
            uitkomst = "Vrouw";
        } else if(geslacht == 'M') {
            uitkomst = "Man";
        } else {
            uitkomst = "Onbekend";
        }
        return uitkomst;
    }

    /*
     * setter voor geslacht, inclusief check
     */
    public void setGeslacht(char geslacht) {
        geslacht = Character.toUpperCase(geslacht);
        if ((geslacht == 'V') || (geslacht == 'M')) {
            this.geslacht = geslacht;
        } else {        //iets met de waarde doen om duidelijk te maken dat de controle mislukt?
            this.geslacht = 'o';
            System.out.println("Vul een 'V' voor vrouwelijk of een 'M' voor mannelijk in.");
        }
    }

    /*
     * getter voor geboortedatum, inclusief check
     *
     * @return geboortedatum(als check = true)/"onbekend"
     */
    public String getGeboortedatum() {
        if(!geboortedatum.bestaatDatum(geboortedatum.getDag(), geboortedatum.getMaand(), geboortedatum.getJaar())){
            return "Onbekend";
        }
        return geboortedatum.getDatumAsString();
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

    public String getVolledigeNaam() {
        return voornaam + achternaam;
    }

    public int getBsn() {
        return bsn;
    }

    public void setBsn(int bsn) {
        this.bsn = bsn;
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    public String toString() {
        return bsn + ", " + voornaam + " " + achternaam + ", " + getGeboortedatum() + ", " + getGeslacht();
    }
}