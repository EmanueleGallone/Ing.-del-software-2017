package it.polimi.cards;

import it.polimi.ingsw.resources.*;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO
	
	public YellowCard(){
	this.name="Carta gialla 1";
	this.period=1;
	this.colour=Colour.YELLOW;
	this.resourceAffected=new Wood();
	this.resourceAffected.setValue(5);
	this.description="aumenta il tuo legname di "+resourceAffected.getValue();
	this.requirements=new Stone();
	this.requirements.setValue(5);
	}
	
	public YellowCard(String name){
		this.name = name;
		this.period = 1;
		this.colour = Colour.YELLOW;
		this.resourceAffected = new Stone();
		this.resourceAffected.setValue(10);
		this.requirements = new Stone();
		this.requirements.setValue(5); //richiede 5 stone per prendere la carta.
		
	}

	@Override
	public String toString() {
		return "YellowCard [name=" + name + ", colour=" + colour + ", \n resourceAffected=" + resourceAffected
				+ ", requirements=" + requirements + ", period=" + period + "\ndescription= "+ description +" ]";
	}
	
	

	

	
	
	

}
