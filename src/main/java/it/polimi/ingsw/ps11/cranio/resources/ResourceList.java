package it.polimi.ingsw.ps11.cranio.resources;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;


public class ResourceList implements Cloneable {
	
	private HashMap<String, Resource> resources = new HashMap<>();
	
// start constructor

	public ResourceList() {
		
		// Andranno caricate da file (?)
		resources.put(Wood.type, new Wood());
		resources.put(Stone.type, new Stone());
		resources.put(Coin.type, new Coin());
		resources.put(Servant.type, new Servant());
		resources.put(MilitaryPoint.type, new MilitaryPoint());
		resources.put(FaithPoint.type, new FaithPoint());
		resources.put(VictoryPoint.type, new VictoryPoint());
	}
	
	public ResourceList(ArrayList<Resource> resources){
		for(Resource resource: resources){
			setResource(resource);
		}
	}

// end constructor
// start logic
	
	/**
	 * Ritorna "False" se almeno un campo di otherList è maggiore di quello della lista su cui viene
	 * chiamata la funzione greater
	 */
	public boolean greater (ResourceList otherResources){
		for(Resource r : resources.values()){
			if(this.getValueOf(r.type) <  otherResources.getValueOf(r.type)){
				return false;
			}
		}
		return true;			
	}
	
	/**
	 * Fa la somma tra questa resource list e la resource list del giocatore che gli viene passata.
	 * Il risultato lo assegna alla resourceList che gli viene passata
	 */
	public void sum(ResourceList otherResources){
		for (Resource r : this.resources.values()){
			r.increment(otherResources.getValueOf(r.type)) ;
		}
	}
	
	public <T extends Resource> void increment(String rType,int value){
		this.getResource(rType).increment(value);
	}
	
	@Override
	public ResourceList clone(){
		try {
			return (ResourceList) super.clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
// end logic
// Start getters
	
	public <T extends Resource> T getResource(String rType){
		return (T) this.resources.get(rType);
	}
	
	public <T extends Resource> int getValueOf(String rType){
		return this.getResource(rType).getValue();
	}
	public HashMap<String, Resource> getResources() {
		return resources;
	}
	
//End getters
	
// Start setters

	public <T extends Resource> void setResource(T resource){
		this.resources.put(resource.type,resource);
	}
	
	public <T extends Resource> void setValueOf(String rType , int value){
		this.getResource(rType).setValue(value);
	}

//End setters
	
	@Override
	public String toString() {
		String stringa = "";
		
		for (String tipo : resources.keySet()){
			stringa = stringa + tipo + " : " + this.getValueOf(tipo) + " | ";
		}
		return stringa;
	}
	
}
