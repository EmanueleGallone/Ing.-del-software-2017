package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualComponent;

public class TowerView extends TextualComponent {

	
	public TowerView() {
		super();
	}
	
	public TowerView(String id) {
		super(id);
	}
	

	@Override
	public void print() {
		Console console = new Console();
		console.print("\n"+"\t   "+this.getId());
		
		for(TextualComponent component : this){
			component.print();
		}
	}

	@Override
	public void select() {
		print();
	}

}
