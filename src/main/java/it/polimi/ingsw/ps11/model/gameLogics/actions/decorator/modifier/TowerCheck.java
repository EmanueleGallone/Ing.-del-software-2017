package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.modifier;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.PlayerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction.DecrementResource;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction.PlaceFamilyInSpace;
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
			
			DecrementResource tax = new DecrementResource(action.getSource(), taxIfNotFree);
			ActionDecorator<DecrementResource> decorator = action.getSource().actions().get(DecrementResource.class);
			result = decorator.decore(tax).isLegal();
		}
		return result && action.isLegal();
	}
	
	@Override
	public TowerCheck decore(PlaceFamilyInSpace action) {
		return new TowerCheck(action, tower);
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
