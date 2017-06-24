package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

public class GraphicFaithPointsView {
	
	protected GraphicPaintedPanel faithPoints = new GraphicPaintedPanel();
	
	public void print() {
		faithPoints.loadImage("boardImages/FaithPoints.png");
	}
	
	public JPanel getComponent(){
		return faithPoints;
	}
}
