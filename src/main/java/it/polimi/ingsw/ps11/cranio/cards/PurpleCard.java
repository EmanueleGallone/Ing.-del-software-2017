package it.polimi.ingsw.ps11.cranio.cards;

import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.Wood;

public class PurpleCard extends DevelopmentCard {
	//carte IMPRESE
	
	public PurpleCard(){
		this.name="Carta Viola 1";
		this.period=1;
		this.resourceAffected=new Coin();
		this.resourceAffected.setValue(5);
		this.description="aumenta il tuo legname di "+resourceAffected.getValue();
		this.requirements=new Wood();
		requirements.setValue(5);
		}

	@Override
	public String toString() {
		return "PurpleCard [name=" + name + ", resourceAffected=" + resourceAffected
				+ ", description=" + description + ", requirements=" + requirements + ", period=" + period + "]\n";
	}
	
	

}
