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


public class ResourceList {
	
	private static final int DEFAULT_VALUE = 0;
	private HashMap<String, Resource> resources = new HashMap<>();
	
// start constructor

	public ResourceList() {
	/*
		// Andranno caricate da file (?)
		resources.put(Wood.class.toString(), new Wood());
		resources.put(Stone.class.toString(), new Stone());
		resources.put(Coin.class.toString(), new Coin());
		resources.put(Servant.class.toString(), new Servant());
		resources.put(MilitaryPoint.class.toString(), new MilitaryPoint());
		resources.put(FaithPoint.class.toString(), new FaithPoint());
		resources.put(VictoryPoint.class.toString(), new VictoryPoint());
	*/
	}
	
	public ResourceList(ArrayList<Resource> resources){
		for(Resource resource: resources){
			setResource(resource);
		}
	}

// end constructor
// start logic
	
	/**
	 * Ritorna true se tutti i campi della resourceList chiamante sono maggiori o al limite uguali dei rispettivi campi nell'othoerList.
	 * Nel caso in cui l'otherList non abbia una  risorsa, quest'ultima sarà considerata come fosse al valore di defaul (zero)
	 */
	public boolean greaterEquals (ResourceList otherList){
		
		if (resources.size() == 0)
			return false;
		
		for(Resource r : this.resources.values()){
			if( r.getValue() <  otherList.getValueOf(r.getClass())){
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
		Resource temp;
		for(String key : otherResources.getResources().keySet()){
			temp = getResource(key);
			if (temp == null){
				this.resources.put(key, otherResources.getResource(key).clone());
			}
			else {
				this.resources.get(key).increment(otherResources.getValueOf(key));
			}
		}
	}
	
	@Override
	public ResourceList clone() {
		ResourceList newList = new ResourceList();
		newList.setResources((HashMap<String, Resource>)resources.clone());
		return newList;
	}
	
	
	
// end logic
// Start getters
	
	public <T extends Resource> T getResource(Class<T> rClass){
		return (T) getResource(rClass.toString());
	}
	
	public <T extends Resource> T getResource(String rType){
		return (T) resources.get(rType);
	}
	
	public <T extends Resource> int getValueOf(String rType){
		Resource r = this.getResource(rType);
		if (r == null)
			return DEFAULT_VALUE; //Da decidere
		return r.getValue();
	}
	
	public <T extends Resource> int getValueOf(Class<T> rClass){
		return getValueOf(rClass.toString());
	}
	
	public HashMap<String, Resource> getResources() {
		return resources;
	}
	
//End getters
	
// Start setters

	public <T extends Resource> void setResource(T resource){
		this.resources.put(resource.getClass().toString() , resource.clone());
	}

	protected void setResources(HashMap<String, Resource> resources) {
		this.resources = resources;
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
