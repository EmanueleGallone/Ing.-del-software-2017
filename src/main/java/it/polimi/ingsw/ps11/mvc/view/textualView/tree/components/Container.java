package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualComponent;

public abstract class Container extends TextualComponent {

	public Container() {
		super();
	}
	
	public Container(String id) {
		super(id);
	}

	@Override
	public void print() {
		for(TextualComponent component : this){
			component.print();
		}
	}

}
