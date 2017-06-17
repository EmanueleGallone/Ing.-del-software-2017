
package it.polimi.ingsw.ps11.view.textualView.tree;

import it.polimi.ingsw.ps11.model.Node;

public abstract class TextualComponent extends Node<TextualComponent> {
	
	private final static String DEFAULT_ID = "unknown";
	private String id;
	private String type;
	
	
	public TextualComponent() {
		this(DEFAULT_ID);
	}
	
	public TextualComponent(String id) {
		this.id = id;
		this.setData(this);
	}
	
	public TextualComponent(String id,String type) {
		this.id = id;
		this.type = type;
		this.setData(this);
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
		return get( c ->{return c.getId().equals(id);});
	}
	
	
	/***
	 *  Cerca il TextualComponent solo tra i suoi figli (Ricerca superficiale)
	 * @return Ritorna il TextualComponent cercato se presente, altrimenti ritorna null
	 */
	public TextualComponent getById(String id){
		
		for(Node<TextualComponent> component : this.getChildren()){
			if (component.getData().getId().equals(id)){
				return component.getData();
			}
		}
		return null;
	}

// Setters

	public void setId(String id) {
		this.id = id;
	}
	public void setClass(String type) {
		this.type = type;
	}

// Getters
	
	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	
}