package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.cranio.game.actions.PlaceFamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Production;

public class EnableProductionBonus extends Bonus {
	
	private Production production;
	private int productionActiveValue;
	
	public EnableProductionBonus(int productionActiveValue) {
		production = new Production();
		this.productionActiveValue = productionActiveValue;
	}

	@Override
	public void behavior() {
		
		Player player = getOwner();
		WhiteFamilyMember temporaryFamilyMember = new WhiteFamilyMember(player);
		temporaryFamilyMember.setValue(productionActiveValue);
		//production.placeFamilyMember(temporaryFamilyMember);
		//PlaceFamilyMember placeFamilyMember = new PlaceFamilyMember(temporaryFamilyMember, spazio azione della zona produzione);
	}
	
	

}
