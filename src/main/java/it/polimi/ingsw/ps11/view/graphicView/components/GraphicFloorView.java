package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.textualView.components.TextualCardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class GraphicFloorView extends FloorView {
	
	protected JPanel floor = new JPanel();
	
	public GraphicFloorView(int whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new TextualCardView();
	}

	@Override
	public void print() {
	}
}
