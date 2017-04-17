package it.polimi.cards;

import it.polimi.ingsw.resources.*;

public class YellowCard extends DevelopmentCard {
	
	public YellowCard(){
	this.name="Carta gialla 1";
	this.period=1;
	this.colour=Colour.YELLOW;
	this.resourceAffected=new Wood();
	this.resourceAffected.setValue(5);
	this.description="aumenta il tuo legname di "+resourceAffected.getValue();
	this.requirements=new Stone();
	requirements.setValue(5);
	}

	@Override
	public String toString() {
		return "YellowCard [name=" + name + ", colour=" + colour + ", \n resourceAffected=" + resourceAffected
				+ ", requirements=" + requirements + ", period=" + period + "\ndescription= "+ description +" ]";
	}
	
	

	

	
	
	

}
