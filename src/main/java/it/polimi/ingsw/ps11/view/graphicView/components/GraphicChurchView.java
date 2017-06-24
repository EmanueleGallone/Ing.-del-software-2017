package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;

public class GraphicChurchView extends ChurchView {
	
	protected GraphicPaintedPanel church = new GraphicPaintedPanel();
	
	@Override
	public void print(){
		church.loadImage("boardImages/Church.png"); //     ./../../../../settings/
	}

	public JPanel getComponent() {
		return church;
	}

}

