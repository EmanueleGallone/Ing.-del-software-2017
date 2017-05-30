package it.polimi.ingsw.ps11.posTree.components;

import it.polimi.ingsw.ps11.mvc.components.Console;
import it.polimi.ingsw.ps11.posTree.TextualComponent;

public class TowerView extends TextualComponent {

	
	public TowerView() {
		super();
	}
	
	public TowerView(String id) {
		super(id);
	}
	

	@Override
	public void print() {
		/*
		Console console = new Console();
		console.print("["+this.getId()+"]"+"\n");
		
		for(int i = 0; i < 4; i++){
			for(TextualContainer c : getComponents()){
				FloorView floorView = (FloorView)c;
				if(floorView.getWhichFloor() == i)
					floorView.print();
			}
			console.print("");
		}
		*/
	}

	@Override
	public void select() {
		print();
	}

}
