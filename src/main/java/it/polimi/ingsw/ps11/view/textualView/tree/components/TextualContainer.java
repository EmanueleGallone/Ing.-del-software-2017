package it.polimi.ingsw.ps11.view.textualView.tree.components;

import it.polimi.ingsw.ps11.view.textualView.tree.TextualComponent;

public abstract class TextualContainer extends TextualComponent {

	public TextualContainer() {
		super();
	}
	
	public TextualContainer(String id) {
		super(id);
	}

	@Override
	public void print() {
		for(TextualComponent component : this){
			component.print();
		}
	}

}
