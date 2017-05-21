package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public class Market {
	
	private ArrayList<ActionSpace> market = new ArrayList<>();
	
	ResourceList coin = new ResourceList();	
	ResourceList servant = new ResourceList();
	
	public Market() {
		coin.setAllToZeroValue();
		servant.setAllToZeroValue();
		coin.setValueOf(Coin.class, 5);
		servant.setValueOf(Servant.class, 5); //per le zone che danno +5 monete e +5 servitori
		
		
		market.add(new ActionSpace(1,coin));
		market.add(new ActionSpace(1,servant));
		market.add(new ActionSpace());// sarebbero gli spazi azione in caso di partita con più di 2 giocatori
		market.add(new ActionSpace());
	}
	
	public Market(ArrayList<ActionSpace> market) {
		this.market = market;
	}
	
	public boolean placeFamilyMember(int index,FamilyMember familyMember){
		return market.get(index).placeFamilyMember(familyMember);
	}
}
