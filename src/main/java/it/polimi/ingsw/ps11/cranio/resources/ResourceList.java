package it.polimi.ingsw.ps11.cranio.resources;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.game.loaders.ResourceLoader;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;


public class ResourceList implements Cloneable {
	
	
	//private ResourceLoader resourceLoader = new ResourceLoader();
	private HashMap<Class<? extends Resource>, Resource> resources = new HashMap<Class<? extends Resource>,Resource>();
	
	
// start constructor
	
	/*public ResourceList(){
		try {
			ArrayList<Resource> resources = resourceLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}*/
	
	public ResourceList(ArrayList<Resource> resources){
		
		for(Resource resource: resources){
			setResource(resource);
		}
	}
	
	public ResourceList() {
			//COSTRUTTORE TEMPORANEO di default
		setResource(new Stone(2));
		setResource(new Wood(2));
		setResource(new Servant(3));
		setResource(new Coin(5));
		setResource(new VictoryPoint(0));
		setResource(new FaithPoint(0));
		setResource(new MilitaryPoint(0));		
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
// end logic

// Start getters
	
	public <T extends Resource> T getResource(Class<T> rClass){
		return (T) this.resources.get(rClass);
	}
	
	public <T extends Resource> int getValueOf(Class<T> rClass ){
		return this.getResource(rClass).getValue();
	}
	
//End getters
	
// Start setters

	public <T extends Resource> void setResource(T resource){
		this.resources.put(resource.getClass(),resource);
	}
	
	public <T extends Resource> void setValueOf(Class<T> resource,int value){
		this.getResource(resource).setValue(value);
	}
	
	public void setAllToZeroValue(){
		setValueOf(Stone.class, 0);
		setValueOf(Wood.class, 0);
		setValueOf(Coin.class, 0);
		setValueOf(Servant.class, 0);
		setValueOf(MilitaryPoint.class, 0);
		setValueOf(FaithPoint.class, 0);
		setValueOf(VictoryPoint.class, 0);
	}

//End setters
	
	@Override
	public String toString() {
		return "ResourceList [resources=" 
				+ "\nStone= " + resources.get(Stone.class).value
				+ "\nWood= " + resources.get(Wood.class).value
				+ "\nServants= " + resources.get(Servant.class).value
				+ "\nCoin= " + resources.get(Coin.class).value
				+ "\nMilitaryPoints= " + resources.get(MilitaryPoint.class).value
				+ "\nFaithPoints= " + resources.get(FaithPoint.class).value
				+ "\nVictoryPoints= " + resources.get(VictoryPoint.class).value
				+ "]";
	}
	
}
