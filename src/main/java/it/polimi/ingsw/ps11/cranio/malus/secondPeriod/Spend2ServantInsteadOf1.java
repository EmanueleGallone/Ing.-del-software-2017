package it.polimi.ingsw.ps11.cranio.malus.secondPeriod;

import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class Spend2ServantInsteadOf1 extends Excommunication {
	
	public Spend2ServantInsteadOf1(Player player) {
		this.owner = player;
		setPeriod(2);
	}

	@Override
	public void behaviour() {
		// come lo faccio?
		
	}

}
