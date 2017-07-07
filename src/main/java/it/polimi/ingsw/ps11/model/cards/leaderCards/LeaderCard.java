package it.polimi.ingsw.ps11.model.cards.leaderCards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.cards.leaderCards.requires.Requirement;
import it.polimi.ingsw.ps11.model.player.Player;

public class LeaderCard extends Card implements Requirement{

	
	private ArrayList<Requirement> requirements = new ArrayList<>();
	private ArrayList<Effect> effects = new ArrayList<>();
	private boolean activated = false;
	
	
	public LeaderCard() {
		//apparantemente inutile
		super();
	}
	
	public LeaderCard(String name) {
		super(name);
	}
	
	@Override
	public boolean isSatisfied(Player player) {
		if(activated)
			return true;
		
		for(Requirement r : requirements){
			if(!r.isSatisfied(player))
				return false;
		}
		return true;
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
	
	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((DevelopmentCard) obj).getName()))
				return true;
		return false;
	}

	
	@Override
	public LeaderCard clone() {
		LeaderCard clone = new LeaderCard(this.name);
		
		clone.requirements.addAll(this.requirements);
		clone.effects.addAll(this.effects);
		
		clone.activated = this.activated;
				
		return clone;
	}

}
