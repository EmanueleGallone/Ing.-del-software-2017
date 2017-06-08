package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.TextualConsole;
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
		TextualConsole console = new TextualConsole();
		console.println("\n"+"\t   "+this.getId());
		
		for(TextualComponent component : this){
			component.print();
		}
	}

	@Override
	public void select() {
		print();
	}

}
