package it.polimi.ingsw.zones;

import it.polimi.ingsw.resources.FamilyMember;
import it.polimi.ingsw.resources.Resource;

public class ActionSpace {
	private Resource resource1; //qui probabilmente si userà un array oppure al max un'altra variabile. ci sono spazi azione con più di 2 risorse?

	private FamilyMember slot;
	
	private boolean isOccupied;
	
	public ActionSpace(Resource resource,int value){
		this.resource1 = resource;
		this.resource1.setValue(value);
		this.isOccupied = false;
	}
	
	public ActionSpace(){ //utilizzato per creare spazi azioni nelle torri. 
		resource1 = new Resource();
		isOccupied = false;
	}
	
	
	
	
	//getters and setters
	public Resource getResource1() {
		return resource1;
	}

	public FamilyMember getSlot() {
		return slot;
	}

	public void setResource1(Resource resource1) {
		this.resource1 = resource1;
	}

	public void setSlot(FamilyMember familyMember) {
		this.slot = familyMember.clone();
	}
	
	public FamilyMember getSlotFamilyMember(){
		return this.slot;
	}
	
	public void setOccupied(boolean value){
		this.isOccupied = value;
	}
	
	public boolean isOccupied(){
		return this.isOccupied;
	}
	

}
