package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;

public class GraphicDiceView extends DiceView {

	protected GraphicPaintedPanel dice = new GraphicPaintedPanel();
	
	@Override
	public void print() {
		dice.loadImage("boardImages/Dices.png");
	}

	public JPanel getComponent(){
		return dice;
	}
	
	
	@Override
	public void update(DiceManager dices) {
		super.update(dices);
		
	}
	

}
