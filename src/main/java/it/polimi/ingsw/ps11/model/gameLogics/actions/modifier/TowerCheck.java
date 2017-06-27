package it.polimi.ingsw.ps11.model.gameLogics.actions.modifier;

import java.util.Optional;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction.DecrementResource;
import it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction.PlaceFamilyInSpace;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class TowerCheck extends ActionDecorator<PlaceFamilyInSpace>{

	private Tower tower;
	private FamilyMember familyMember;
	
	private ResourceList taxIfNotFree = new ResourceList(new Coin(3));
	
	public TowerCheck(PlaceFamilyInSpace action, Tower tower) {
		super(action);
		familyMember = action.getFamilyMember();
	}

	@Override
	public void perform() {
		action.perform();
	}

	@Override
	public boolean isLegal() {
		boolean result = true;
		
		if(!familyMember.isNeutral() && contains(tower, action.getSource())){
			return false;
		}
		if(!tower.isFree()){
			
			DecrementResource decrement = new DecrementResource(action.getSource(), taxIfNotFree);
			Action tax = decrement.enable(action.getSource().actions());
			result = tax.isLegal();
		}
		return result && action.isLegal();
	}
	
	@Override
	public TowerCheck decore(PlaceFamilyInSpace action) {
		this.action = action;
		return this;
	}
	
	@Override
	public Action enable(ActionManager aManager) {
		Optional<ActionDecorator<TowerCheck>> optional = aManager.get(TowerCheck.class);
		if(optional.isPresent())
			return optional.get().decore(this);
		return this;
	}
	
	public boolean contains(Tower tower, Player player){
		// Ritorna true se c'e' un familyMember di un giocatore che non sia il familiare neutro
		for(Floor floor : tower.getFloors()){
			ActionSpace aSpace = floor.getActionSpace();
			if (aSpace.getOwner().equals(player) && !aSpace.getFamilyMember().isNeutral()){
				return true;
			}
		}
		return false;
	}
}