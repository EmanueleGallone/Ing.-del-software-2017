package it.polimi.ingsw.ps11.mvc.view.textualView.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.components.TowerView;

public class TextualTower extends TowerView {


	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		for(FloorView f : floors){
			f.print();
		}
	}

}
