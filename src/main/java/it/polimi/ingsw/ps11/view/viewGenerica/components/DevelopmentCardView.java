package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class DevelopmentCardView extends ViewComponent {

	protected DevelopmentCard developmentCard;
	
	public void update(DevelopmentCard card){
		this.developmentCard = card;
	}

}
