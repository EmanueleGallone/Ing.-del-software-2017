package it.polimi.ingsw.ps11.cranio.cards;

import it.polimi.ingsw.resources.*;

public class BlueCard extends DevelopmentCard {
	//carte PERSONAGGI
	
	public BlueCard(){
		this.name="Carta Blu 1";
		this.period=1;
		this.resourceAffected=new Stone();
		this.resourceAffected.setValue(5);
		this.description="aumenta il tuo legname di "+resourceAffected.getValue();
		this.requirements=new Coin();
		requirements.setValue(5);
		}

	@Override
	public String toString() {
		return "BlueCard [name=" + name + ", resourceAffected=" + resourceAffected
				+ ", description=" + description + ", requirements=" + requirements + ", period=" + period + "]";
	}
	
	

}
