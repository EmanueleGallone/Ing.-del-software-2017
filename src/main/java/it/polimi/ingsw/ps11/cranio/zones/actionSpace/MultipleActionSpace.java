package it.polimi.ingsw.ps11.cranio.zones.actionSpace;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class MultipleActionSpace implements FamilyMemberSpace,Iterable<ActionSpace> {

	protected ArrayList<ActionSpace> multipleActionSpace = new ArrayList<>();
	
	public MultipleActionSpace() {
		
	}
	
	private MultipleActionSpace(MultipleActionSpace toCopy) {
		//copy Constructor
		for(ActionSpace a : toCopy.multipleActionSpace)
			this.addActionSpace(a.clone());
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		ActionSpace actionSpace = new ActionSpace(3);
		if(actionSpace.placeFamilyMember(familyMember, player)){
			multipleActionSpace.add(actionSpace);
			return true;
		}
		return false;
	}
	
	public boolean contains(Player player){
		for(ActionSpace a: multipleActionSpace){
			if(a.getOwner().equals(player)){
				return false;
			}
		}
		return true;
	}

	public void addActionSpace(ActionSpace actionSpace){
		multipleActionSpace.add(actionSpace);
	}
	
	public ActionSpace getActionSpace(int index){
		if (index < multipleActionSpace.size()){
			return multipleActionSpace.get(index);
		}
		return null;
	}
	
	@Override
	public Iterator<ActionSpace> iterator() {
		return multipleActionSpace.iterator();
	}
	
	@Override
	public MultipleActionSpace clone(){
		return new MultipleActionSpace(this);
	}

}
