package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;

public abstract class DevelopmentCardView extends CardView{

	protected DevelopmentCard developmentCard;
	
	public void update(DevelopmentCard card){
		this.developmentCard = card;
	}

}
