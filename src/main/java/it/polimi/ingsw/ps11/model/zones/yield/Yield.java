package it.polimi.ingsw.ps11.model.zones.yield;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.FamilyMemberSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
/**
 * <h3> Yield </h3>
 * <p> Classe che raggruppa le zone Raccolta e Produzione del gioco. </p>
 */
public class Yield implements FamilyMemberSpace, Serializable {
	
	private ActionSpace singleActionSpace = new ActionSpace();
	private MultipleActionSpace multipleActionSpace = new MultipleActionSpace();
	private String cardType;
	
	public Yield(Class<? extends DevelopmentCard> cardType) {
		this.cardType = cardType.toString();
	}
	
	public Yield(String cardType) {
		this.cardType = cardType;
	}
	
	public ActionSpace getFreeSpace(){
		if(singleActionSpace.isFree())
			return singleActionSpace;
		return multipleActionSpace.getFreeSpace();
	}
	
	public String getActiveCard(){
		return cardType;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		if(singleActionSpace.isFree())
			return singleActionSpace.placeFamilyMember(familyMember, player);
		else {
			if(player.equals(singleActionSpace.getOwner()) || multipleActionSpace.contains(player))
				return false;
			return multipleActionSpace.placeFamilyMember(familyMember, player);
		}
	}
	
	public ActionSpace getSingleActionSpace() {
		return singleActionSpace;
	}
	public MultipleActionSpace getMultipleActionSpace() {
		return multipleActionSpace;
	}
	
	@Override
	public Yield clone(){
		//NB: i singleActionSpace e i Multiple non sono mai null; inutile un controllo
		Yield clone = new Yield(this.cardType);
	
		clone.singleActionSpace = this.singleActionSpace.clone();
		clone.multipleActionSpace = this.multipleActionSpace.clone();
		
		return clone;
	}
}
