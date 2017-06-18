package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class CardView extends ViewComponent {

	protected Card card;
	
	public void update(Card card){
		this.card = card;
	}
	
}
