package it.polimi.ingsw.ps11.model.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ResourceList implements Iterable<Resource>, Serializable{
	
	private static final int DEFAULT_VALUE = 0;
	private HashMap<String, Resource> resources = new HashMap<>();
	
// start constructor

	public ResourceList() {

	}
	
	public ResourceList(ArrayList<Resource> resources){
		for(Resource resource: resources){
			setResource(resource);
		}
	}
	
	public ResourceList(Resource resource) {
		this();
		this.setResource(resource);
	}
	

// end constructor
// start logic
	
	/**
	 * Ritorna true se tutti i campi della resourceList chiamante sono maggiori o al limite uguali dei rispettivi campi nell'othoerList.
	 * Nel caso in cui l'otherList non abbia una  risorsa, quest'ultima sarà considerata come fosse al valore di defaul (zero)
	 */
	public boolean greaterEquals(ResourceList otherList){
		
		if (resources.size() == 0)
			return (resources.size() == otherList.getResources().size());
		
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
		for(String key : otherResources.getResources().keySet()){
			if (getResource(key) == null){
				this.resources.put(key, otherResources.getResource(key).clone());
			}
			else {
				this.resources.get(key).increment(otherResources.getValueOf(key));
			}
		}
	}
	
	public void subtract(ResourceList otherResources){
		for(String key : otherResources.getResources().keySet()){
			if (getResource(key) != null){
				this.resources.get(key).increment(-otherResources.getValueOf(key));
			}	
		}
	}
	
	public boolean canSubtract(ResourceList resourceList){
		return this.equals(resourceList) || !resourceList.greaterEquals(this);
	}
	
	@Override
	public ResourceList clone() {
		ResourceList clone = new ResourceList();
		
		for(Resource resource : this.resources.values())
			clone.setResource(resource.clone());
		
		return clone;
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()){
			ResourceList other = (ResourceList) obj;
			if(resources.values().size() == other.getResources().size()){
				for(Resource r : resources.values()){
					Resource r2 = other.getResource(r.getClass());
					if( !(r2 != null && r.equals(r2)))
						return false;
				}
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public Iterator<Resource> iterator() {
		return this.resources.values().iterator();
	}
	
// end logic
// Start getters
	
	public <T extends Resource> T getResource(Class<T> rClass){
		return (T) resources.get(rClass.toString());
	}
	
	public <T extends Resource> T getResource(String rType){
		return (T) resources.get(rType);
	}
	
	public int getValueOf(String rType){
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
