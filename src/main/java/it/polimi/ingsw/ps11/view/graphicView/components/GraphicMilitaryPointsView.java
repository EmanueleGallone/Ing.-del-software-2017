package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

public class GraphicMilitaryPointsView {
	
	protected GraphicPaintedPanel militaryPoints = new GraphicPaintedPanel();

	public void print() {
		militaryPoints.loadImage("boardImages/MilitaryPoints.png");
	}
	
	public JPanel getComponent(){
		return militaryPoints;
	}

}
