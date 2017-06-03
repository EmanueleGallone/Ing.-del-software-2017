
package it.polimi.ingsw.ps11.mvc.view.textualView.tree;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.Node;

public abstract class TextualComponentGenerico<T> extends Node<TextualComponentGenerico<T>> {
	
	private final static String DEFAULT_ID = "unknown";
	private String id;
	private String type;
	
	private T source;
	
	public TextualComponentGenerico() {
		this(DEFAULT_ID);
	}
	
	public TextualComponentGenerico(String id) {
		this.id = id;
		this.setData(this);
	}
	
	public TextualComponentGenerico(String id,String type) {
		this.id = id;
		this.type = type;
		this.setData(this);
	}
	
	
// Logics
	
	public abstract void select();
	public abstract void print();
	
	public T getSource(){
		return source;
	}
	
	public void update(T source){
		this.source = source;
	}
	
// Searching method
	
	/***
	 * 
	 * Cerca il TextualComponent in tutto l'albero sottostante (Ricerca in profondita')
	 * @return Ritorna il TextualComponent cercato se presente, altrimenti ritorna null
	 */
	public TextualComponentGenerico<T> searchById(String id){
		
		ArrayList<TextualComponentGenerico<T>> result = searchAll((c)->{return c.getId().equals(id);},true);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}
	
	
	/***
	 *  Cerca il TextualComponent solo tra i suoi figli (Ricerca superficiale)
	 * @return Ritorna il TextualComponent cercato se presente, altrimenti ritorna null
	 */
	public TextualComponentGenerico<T> getById(String id){
		
		for(Node<TextualComponentGenerico<T>> component : this.getChildren()){
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
