package pos.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceList {
	
	private Map<Resources, Resource> resources = new HashMap<>();

//Start Constructors
	
	//Costruttore che inizializza le risorse al valore di default
	public ResourceList() {
		for(Resources type: Resources.values()){
			resources.put(type, new Resource(type));
		}
	}	
	
	//Costruttore che inizializza ad un valore uguale per tutte le risorse
	public ResourceList(int value) {
		for(Resources type: Resources.values()){
			resources.put(type, new Resource(type,value));
		}
	}
	
//End Constructors
//Start Logics
	
	public boolean greaterThen(ResourceList otherResourceList){
		//Controlla se questa ResourceList ha almeno un campo minore dell' othersResourceList, in quel caso ritorna false
		
		Map<Resources, Resource> otherResource = otherResourceList.getAllResources();
		for(Resource resource : otherResource.values()){
			if( this.getValueOf(resource.getType()) < resource.getValue()){
				return false;
			}
		}
		return true;
	}
	
//End logics
//Start getters
	public Map<Resources, Resource> getAllResources() {
		return resources;
	}
	
	public Resource getResource(Resources whichResource){
		//Se la risorsa non esiste va previsto? Secondo me no grazie all'uso dell'enum
		return resources.get(whichResource);
	}
	
	public int getValueOf(Resources whichResource){
		return resources.get(whichResource).getValue();
	}
//End getters
//Start setters
	public void setResource(Resource resource){
		resources.put(resource.getType(), resource);
	}
	public void setValueOf(Resources type,int value){
		this.getResource(type).setValue(value);
	}
//End setter
}
