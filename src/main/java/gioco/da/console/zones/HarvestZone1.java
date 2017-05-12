package gioco.da.console.zones;

import gioco.da.console.Player;
import gioco.da.console.resources.*;

public class HarvestZone1 extends Zone {
	private boolean isOccupied;
	private Resource resource1;
	private Resource resource2;
	
	public HarvestZone1(){
		isOccupied = false;
		resource1 = new Wood();
		resource2 = new Stone();
		setDefaultProduction();
	}
	
	//set the quantity of resources that by default Production Zone has.
	private void setDefaultProduction(){
		resource1.setValue(1);
		resource2.setValue(2);
	}
	
	public void harvestWithBonuses(){
		//qui vorrei settare i valori di raccolta in base ai bonus delle carte che ho
	}
	
	
	public void active (Player player){
		player.familiarChoice(); //faccio scegliere il familiare da posizionare
		isOccupied = true;
		
		player.changeResourceValue(resource1,resource1.getValue());
		player.changeResourceValue(resource2, resource2.getValue());
	}
	
	public boolean isOccupied(){
		return isOccupied;
	}
	
	public void setIsOccupied(boolean value){
		isOccupied = value;
	}

}
