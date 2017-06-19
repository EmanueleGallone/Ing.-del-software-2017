package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionObserver;
import it.polimi.ingsw.ps11.model.gameLogics.actions.list.player.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInFloorBonus implements ActionObserver<FamilyInFloorAction> {
	/*
	 *	E' quel bonus che se il familiare si piazza in una torre viola ha un +2 al valore 
	 */
	
	private String tower;
	private int value;
	
	public FamilyInFloorBonus(Class<? extends Tower> tower, int value) {
		this.tower = tower.toString();
		this.value = value;
	}

	@Override
	public void affectPerform(FamilyInFloorAction action) {
		
	}
	
	@Override
	public boolean affectCondiction(FamilyInFloorAction action) {
		String towerType = action.getTower().getClass().toString();
		if(towerType.equals(tower)){
			// Il getFamilyMember della action restituisce un familiare di supporto 
			action.getFamilyMember().setModifier(value); 
		}
		return true;
	}
	
	
}
