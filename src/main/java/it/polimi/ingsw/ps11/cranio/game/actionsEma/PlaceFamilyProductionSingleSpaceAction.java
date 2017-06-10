package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Production;

public class PlaceFamilyProductionSingleSpaceAction extends Action {
	
	private FamilyMember familiareScelto;
	private Production production;
	private Player player;
	
	public PlaceFamilyProductionSingleSpaceAction(FamilyMember familiareScelto,Player player, Production production) {
		this.familiareScelto = familiareScelto;
		this.production = production;
		this.player = player;
	}

	@Override
	public void perform() {
		//this.production.activeCard(familiareScelto,player);

	}

	@Override
	public boolean isLegal() {
		return false;
	}
	
	//start setters
	
	public void setProduction(Production production) {
		this.production = production;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setFamiliareScelto(FamilyMember familiareScelto) {
		this.familiareScelto = familiareScelto;
	}
	
	//end setters
	
	

}
