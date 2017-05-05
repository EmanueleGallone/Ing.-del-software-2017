package pos.players;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ResourceManagerAlternativo {

	private static final int DEFAULT_VALUE = 0;
	
	public enum ResourceList {
		COIN,STONE,WOOD,SERVANT,MILITARY,FAITH,VICTORY
	}

	
	private Map<ResourceList, Integer> resources = new HashMap<>();

//Start Constructors
	
	//Costruttore che inizializza le risorse al valore di default
	public ResourceManagerAlternativo() {
		for(ResourceList type: ResourceList.values()){
			resources.put(type, DEFAULT_VALUE);
		}
	}	
	
	//Costruttore che inizializza ad un valore uguale per tutte le risorse
	public ResourceManagerAlternativo(int value) {
		for(ResourceList type: ResourceList.values()){
			resources.put(type, value);
		}
	}
	
//End Constructors
//Start Logics
	
	public boolean greater(ResourceManagerAlternativo others){
		//Scorre il vottore di risorse e controlla se in resources tutti i campi sono maggiori, 
		//Se ne trova uno minore ritorna falso
		for (Entry<ResourceList, Integer> r : others.getResources().entrySet()) {
		    if (r.getValue()< resources.get(r.getKey())){
		    	return false;
		    }
		}
		return true;
	}
	
//End logics
//Start getters
	public Map<ResourceList, Integer> getResources() {
		return resources;
	}
	
	public int get(ResourceList type){
		//Se la risorsa non esiste va previsto? Secondo me no grazie all'uso dell'enum
		return resources.get(type);
	}
//End getters
}
