package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class UseServant extends PlayerAction {
	
	public UseServant(Player player) {
		super(player);
	}

	@Override
	public void perform() {
		// codice per usare i servitori

	}

	@Override
	public boolean isLegal() {
		// if( getPlayer.getResourceList(Servant.class).getValue > 0 )
		//	return true;
		return false;


	}
}
