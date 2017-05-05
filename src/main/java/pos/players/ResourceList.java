package pos.players;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ResourceList {

	private static final int DEFAULT_VALUE = 0;
	
	public enum Resource {
		COIN,STONE,WOOD,SERVANT,MILITARY,FAITH,VICTORY
	}

	
	private Map<Resource, Integer> resources = new HashMap<>();

//Start Constructors
	
	//Costruttore che inizializza le risorse al valore di default
	public ResourceList() {
		for(Resource type: Resource.values()){
			resources.put(type, DEFAULT_VALUE);
		}
	}	
	
	//Costruttore che inizializza ad un valore uguale per tutte le risorse
	public ResourceList(int value) {
		for(Resource type: Resource.values()){
			resources.put(type, value);
		}
	}
	
//End Constructors
//Start Logics
	
	public boolean greater(ResourceList others){
		//Scorre il vottore di risorse e controlla se in resources tutti i campi sono maggiori
		for (Entry<Resource, Integer> r : others.getAllResources().entrySet()) {
		    if (r.getValue() > resources.get(r.getKey())){
		    	return false;
		    }
		}
		return true;
	}
	
//End logics
//Start getters
	public Map<Resource, Integer> getAllResources() {
		return resources;
	}
	
	public int getResource(Resource type){
		//Se la risorsa non esiste va previsto? Secondo me no grazie all'uso dell'enum
		return resources.get(type);
	}
//End getters
//Start setters
	public void setResource(Resource type,int value){
		resources.put(type, value);
	}
//End setter
}
