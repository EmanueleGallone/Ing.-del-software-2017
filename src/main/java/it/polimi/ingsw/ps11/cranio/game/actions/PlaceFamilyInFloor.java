package it.polimi.ingsw.ps11.cranio.game.actions;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class PlaceFamilyInFloor implements Action {

	private transient Class<Tower> tower;
	private int whichFloor;
	private transient Player player;
	
	public PlaceFamilyInFloor(Class<Tower> tower, int i, Player player) {
		this.tower = tower;
		this.whichFloor = i;
		this.player = player;
	}
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLegal() {
		
		return false;
	}

	@Override
	public void accept(ActionVisitor visitor) {
		//visitor.visit(this);
	}

}
