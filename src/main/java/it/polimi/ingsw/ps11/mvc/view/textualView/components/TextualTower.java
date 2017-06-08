package it.polimi.ingsw.ps11.mvc.view.textualView.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.components.TowerView;

public class TextualTower extends TowerView {

	public TextualTower(String id) {
		super(id);
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		int i = 1;
		for(FloorView f : tower){
			console.print(i + " ");
			f.print();
			i++;
		}
	}

}
