package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class CardManagerView extends ViewComponent {

	protected CardManager cardManager;

	protected static final int CARDTYPES = 4; 
	
	public void update(CardManager cardManager){
		this.cardManager = cardManager;	
	}
}
