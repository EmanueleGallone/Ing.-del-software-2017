package it.polimi.ingsw.ps11.cranio.actions.affecter;

import it.polimi.ingsw.ps11.cranio.actions.ActionObserver;
import it.polimi.ingsw.ps11.cranio.actions.list.player.FamilyInFloorAction;
import it.polimi.ingsw.ps11.cranio.actions.list.player.FamilyInTowerAction;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class FamilyInTowerBonus implements ActionObserver<FamilyInTowerAction> {

	
	/*
	 *	E' quel bonus che se il familiare si piazza in una torre viola ha un +2 al valore 
	 */
	
	private String tower;
	private int value;
	
	public FamilyInTowerBonus(Class<? extends Tower> tower, int value) {
		this.tower = tower.toString();
		this.value = value;
	}
	
	@Override
	public void affectPerform(FamilyInTowerAction action) {
		
	}
	
	@Override
	public boolean affectCondiction(FamilyInTowerAction action) {
		//if(action.getActionSpace())
		return true;
	}
	
}
