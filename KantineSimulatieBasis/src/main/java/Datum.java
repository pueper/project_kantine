public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	//parameterloze constructor. zet alle velden op 0
	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	//constructor met parameters, inclusief datum-check
	public Datum(int dag, int maand, int jaar) {
		if(bestaatDatum(dag, maand, jaar)){
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	/**
	 * Constructor
	 */



	public boolean bestaatDatum(int dag, int maand, int jaar) {
		if((jaar > 2100) || (jaar < 1900)){		//check voor jaar
			return false;
		}
		if((maand > 12) || (maand < 1)){			//check voor maand
			return false;
		}
		int maxDagen = 0;						//het maximum aantal dagen van een maand, dit wordt in de switch ingesteld.
		switch(maand) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				maxDagen = 31;
				break;
			case 4: case 6: case 9: case 11:
				maxDagen = 30;
				break;
			case 2:
				if(((jaar % 4 == 0) && !(jaar % 100 == 0)) || (jaar % 400 == 0)) {
					maxDagen = 29;
				}
				else {
					maxDagen = 28;
				}
				break;
		}
		if((dag > maxDagen) || (dag < 1)){	//check voor dag
			return false;
		}
		return true;
	}

	/**
	 * Getter voor String weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		String stringMaand;
		switch(maand) {
			case 1: stringMaand = "Januari";
				break;
			case 2: stringMaand = "Februari";
				break;
			case 3: stringMaand = "Maart";
				break;
			case 4: stringMaand = "April";
				break;
			case 5: stringMaand = "Mei";
				break;
			case 6: stringMaand = "Juni";
				break;
			case 7: stringMaand = "Juli";
				break;
			case 8: stringMaand = "Augustus";
				break;
			case 9: stringMaand = "September";
				break;
			case 10: stringMaand = "Oktober";
				break;
			case 11: stringMaand = "November";
				break;
			case 12: stringMaand = "December";
				break;
			default: stringMaand = "Onbekend";
				break;
		}
		return dag + " " + stringMaand + " " + jaar;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}
}
