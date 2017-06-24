package it.polimi.ingsw.ps11.model.bonus.ema.actionsEma;

import it.polimi.ingsw.ps11.model.bonus.ema.malus.ActionConditionAffecter;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Market;

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
