package it.polimi.ingsw.ps11.model.excommunications;

import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;
/**
 * <h3>Excommunication</h3>
 * <p>
 * Classe astratta che rappresenta le scomuniche del gioco.
 * </p>
 *
 */
public abstract class Excommunication {
	
	/*
	 * effetti che mancano:
	 * -Per ogni 5 punti vittoria, ne toglie uno.
	 * -Per ogni risorsa che ha il player, a fine partita viene tolto un punto vittoria.
	 * -Per ogni punto militare, a fine partita, viene tolto un punto vittoria (analogo al precedente quindi)
	 * -Per aumentare il valore di un familiare, bisogna usare 2 familiari invece di 1 (Facile)
	 * -Non puoi più posizionare nel Market (Facile)
	 * -Ad ogni nuova aggiunta di una risorsa (Stone,Coin,MilitaryPoint,Wood,Servant) ne devi togliere 1.
	 * -Ogni volta che attivi la zona produzione o raccolta, hai -3 sul familiare posizionato.
	 * -a fine partita, non prendi più i punti vittoria dalle carte (Gialle,Blu,Viola e verdi) (immagino basti settare a 0 i VictoryPoint di tutte le carte inerenti la scomunica, nel cardManager del player)
	 * 
	 * Aggiungo qui gli effetti che mancano solo per due carte Sviluppo: Per ogni punto militare hai 2 punti vittoria (BlueCard "General")
	 * la blueCard "Preacher" come effetto permanente ha che non prendi più le risorse da uno spazio azione
	 */
	
	
	protected int period;
	protected Effect effect;
	
	public Effect getEffect() {
		return effect;
	}
	public int getPeriod() {
		return period;
	}
	
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	@Override
	public abstract Excommunication clone();

}
