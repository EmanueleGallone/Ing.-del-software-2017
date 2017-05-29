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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		this.printChild();
	}

}
