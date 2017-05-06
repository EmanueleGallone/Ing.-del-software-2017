package it.polimi.ingsw.zones;

import it.polimi.ingsw.resources.FamilyMember;
import it.polimi.ingsw.resources.Resource;

public class ActionSpace {
	private Resource resource1; //qui probabilmente si userà un array oppure al max un'altra variabile. ci sono spazi azione con più di 2 risorse?

	private FamilyMember slot;
	
	private boolean isOccupied;
	
	private int value; //indico il valore del posto azione.
	
	
	//Mi sa che non viene mai usato, non esistono spazi azione in cui paghi risorse per mettertici
	//Sempre solo il value basta
	public ActionSpace(Resource resource,int value,int positionValue){
		this.resource1 = resource;
		this.resource1.setValue(value);
		this.isOccupied = false;
		this.value = positionValue;
	}
	
	public ActionSpace(int positionValue){ //utilizzato per creare spazi azioni nelle torri. 
		resource1 = new Resource();
		isOccupied = false;
		this.value = positionValue;
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
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	

}
