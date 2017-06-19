package it.polimi.ingsw.ps11.model.cards;
/**
 * <h3>Card</h3>
 * <p> Classe che modella qualsiasi tipo di carta </p>
 *
 */
public abstract class Card{
	
	protected String name; //Va visto come un identificatore unico
	
	
	
	public Card() {
	}
	
	public Card(String name) {
		this.name = name;
	}
	
//Start setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
//End setters
//Start getters
	public String getName() {
		return name;
	}
	
	
//End getters
	
	@Override
	public abstract Card clone();
	
	@Override
	public abstract boolean equals(Object obj);
	
}