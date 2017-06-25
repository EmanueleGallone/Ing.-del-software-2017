package it.polimi.ingsw.ps11.model.bonus.ema.actionsEma;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class PlaceFamilyProductionSingleSpace extends Action {
	
	private FamilyMember familiareScelto;
	private Yield production;
	private Player player;
	
	public PlaceFamilyProductionSingleSpace(FamilyMember familiareScelto,Player player, Yield production) {
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
	
	public void setProduction(Yield production) {
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
