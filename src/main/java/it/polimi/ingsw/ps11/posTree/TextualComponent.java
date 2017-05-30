
package it.polimi.ingsw.ps11.posTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class TextualComponent implements Iterable<TextualComponent> {
	
	private final static String DEFAULT_ID = "unknown";
	private String id;
	private String type;
	
	private ArrayList<TextualComponent> children = new ArrayList<>();
	private TextualComponent parent;

	
	public TextualComponent() {
		this.id = DEFAULT_ID;
	}
	
	public TextualComponent(String id) {
		this.id = id;
	}
	
	public TextualComponent(String id,String type) {
		this.id = id;
		this.type = type;
	}
	
	
// Logics
	
	public abstract void select();
	public abstract void print();

	
// Searching method
	
	/***
	 * 
	 * Cerca il TextualComponent in tutto l'albero sottostante (Ricerca in profondita')
	 * @return Ritorna il TextualComponent cercato se presente, altrimenti ritorna null
	 */
	public TextualComponent searchById(String id){
		
		ArrayList<TextualComponent> result = searchAll((c)->{return c.getId() == id;},true);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}
	
	/***
	 * 
	 * Ritorna l'insieme degli elementi che soddisfano il predicato (Ricerca in profondita' nell'albero)
	 */
	public ArrayList<TextualComponent> searchAll(Predicate<TextualComponent> predicate){
		return searchAll(predicate,false);
	}
	
	/***
	 * 
	 * Ritorna l'insieme degli elementi che soddisfano il predicato
	 * Se unique e' true se trova un elemento che soddisfa il predicato allora si ferma e non cerca oltre, altrimenti
	 * cerca in profondita' nell'albero
	 */
	public ArrayList<TextualComponent> searchAll(Predicate<TextualComponent> predicate, boolean unique){
		return searchAll(predicate,new ArrayList<>(),unique);
	}
	
	private ArrayList<TextualComponent> searchAll(Predicate<TextualComponent> predicate, ArrayList<TextualComponent> alreadyChecked,boolean unique){
		ArrayList<TextualComponent> metch = new ArrayList<>();
		if (!alreadyChecked.contains(this)){
			alreadyChecked.add(this);
			for(TextualComponent component : this){
				if (predicate.test(component)){
					metch.add(component);
					if (unique)
						return metch;
				}
				metch.addAll(component.searchAll(predicate,alreadyChecked,unique));
			 }
		 }
		return metch;
	}
	
	
	/***
	 * 
	 * Scorre tutti gli elementi dell'albero sottostante e applica l'operazione passatagli
	 */
	public void forEach(Consumer<? super TextualComponent> action){
		forEach(action,new ArrayList<>());
	}
	
	private void forEach(Consumer<? super TextualComponent> action, ArrayList<TextualComponent> alreadyChecked) {
		
		if (!alreadyChecked.contains(this)){
			alreadyChecked.add(this);
			for(TextualComponent component : this){
				action.accept(component);
				component.forEach(action,alreadyChecked);
			 }
		 }
	}
	
	
	/***
	 *  Cerca il TextualComponent solo tra i suoi figli (Ricerca superficiale)
	 * @return Ritorna il TextualComponent cercato se presente, altrimenti ritorna null
	 */
	public TextualComponent getById(String id){
		
		for(TextualComponent component : this){
			if (component.getId().equals(id)){
				return component;
			}
		}
		return null;
	}
	
	
	
	
// Iterator

	@Override
	public Iterator<TextualComponent> iterator() {
		return children.iterator();
	}
	

// Setters
	
	public void add(TextualComponent child){
		child.setParent(this);
		this.children.add(child);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setClass(String type) {
		this.type = type;
	}

	public void setParent(TextualComponent parent) {
		this.parent = parent;
	}
	public void setChildren(ArrayList<TextualComponent> children) {
		this.children = children;
	}
	
// Getters
	
	
	public TextualComponent getParent() {
		return parent;
	}
	public ArrayList<TextualComponent> getChildren() {
		return children;
	}
	
	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	
}
