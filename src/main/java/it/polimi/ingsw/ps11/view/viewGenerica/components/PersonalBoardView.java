package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class PersonalBoardView extends ViewComponent {

	protected CardManager cardManager;
	
	public PersonalBoardView() {
		
	}
	
	public void update(CardManager cardManager){
		this.cardManager = cardManager;	
	}
}
