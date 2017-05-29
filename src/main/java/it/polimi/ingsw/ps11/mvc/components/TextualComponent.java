package it.polimi.ingsw.ps11.mvc.components;

public abstract class TextualComponent{

	public static final String DEFAULT_ID = "";
	protected String id;
	
	public TextualComponent() {
		this.id = DEFAULT_ID;
	}
	
	public TextualComponent(String id) {
	 	this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public abstract void selected();
	public abstract void print();
	
}
