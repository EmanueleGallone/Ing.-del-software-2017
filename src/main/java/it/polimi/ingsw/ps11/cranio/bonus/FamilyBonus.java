package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class FamilyBonus extends Bonus{

	private int value;
	private Tower tower;
	
	public FamilyBonus(Tower tower, int value) {
		this.value = value;
		this.tower = tower;
	}
	
	
	@Override
	public void behavior(Player player) {
		
	}
	
	
}
