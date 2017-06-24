package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.HarvestView;

public class GraphicHarvestView extends HarvestView {

	protected GraphicPaintedPanel harvest = new GraphicPaintedPanel();
	
	@Override
	public void print() {	
		harvest.loadImage("boardImages/Harvest.png");
	}
	
	public JPanel getComponent(){
		return harvest;
	}

}
