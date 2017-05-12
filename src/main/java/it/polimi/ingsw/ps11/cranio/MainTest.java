package it.polimi.ingsw.ps11.cranio;


import it.polimi.ingsw.ps11.cranio.familyMember.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.pos.decorator.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.pos.decorator.ActivableSpace;
import it.polimi.ingsw.ps11.cranio.zones.pos.decorator.RewardedActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.pos.decorator.SingleActionSpace;

public class MainTest {
	public static void main(String[] args){
		
		Player player = new Player();
		BlackFamilyMember familyMember = new BlackFamilyMember(player);
		ActivableSpace space = new ActionSpace();
		ActivableSpace singleSpace = new SingleActionSpace(space);
		ResourceList resourceList = new ResourceList();
		resourceList.getCoin().setValue(5);
		ActivableSpace actionSpace = new RewardedActionSpace(singleSpace,resourceList);
		
		System.out.println(actionSpace.placeFamilyMember(familyMember));
		System.out.println("dai");
	}
}
