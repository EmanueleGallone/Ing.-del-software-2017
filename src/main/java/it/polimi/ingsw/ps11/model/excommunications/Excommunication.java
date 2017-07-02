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
