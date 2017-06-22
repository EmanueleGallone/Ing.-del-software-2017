package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

public class GraphicFaithPointsView {
	
	protected GraphicBackground faithPoints = new GraphicBackground();
	
	public void print() {
		faithPoints.loadImage("boardImages/FaithPoints.png");
	}
	
	public JPanel getComponent(){
		return faithPoints;
	}
}
