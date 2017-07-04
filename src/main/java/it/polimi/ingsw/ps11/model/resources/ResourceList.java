package it.polimi.ingsw.ps11.model.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

/**
 * <h3>ResourceList</h3>
 * <p> Classe container per tutti i tipi di <code>Resource</code> utilizzabile in qualsiasi parte del gioco.
 * </p>
 * @see Resource
 */
public class ResourceList implements Iterable<Resource>, Serializable{
	
	private static final int DEFAULT_VALUE = 0;
	private HashMap<String, Resource> resources = new HashMap<>();
	
// start constructor

	
	/**
	 * Crea una ResourceList vuota
	 */
	public ResourceList() {

	}
	/**
	 * <h3><code>public ResourceList(ArrayList<Resource> resources)</code></h3>
	 * <p> Costruttore che accetta un ArrayList di risorse. ogni risorsa all'interno dell'Arraylist verra' aggiunta alla resourceList creata.
	 * </p>
	 * @param resources
	 */
	public ResourceList(ArrayList<Resource> resources){
		for(Resource resource: resources){
			setResource(resource);
		}
	}
	
	/**<h3>public ResourceList(Resource resource)</h3>
	 * <p>
	 * Costruttore che accetta come parametro una singola Resource. Nel caso si volessero aggiungere altre risorse, si utilizza il setResource().
	 * </p>
	 * @param resource risorsa singola da aggiungere nella ResourceList
	 */
	public ResourceList(Resource ... resources) {
		this();
		this.setResource(resources);
	}
	

// end constructor
// start logic
	
//	/**<h3>greaterEquals(ResourceList otherList)</h3>
//	 * <p>
//	 * Metodo che ritorna <code>true</code> se tutti i campi della ResourceList chiamante sono maggiori o al limite uguali dei rispettivi campi nell'otherList.
//	 * Nel caso in cui l'otherList non abbia una  risorsa, quest'ultima sarà considerata come fosse al valore di default (zero).
//	 * </p>
//	 * @param otherList ResourceList da comparare
//	 */
//	public boolean greaterEquals(ResourceList otherList){
//		if(otherList == null)
//			return true;
//		
//		if (resources.size() == 0)
//			return (resources.size() == otherList.getResources().size());
//		
//		for(Resource r : this.resources.values()){
//			if( r.getValue() < otherList.getValueOf(r.getClass())){
//				return false;
//			}
//		}
//		return true;			
//	}
	
	/**<h3>public void sum(ResourceList otherResources)</h3>
	 * <p>
	 * Metodo che somma alla ResourceList chiamante la ResourceList passata come parametro.
	 * se <code>otherResources</code> contiene risorse che il chiamante non ha, viene creato il nuovo oggetto
	 * che ha come valore quello della risorsa specifica all'interno di <code>otherResources</code> 
	 * </p>
	 * @param otherResources è la resourceList da sommare al chiamante della sum
	 */
	public void sum(ResourceList otherResources){
		
		for(Resource resource : otherResources){
			Resource toAdd = this.resources.get(resource.getClass());
			if(toAdd!= null){
				toAdd.increment(resource.getValue());
			}
			else {
				this.setResource(resource);
			}
		}
	}
	
	/**<h3>public void subtract(ResourceList otherResources)</h3>
	 * <p>
	 * Metodo che sottrae alla ResourceList chiamante la ResourceList passata come parametro.
	 * se <code>otherResources</code> contiene risorse che il chiamante non ha, semplicemente non si effettua alcuna sottrazione.
	 * Se vengono sottratte risorse in quantità maggiore di quelle in possesso della ResourceList chiamante, semplicemente si setta il valore a 0.
	 * </p>
	 * @see Increment
	 * @param otherResources è la resourceList da sommare al chiamante della sum
	 */
	public void subtract(ResourceList otherResources){
		for(String key : otherResources.getResources().keySet()){
			if (get(key) != null){
				this.resources.get(key).increment(-otherResources.getValueOf(key));
			}
		}
	}
	
	public boolean canSubtract(ResourceList resourceList){
		for(Resource resource : resourceList){
			if(!(this.get(resource.getClass()).getValue() >= resource.getValue())){
				return false;
			}
		}
		return  true;
		//return this.equals(resourceList) || !resourceList.greaterEquals(this);
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()){
			ResourceList other = (ResourceList) obj;
			if(resources.values().size() == other.getResources().size()){
				for(Resource r : resources.values()){
					Resource r2 = other.get(r.getClass());
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
	/**
	 * Metodo che permette di ottenere della resourceList una risorsa passando il tipo di quest'ultima come parametro. 
	 * Se la risorsa e' presenta nella resourceList allora verra' restituita una sua copia altrimenti verra' restituito il valore null
	 * @param rClass classe del tipo di risorsa che si vuole ottenere, deve estendere Resource
	 * @return <T extends Resource>
	 */
	public <T extends Resource> T get(Class<T> rClass){
		return get(rClass.toString());
	}
	
	
	
	/**
	 * Metodo che permette di ottenere della resourceList una risorsa passando il tipo di quest'ultima come parametro. 
	 * Questo metodo non ritorna mai null bensi ritorna un Optional che puo' contenere o meno la risorsa cercata.
	 * @param rClass classe del tipo di risorsa che si vuole ottenere, deve estendere Resource
	 * @return Optional<T extends Resource>
	 */
	public <T extends Resource> Optional<T> getResource(Class<T> rClass){
		return Optional.ofNullable(get(rClass));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Resource> T get(String rType){
		Resource resource = resources.get(rType);
		if(resource != null)
			return (T) resource.clone();
		return null;
	}
	
	private int getValueOf(String rType){
		Resource r = this.get(rType);
		if (r == null)
			return DEFAULT_VALUE;
		return r.getValue();
	}
	
	
	public HashMap<String, Resource> getResources() {
		return resources;
	}
	
//End getters
	
// Start setters
	
	public void setResource(Resource...resources){
		for(Resource r : resources){
			this.setResource(r);
		}
	}
	
	
	/**
	 * 
	 * @param resource
	 */
	public void setResource(Resource resource){
		this.resources.put(resource.getClass().toString() , resource.clone());
	}
	
//	protected void setResources(HashMap<String, Resource> resources) {
//		this.resources = resources;
//	}
//End setters
	
	@Override
	public  String toString() {
		String stringa = "";
		
		for (String r : resources.keySet()){
			stringa = stringa + r + " : " +  resources.get(r).getValue() + " | ";
		}
		return stringa;
	}
	
	@Override
	public ResourceList clone() {
		ResourceList clone = new ResourceList();
		
		for(Resource resource : this.resources.values())
			clone.setResource(resource.clone());
		
		return clone;
	}
	
}
