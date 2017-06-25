package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;

public class GraphicDiceView extends DiceView {

	protected GraphicPaintedPanel dice = new GraphicPaintedPanel();
	protected JPanel blackDice, orangeDice, whiteDice;
	
	public GraphicDiceView() {
		blackDice = new JPanel();
		orangeDice = new JPanel();
		whiteDice = new JPanel();
	}
	
	@Override
	public void print() {
		dice.loadImage("boardImages/Dices.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblDice = new GridBagLayout();
		gblDice.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblDice.rowHeights = new int[]{0, 0, 0 ,0};
		gblDice.columnWeights = new double[]{0.08324, 0.164804, 0.090503, 0.164804, 0.088829,0.164804, 0.243017, Double.MIN_VALUE};
		gblDice.rowWeights = new double[]{0.053191, 0.627659, 0.319149, Double.MIN_VALUE};
		dice.setLayout(gblDice);
		
		GridBagConstraints gbcBlackDice = new GridBagConstraints();
		GridBagConstraints gbcOrangeDice = new GridBagConstraints();
		GridBagConstraints gbcWhite = new GridBagConstraints();
		
		gbcBlackDice.gridx = 1;
		gbcBlackDice.gridy = 1;
		gbcBlackDice.fill = GridBagConstraints.BOTH;
		dice.add(blackDice, gbcBlackDice);
		
		gbcOrangeDice.gridx = 3;
		gbcOrangeDice.gridy = 1;
		gbcOrangeDice.fill = GridBagConstraints.BOTH;
		dice.add(orangeDice, gbcOrangeDice);

		gbcWhite.gridx = 5;
		gbcWhite.gridy = 1;
		gbcWhite.fill = GridBagConstraints.BOTH;
		dice.add(whiteDice, gbcWhite);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}

	public JPanel getComponent(){
		return dice;
	}
	
	
	@Override
	public void update(DiceManager dices) {
		super.update(dices);
		
	}
	

}
