package gioco.da.console.zones;

import gioco.da.console.Player;
import gioco.da.console.resources.*;


// AACHTUNG: classe da rivedere! impostata solo per testing. non è versione finale neanche per testing in realtà.
//la production zone per la Board. ema
public class ProductionZone1 extends Zone {
	private boolean isOccupied;
	private Resource resource1;
	private Resource resource2;

	public ProductionZone1(){
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
	
	 
	/*//(attenzione, AGGIUNGE o RIMUOVE risorse. non è un setter. guarda bene il metodo "changeResource" in PersonalBoard!
	//eventualmente è da implementare l'interfaccia Activable; devo però capire bene la sua logica. ema
	public void activate(PersonalBoard personalBoard){
		personalBoard.changeResource(resource1, resource1.getValue());
		personalBoard.changeResource(resource2, resource2.getValue());

	}*/
	
	public void active(Player player){
		FamilyMember tempFamily = player.familiarChoice();// faccio scegliere il familiare da posizionare
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
