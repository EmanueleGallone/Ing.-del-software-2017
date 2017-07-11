package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;
/**
 * <h3> GraphicDiceView</h3>
 * <p> Classe per la visualizzazione dei dadi e dei loro valori, realizzati attraverso pannelli</p>
 * @see DiceView
 */
public class GraphicDiceView extends DiceView {

	private GraphicPaintedPanel dicePanel = new GraphicPaintedPanel();
	private ArrayList<GraphicPaintedPanel> dicePanels = new ArrayList<>();
	private JButton closeButton;
	
	public GraphicDiceView() {
		
		GraphicPaintedPanel blackDice = new GraphicPaintedPanel(),
							orangeDice = new GraphicPaintedPanel(),
							whiteDice = new GraphicPaintedPanel();
		dicePanels.add(blackDice);
		dicePanels.add(orangeDice);
		dicePanels.add(whiteDice);
		
		closeButton = new JButton("X");
		
		dicePanel.loadImage("BoardImages/Dices.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblDice = new GridBagLayout();
		gblDice.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblDice.rowHeights = new int[]{0, 0, 0 ,0};
		gblDice.columnWeights = new double[]{0.08324, 0.164804, 0.090503, 0.164804, 0.09,0.164804, 0.115, 0.115, Double.MIN_VALUE};
		gblDice.rowWeights = new double[]{0.053191, 0.64, 0.30, Double.MIN_VALUE};
		dicePanel.setLayout(gblDice);
		
		GridBagConstraints gbcBlackDice = new GridBagConstraints();
		GridBagConstraints gbcOrangeDice = new GridBagConstraints();
		GridBagConstraints gbcWhite = new GridBagConstraints();
		GridBagConstraints gbcCloseButton = new GridBagConstraints();
		
		gbcBlackDice.gridx = 3;
		gbcBlackDice.gridy = 1;
		gbcBlackDice.fill = GridBagConstraints.BOTH;
		blackDice.setOpaque(false);
		dicePanel.add(blackDice, gbcBlackDice);
		
		gbcOrangeDice.gridx = 1;
		gbcOrangeDice.gridy = 1;
		gbcOrangeDice.fill = GridBagConstraints.BOTH;
		orangeDice.setOpaque(false);
		dicePanel.add(orangeDice, gbcOrangeDice);

		gbcWhite.gridx = 5;
		gbcWhite.gridy = 1;
		gbcWhite.fill = GridBagConstraints.BOTH;
		whiteDice.setOpaque(false);
		dicePanel.add(whiteDice, gbcWhite);
		
		gbcCloseButton.gridx = 7;
		gbcCloseButton.gridy = 2;
		gbcCloseButton.fill = GridBagConstraints.BOTH;
		gbcCloseButton.anchor = GridBagConstraints.SOUTHEAST;
		closeButton.setPreferredSize(new Dimension(5, 5));
		dicePanel.add(closeButton, gbcCloseButton);
		
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}
	//zampiero camilla
	@Override
	public void print() {
		int i = 0;
		for (Dice dice : dices.getDices().values()) {
			dicePanels.get(i).loadImage("BoardImages/" + dice.getName() + " " + dice.getValue() + ".png");
			i++;
		}
	}

	public JPanel getComponent(){
		return dicePanel;
	}
	
	public void attachCloseButton(ActionListener listener){
		closeButton.addActionListener(listener);
	}
}
