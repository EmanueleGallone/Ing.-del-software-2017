package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ProductionView;

public class GraphicProductionView extends ProductionView {

	protected GraphicPaintedPanel production = new GraphicPaintedPanel();
	
	@Override
	public void print() {
		production.loadImage("boardImages/Production.png");
	}
	
	public JPanel getComponent(){
		return production;
	}

}
