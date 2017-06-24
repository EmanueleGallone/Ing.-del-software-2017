package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.components.TextualCardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class GraphicFloorView extends FloorView {
	
	protected JPanel floor = new JPanel();
	
	public GraphicFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new GraphicCardView();
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0};
		gblFloor.columnWeights = new double[]{0.02, 0.02, 0.02, 0.02, 0.92, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		floor.setLayout(gblFloor);
	}

	@Override
	public void print() {
	}
	
	public JPanel getComponent(){
		return floor;
	}

	@Override
	public void selected() {
		// TODO Auto-generated method stub
		
	}
}
