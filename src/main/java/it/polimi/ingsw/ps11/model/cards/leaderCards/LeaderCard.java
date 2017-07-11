package it.polimi.ingsw.ps11.model.cards.leaderCards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.cards.leaderCards.requires.Requirement;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3> LeaderCard </h3>
 * <p> Classe che rappresenta le carte leader del gioco. Vengono assegnate ad ogni giocatore all'inizio di ogni partita in maniera casuale
 * , hanno un requisito per l'attivazione e comportano un bonus cha varia da carta a carta. Possono essere attivate una sola volta per turno.</p>
 * @param  Hashmap <String, int> (Id delle carte, quantità delle carte).</p>
 * @see ActionManager
 */
@SuppressWarnings("serial")
public class LeaderCard extends Card implements Requirement{
	
	private static final String id= "LeaderCard";
	
	private ArrayList<Requirement> requirements = new ArrayList<>();
	private ArrayList<Effect> effects = new ArrayList<>();
	private boolean satisfied = false, activated = false;
	
	public LeaderCard(String name) {
		super(id,name);
	}
	
	@Override
	public boolean isSatisfied(Player player) {
		if(satisfied)
			return true;
		
		for(Requirement r : requirements){
			if(!r.isSatisfied(player))
				return false;
		}
		setSatisfied(true);
		return true;
	}
	
	public void active(ActionManager aManager){
		for(Effect effect: effects){
			Action action = effect.get(aManager);
			if(action.isLegal()){
				action.perform();
				this.setActivated(true);
			}
		}
	}
	
	public void addRequirement(Requirement requirement){
		this.requirements.add(requirement);
	}
	
	public void addEffect(Effect effect){
		this.effects.add(effect);
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public void setSatisfied(boolean satisfied) {
		this.satisfied = satisfied;
	}
	
	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((LeaderCard) obj).getName()))
				return true;
		return false;
	}

	
	@Override
	public LeaderCard clone() {
		LeaderCard clone = new LeaderCard(this.name);
		
		clone.requirements.addAll(this.requirements);
		clone.effects.addAll(this.effects);
		
		clone.satisfied = this.satisfied;
				
		return clone;
	}

}
