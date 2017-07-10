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
	
	/*
	 * effetti che mancano:
	 * -Per ogni 5 punti vittoria, ne toglie uno.
	 * -Per ogni risorsa che ha il player, a fine partita viene tolto un punto vittoria.
	 * -Per ogni punto militare, a fine partita, viene tolto un punto vittoria (analogo al precedente quindi)
	 * -Per aumentare il valore di un familiare, bisogna usare 2 familiari invece di 1 (Facile)
	 * -Non puoi più posizionare nel Market (Facile)
	 * -Ad ogni nuova aggiunta di una risorsa (Stone,Coin,MilitaryPoint,Wood,Servant) ne devi togliere 1.
	 * -a fine partita, non prendi più i punti vittoria dalle carte (Gialle,Blu,Viola e verdi) (immagino basti settare a 0 i VictoryPoint di tutte le carte inerenti la scomunica, nel cardManager del player)
	 * 
	 * Aggiungo qui gli effetti che mancano solo per due carte Sviluppo: Per ogni punto militare hai 2 punti vittoria (BlueCard "General")
	 * la blueCard "Preacher" come effetto permanente ha che non prendi più le risorse da uno spazio azione
	 */
	
	
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
