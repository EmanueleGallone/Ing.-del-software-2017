package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;

public class GraphicSlideBoardView extends BoardView {

	protected JDialog slideBoard = new JDialog();
	protected JButton slideOutButton;
	protected GraphicProductionView productionView;
	protected GraphicHarvestView harvestView;
	protected GraphicMarketView marketView;
	protected GraphicDiceView diceView;

	public GraphicSlideBoardView() {

		productionView = new GraphicProductionView();
		harvestView = new GraphicHarvestView();
		marketView = new GraphicMarketView();
		diceView = new GraphicDiceView();
		
		GridBagLayout gblSlideBoard = new GridBagLayout();
		gblSlideBoard.columnWidths = new int[]{0, 0, 0};
		gblSlideBoard.rowHeights = new int[]{0, 0, 0, 0};
		gblSlideBoard.columnWeights = new double[]{0.552052, 0.447948, Double.MIN_VALUE};
		gblSlideBoard.rowWeights = new double[]{0.550992, 0.127311, 0.321697, Double.MIN_VALUE};
		slideBoard.getContentPane().setLayout(gblSlideBoard);
			
	}
	
	@Override
	public void print() {	
		
		productionView.print();
		harvestView.print();
		marketView.print();
		diceView.print();
				
		JPanel productionPanel = productionView.getComponent();
		JPanel harvestPanel = harvestView.getComponent();
		JPanel marketPanel = marketView.getComponent();
		JPanel dicePanel = diceView.getComponent();
		
		GridBagConstraints gbcProduction = new GridBagConstraints();
		GridBagConstraints gbcHarvest = new GridBagConstraints();
		GridBagConstraints gbcMarket = new GridBagConstraints();
		GridBagConstraints gbcDice = new GridBagConstraints();
		
		gbcProduction.gridx = 0;
		gbcProduction.gridy = 0;
		gbcProduction.gridheight = 1;
		gbcProduction.fill = GridBagConstraints.BOTH;
		slideBoard.getContentPane().add(productionPanel, gbcProduction);
		
		gbcHarvest.gridx = 0;
		gbcHarvest.gridy = 1;
		gbcHarvest.gridheight = 2;
		gbcHarvest.fill = GridBagConstraints.BOTH;
		slideBoard.getContentPane().add(harvestPanel, gbcHarvest);
		
		gbcMarket.gridx = 1;
		gbcMarket.gridy = 0;
		gbcMarket.gridheight = 2;
		gbcMarket.fill = GridBagConstraints.BOTH;
		marketPanel.setPreferredSize(new Dimension(10, 10));
		slideBoard.getContentPane().add(marketPanel, gbcMarket);
		
		gbcDice.gridx = 1;
		gbcDice.gridy = 2;
		gbcDice.gridheight = 1;
		gbcDice.fill = GridBagConstraints.BOTH;
		slideBoard.getContentPane().add(dicePanel, gbcDice);
		
		GridBagConstraints gbcOutButton = new GridBagConstraints();
		gbcOutButton.anchor = GridBagConstraints.NORTHEAST;
		slideOutButton = new JButton("X");
		slideOutButton.setPreferredSize(new Dimension(75, 75));
		slideOutButton.addActionListener(new CloseThis());
		marketPanel.add(slideOutButton, gbcOutButton);
	}
	
	private class CloseThis implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {
						
			try{
				slideBoard.setVisible(false);
				
			} catch (Exception err){
				System.err.println("Errore nello zoom");
			}
			}
		}
	
	public JDialog getComponent(){
		slideBoard.setUndecorated(true);
		slideBoard.pack();
		return slideBoard;
	}

}
