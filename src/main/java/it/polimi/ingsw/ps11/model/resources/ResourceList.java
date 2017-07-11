package it.polimi.ingsw.ps11.model.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

/**
 * <h3>ResourceList</h3>
 * <p> Classe container per tutti i tipi di <code>Resource</code> utilizzabile in qualsiasi parte del gioco. Fornisce metodi
 * per sommare due resourceList e verificare se due resourceList possono essere sottratte.
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
			Resource toAdd = this.resources.get(resource.getId());
			if(toAdd!= null){
				toAdd.increment(resource.getValue());
				this.setResource(toAdd);
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
	
	
	/**
	 * 
	 * @param resourceList Insieme di risorse che si vuole sottrarre alla resourceList su cui viene chiamato questo metodo
	 * @return <b>true</b> se la resourceList passata come parametro ha tuttii campi minori o uguali dei rispettivi campi
	 * nella resourceList corrente. Ritorna <b>false</b> altrimenti
	 */
	public boolean canSubtract(ResourceList resourceList){
		for(Resource resource : resourceList){
			Resource playerResource = this.get(resource.getId());
			if(playerResource == null || playerResource.getValue() < resource.getValue()){
				return false;
			}
		}
		return  true;
	}
	

	/**
	 * Due resourceList sono uguali se in entrambe sono presenti le stesse risorse e se quest'ultime sono equals tra di loro
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()){
			ResourceList other = (ResourceList) obj;
			if(resources.values().size() == other.getResources().size()){
				for(Resource r : resources.values()){
					Resource r2 = other.get(r.getId());
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
	 * Questo metodo non ritorna mai null bensi ritorna un Optional che puo' contenere o meno la risorsa cercata.
	 * @param rClass classe del tipo di risorsa che si vuole ottenere, deve estendere Resource
	 * @return Optional<T extends Resource>
	 */
	@SuppressWarnings("unused")
	private <T extends Resource> Optional<T> getResource(String rClass){
		return Optional.ofNullable(get(rClass));
	}
	
	/**
	 * Metodo che preleva la Resource associata ad una certa stringa. In caso la risorsa sia presente ritorna
	 * una sua copia altrimenti ritorna null;
	 */
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
	
	public void setResource(Resource resource){
		this.resources.put(resource.getId() , resource.clone());
	}
	
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
