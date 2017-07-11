package it.polimi.ingsw.ps11.model.excommunications;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.cards.effects.Effect;
/**
 * <h3>Excommunication</h3>
 * <p> Classe astratta che rappresenta le scomuniche del gioco. </p>
 */
public class Excommunication implements Serializable,Iterable<Effect>{
	
	private String id;
	private int period;
	private ArrayList<Effect> effect = new ArrayList<>();
	
	
	public Excommunication(String id, int period) {
		this.id = id;
		this.period = period;
	}
	
	public Effect getEffect(int index) {
		return effect.get(index);
	}
	
	public int getPeriod() {
		return period;
	}
	
	public void addEffect(Effect effect) {
		this.effect.add(effect);
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public Excommunication clone(){
		Excommunication clone = new Excommunication(this.id, this.period);
		
		clone.effect.addAll(this.effect);
		
		return clone;
		
	}

	@Override
	public Iterator<Effect> iterator() {
		
		return effect.iterator();
	}

}
