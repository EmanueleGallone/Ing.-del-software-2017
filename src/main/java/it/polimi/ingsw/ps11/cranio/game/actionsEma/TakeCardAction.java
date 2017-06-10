package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.bonus.GetAnotherCardBonus;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class TakeCardAction extends Action {
	
	private DevelopmentCard cartaScelta;
	
	public TakeCardAction(DevelopmentCard cartaScelta) {
		this.cartaScelta = cartaScelta;
	}

	@Override
	public void perform() {
		// codice per far prendere una nuova carta

	}

	@Override
	public boolean isLegal() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void perform(GetAnotherCardBonus bonus){
		
		//chiama view e chiedi quale carta vuole prendere.
		//a questo punto qualcuno creerà l'azione salvando la carta scelta all'interno di questa classe e poi:
		// this.cartaScelta.take(bonus.getPlayer());
	}

}
