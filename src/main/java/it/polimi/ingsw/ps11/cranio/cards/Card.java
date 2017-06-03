package it.polimi.ingsw.ps11.cranio.cards;

public abstract class Card{
	
	protected String name; //Va visto come un identificatore unico
	
	protected int period;
	
	public Card() {
		//E i vari parametri, periodo,colore, ecc..
	}
	
//Start setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	
//End setters
//Start getters
	public String getName() {
		return name;
	}
	
	public int getPeriod() {
		return period;
	}
	
	
//End getters
	
}