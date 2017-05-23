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
		resources.put(Wood.class.toString(), new Wood());
		resources.put(Stone.class.toString(), new Stone());
		resources.put(Coin.class.toString(), new Coin());
		resources.put(Servant.class.toString(), new Servant());
		resources.put(MilitaryPoint.class.toString(), new MilitaryPoint());
		resources.put(FaithPoint.class.toString(), new FaithPoint());
		resources.put(VictoryPoint.class.toString(), new VictoryPoint());
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
			if(this.getValueOf(r.getClass()) <  otherResources.getValueOf(r.getClass())){
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
			r.increment(otherResources.getValueOf(r.getClass())) ;
		}
	}
	
	public <T extends Resource> void increment(Class<T> rClass,int value){
		this.getResource(rClass).increment(value);
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
	
	public <T extends Resource> T getResource(Class<T> rClass){
		return (T) resources.get(rClass.toString());
	}
	
	public <T extends Resource> int getValueOf(Class<T> rClass){
		return this.getResource(rClass).getValue();
	}
	public HashMap<String, Resource> getResources() {
		return resources;
	}
	
//End getters
	
// Start setters

	public <T extends Resource> void setResource(T resource){
		this.resources.put(resource.getClass().toString() , resource);
	}
	
	public <T extends Resource> void setValueOf(Class<T> rClass , int value){
		this.getResource(rClass).setValue(value);
	}

//End setters
	
	@Override
	public  String toString() {
		String stringa = "";
		
		for (String r : resources.keySet()){
			stringa = stringa + r + " : " +  resources.get(r).getValue() + " | ";
		}
		return stringa;
	}
	
}
