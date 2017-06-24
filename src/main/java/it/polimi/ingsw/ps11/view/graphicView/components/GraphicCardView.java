package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.CardView;

public class GraphicCardView extends CardView{

	protected GraphicPaintedPanel card = new GraphicPaintedPanel();
	
	@Override
	public void print(){
		card.loadImage("boardImages/Card.png");
	}

	public JPanel getComponent() {
		return card;
	}

}

