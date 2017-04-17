package it.polimi.cards;

import it.polimi.ingsw.resources.*;

public class BlueCard extends DevelopmentCard {
	
	public BlueCard(){
		this.name="Carta Blu 1";
		this.period=1;
		this.colour=Colour.BLUE;
		this.resourceAffected=new Stone();
		this.resourceAffected.setValue(5);
		this.description="aumenta il tuo legname di "+resourceAffected.getValue();
		this.requirements=new Coin();
		requirements.setValue(5);
		}

	@Override
	public String toString() {
		return "BlueCard [name=" + name + ", colour=" + colour + ", resourceAffected=" + resourceAffected
				+ ", description=" + description + ", requirements=" + requirements + ", period=" + period + "]";
	}
	
	

}
