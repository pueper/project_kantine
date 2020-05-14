public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

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
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
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
