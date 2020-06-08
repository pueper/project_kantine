public class TeWeinigGeldException extends Exception{

    private String naam;

    public void TeWeingigGeldException() {

    }

    public void TeWeingigGeldException(Exception e) {

    }

    public void TeWeingigGeldException(String message) {
        naam = message;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String toString() {
        return naam + "heeft niet genoeg geld.";
    }
}