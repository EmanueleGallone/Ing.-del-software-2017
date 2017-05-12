package gioco.da.console.resources;

import gioco.da.console.Player;
import it.polimi.ingsw.dices.OrangeDice;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(){
		super();
	}
	
	public OrangeFamilyMember(Player player){
		super(player);
	}

	@Override
	public String toString() {
		return "YellowFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}

}
