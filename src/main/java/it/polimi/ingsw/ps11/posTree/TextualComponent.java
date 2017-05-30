package it.polimi.ingsw.ps11.posTree;

import java.util.ArrayList;
import java.util.Iterator;
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
		
		Predicate<TextualComponent> predicate = (c) ->{return c.getId().equals(id);};
		return searchById(id, new ArrayList<>(),predicate );
	}
	
	
	private TextualComponent searchById(String id, ArrayList<TextualComponent> alreadyChecked, Predicate<TextualComponent> predicate ){
		
		if (!alreadyChecked.contains(this)){
			alreadyChecked.add(this);
			
			for(TextualComponent component : this){
				if ( predicate.test(component) /*component.getId().equals(id)*/){
					return component;
				}else {
					TextualComponent result = component.searchById(id,alreadyChecked,predicate); //qua
					if (result != null)
						return result;
				}
			 }
		 }
		return null;
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
