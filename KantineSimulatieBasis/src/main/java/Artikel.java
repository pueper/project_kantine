import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Artikel")
public class Artikel {
    //aanmaak velden
    @Id
    private String naam;
    private double prijs;
    private double korting;

    //constructor met parameter C
    public Artikel(String naam, double prijs, double korting){
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }

    //constructor zonder parameter korting
    public Artikel(String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs;
        korting = 0;
    }

    //getters en setters E
    public String getNaam(){
        return naam;
    }

    public double getPrijs(){
        return prijs;
    }

    public double getKorting(){return korting;}

    public void setNaam(String newNaam){
        this.naam = newNaam;
    }

    public void setPrijs(int newPrijs){
        this.prijs = newPrijs;
    }

    public void setKorting(double newKorting){this.korting = newKorting;}

    public String toString() {
        return naam + ", " + prijs;
    }

}

//Declaratie : Het opzetten van de variabele, het type en de naam van de variabele voor de eerste keer weergeven
//Initialisatie: Een waarde geven aan een variabele.
//Een variabele moet gedeclareerd zijn voordat deze geïnitialiseerd kan worden.