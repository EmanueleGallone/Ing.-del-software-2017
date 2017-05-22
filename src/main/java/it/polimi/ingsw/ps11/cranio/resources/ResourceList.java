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
	
	private HashMap<Class<? extends Resource>, Resource> resources = new HashMap<Class<? extends Resource>,Resource>();
	
// start constructor

	public ResourceList() {
		resources.put(Wood.class, new Wood());
		resources.put(Stone.class, new Stone());
		resources.put(Coin.class, new Coin());
		resources.put(Servant.class, new Servant());
		resources.put(MilitaryPoint.class, new MilitaryPoint());
		resources.put(FaithPoint.class, new FaithPoint());
		resources.put(VictoryPoint.class, new VictoryPoint());
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
	
	public <T extends Resource> void increment(Class<T> resource,int value){
		this.getResource(resource).increment(value);
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
	
	public String toJson(){
		Gson gson = new Gson();
		return gson.toJson(resources);
	}
	
	public static ResourceList fromJson(String json){
		Gson gson = new Gson();
		ResourceList resourceList = new ResourceList();
		resourceList.setResources(gson.fromJson(json, HashMap.class));
		return resourceList;
	}

// Start Iterator
// Start getters
	
	public <T extends Resource> T getResource(Class<T> rClass){
		return (T) this.resources.get(rClass);
	}
	
	public <T extends Resource> int getValueOf(Class<T> rClass ){
		return this.getResource(rClass).getValue();
	}
	public HashMap<Class<? extends Resource>, Resource> getResources() {
		return resources;
	}
	
//End getters
	
// Start setters

	public <T extends Resource> void setResource(T resource){
		this.resources.put(resource.getClass(),resource);
	}
	
	public <T extends Resource> void setValueOf(Class<T> resource,int value){
		this.getResource(resource).setValue(value);
	}

	public void setResources(HashMap<Class<? extends Resource>, Resource> resources) {
		this.resources = resources;
	}
//End setters
	
	@Override
	public String toString() {
		String stringa = "";
		
		for (Class<? extends Resource> tipo : resources.keySet()){
			stringa = stringa + tipo + " : " + resources.get(tipo).toString();
		}
		return stringa;
	}
	
}
