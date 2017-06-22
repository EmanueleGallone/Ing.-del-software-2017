package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;

public class GraphicDiceView extends DiceView {

	protected GraphicBackground dice = new GraphicBackground();
	
	@Override
	public void print() {
		dice.loadImage("boardImages/Dices.png");
	}

	public JPanel getComponent(){
		return dice;
	}

}
