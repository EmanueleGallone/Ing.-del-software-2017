package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;

public class GraphicCouncilPalaceView extends CouncilPalaceView{
	
	protected GraphicPaintedPanel councilPalace = new GraphicPaintedPanel();
	
	@Override
	public void print(){
		councilPalace.loadImage("boardImages/CouncilPalace.png");
	}

	public JPanel getComponent() {
		return councilPalace;
	}

}
