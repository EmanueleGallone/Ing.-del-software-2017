package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualComponent;

public class Container extends TextualComponent {

	public Container() {
		super();
	}
	
	public Container(String id) {
		super(id);
	}
	
	
	@Override
	public void select() {
		
	}

	@Override
	public void print() {
		for(TextualComponent component : this){
			component.print();
		}
	}

}
