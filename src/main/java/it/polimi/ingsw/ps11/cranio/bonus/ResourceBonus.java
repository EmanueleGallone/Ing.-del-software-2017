package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class ResourceBonus extends Bonus {
	
	private int target;
	private int value;
	
	public ResourceBonus(int resourceID,int value) {
		this.target = resourceID;
		this.value = value;
	}

	@Override
	public void behavior(Player player) {
		player.getResources().getResourceById(target).increment(value);
	}
	
}
