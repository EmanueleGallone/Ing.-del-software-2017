package it.polimi.ingsw.ps11.mvc.components;

public class TowerView extends TextualContainer {

	
	public TowerView() {
		super();
	}
	
	public TowerView(String id) {
		super(id);
	}
	
	@Override
	public void selected() {
		print();
	}

	@Override
	public void print() {
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
	}

}
