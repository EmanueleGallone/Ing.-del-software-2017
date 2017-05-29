package it.polimi.ingsw.ps11.mvc.components;

import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageTypeSpecifier;

import org.hamcrest.core.IsInstanceOf;

public abstract class TextualContainer extends TextualComponent {

	private HashMap<String, TextualContainer> components = new HashMap<>();
	
	public TextualContainer() {
	
	}
	
	public TextualContainer(String id) {
		super(id);
	}
	
    public void add(TextualContainer component){
    	String newId = null;
    	if (component.getId() == component.DEFAULT_ID){
    		newId = component.getClass().getName();
    		for(int i=0; get(newId) != null; i++ )
        		newId = newId + 1;
    		component.setId(newId);
    	}
		this.components.put(component.getId(), component);
	}
    
    public ArrayList<TextualComponent> getComponents() {
		return new ArrayList<TextualComponent>(components.values()); 
	}
    
    public TextualComponent get(String id){
    	TextualComponent result = components.get(id);
    	if (result != null)
    		return result;
    	
    	for(TextualContainer container : components.values()){
			if ( (container != this) && (result = container.get(id))!= null)
				break;
    	}
    	return result;
    }
    
    public <T extends TextualContainer> ArrayList<TextualContainer> get(Class<T> type){
    	
    	ArrayList<TextualContainer> resut = new ArrayList<>();

    	for(TextualContainer component : components.values()){
    		if (component.getClass() == type){
    			resut.add(component);
    		}
    		if (component != this)
    			resut.addAll(component.get(type));
    	}
    	
    	return resut;
    }
    /*
    public <T extends TextualComponent> ArrayList<TextualComponent> get( Class<T> type){
    	ArrayList<TextualComponent> resut = new ArrayList<>();
    	
    	for(TextualComponent component : components.values()){
    		if (component.getClass() == type)
    			resut.add(component);
    	}
		return resut;   	
    }
    */
    public void remove(String id){
    	components.remove(id);
    }
    
    protected void printChild(){
    	for(TextualComponent c : this.getComponents()){
			c.print();
		}
    }
}
