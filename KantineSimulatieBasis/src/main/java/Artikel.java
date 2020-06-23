import javax.persistence.*;


@Embeddable
@namedQuery (name = "Artikel.totalen",
             query = "select naam, totaal, sum(korting) from Artikel group by id")
@namedQuery (name = "Artikel.totalenPerDag",
             query = "select naam, totaal, sum(korting), from Artikel where datum is curdate() - interval 1 day group by id")
@namedQuery (name = "top3Populariteit",
             query = "from Artikel group by id order by aantal desc")
@namedQuery (name = "top3Omzet",
             query = "from Artikel order by totaal desc")

public class Artikel {
    //aanmaak velden

    @Column(name = "artikel_naam")
    private String naam;

    @Column(name = "artikel_prijs")
    private double prijs;

    @Column(name = "artikel_korting")
    private double korting;

    public Artikel() {}

    //constructor zonder parameter korting
    public Artikel(String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs;
        korting = 0;
    }

    //constructor met parameter C
    public Artikel(String naam, double prijs, double korting){
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
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