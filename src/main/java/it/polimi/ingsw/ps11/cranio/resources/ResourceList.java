package it.polimi.ingsw.ps11.cranio.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.game.loaders.ResourceLoader;


public class ResourceList implements Iterable<Resource>,Cloneable {
	
	private HashMap<Class<? extends Resource>, Resource> resources = new HashMap<Class<? extends Resource>,Resource>();
	
// start constructor
	
	public ResourceList(){
		/*
		try {
			ResourceLoader resourceLoader = new ResourceLoader();
			ResourceList resourceList = resourceLoader.load();
			this.resources = resourceList.getResources();
			System.out.println("daje");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	
	public ResourceList clone(){
		return (ResourceList)this.clone();
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

	@Override
	public Iterator<Resource> iterator() {
		return  resources.values().iterator();
	}
	
// End iterator
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
	
}
