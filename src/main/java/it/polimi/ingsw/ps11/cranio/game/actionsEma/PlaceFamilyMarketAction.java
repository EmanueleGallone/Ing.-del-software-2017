package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.malus.ActionConditionAffecter;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Market;

public class PlaceFamilyMarketAction extends PlayerAction {
	
	private FamilyMember familyMember;
	private Market market;
	private int actionSpace;
	
	public PlaceFamilyMarketAction(Player player,FamilyMember familyMember, Market market, int actionSpace) {
		super(player);
		this.familyMember = familyMember;
		this.market = market;
		this.actionSpace = actionSpace;
	}

	@Override
	public void perform() {
		
	}

	@Override
	public boolean isLegal() {
		//if( market.getActionSpace(actionSpace).isFree() ); controlla se lo spazio azione è libero
		
		
		
		for(ActionConditionAffecter a : this.conditionAffecters){
			if( !a.check() ){
				return false;
			}
		}
		
		return true;

	}
	
	public Market getMarket() {
		return market;
	}

}
