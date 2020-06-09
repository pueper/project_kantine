public class Student extends Persoon{

    private int studentNummer;
    private String studierichting;

    /*
     * constructor zonder parameters
     */
    public Student() {
        studentNummer = 0;
        studierichting = "onderwijs";
    }

    /*
     * constructor met parameters
     */
    public Student(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentNummer, String studierichting) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.studentNummer = studentNummer;
        this.studierichting = studierichting;

    }

    //getters en setters
    public int getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    public boolean isEenKortingskaartHouder(){return false;}

}