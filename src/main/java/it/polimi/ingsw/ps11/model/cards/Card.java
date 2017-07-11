package it.polimi.ingsw.ps11.model.cards;

import java.io.Serializable;

/**
 * <h3>Card</h3>
 * <p> Classe astratta che modella qualsiasi tipo di carta. Identificata da una string per il nome. Può esserre di tipo DevelopmentCard o
 * LeaderCard.</p>
 * <p>Il costruttore accetta: string (nome della carta).</p>
 * @see DevelopmentCard
 */
public abstract class Card implements Serializable{
	
	protected String name = "Default"; //Va visto come un identificatore unico
	private String id;
	
	public Card(String id) {
		this.id = id;
	}
	
	public Card(String id, String name) {
		this(id);
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
	
	public String getId() {
		return id;
	}
	
	
//End getters
	
	@Override
	public abstract Card clone();
	
	@Override
	public abstract boolean equals(Object obj);
	
}