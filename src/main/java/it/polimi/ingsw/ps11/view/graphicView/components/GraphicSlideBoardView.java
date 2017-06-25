package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;

public class GraphicSlideBoardView extends BoardView {
	
	//Parte della board nascosta, contiene le zone produzione e raccolta, il mercato e i dadi

	protected JDialog slideBoard = new JDialog();
	protected JButton slideOutButton;

	public GraphicSlideBoardView() {

		productionView = new GraphicProductionView();
		harvestView = new GraphicHarvestView();
		marketView = new GraphicMarketView();
		diceView = new GraphicDiceView();
					
	}
	
	@Override
	public void print() {	
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		GraphicProductionView graphicProductionView = new GraphicProductionView();
		GraphicHarvestView graphicHarvestView = new GraphicHarvestView();
		GraphicMarketView graphicMarketView = new GraphicMarketView();
		GraphicDiceView graphicDiceView = new GraphicDiceView();
		
		GridBagLayout gblSlideBoard = new GridBagLayout();
		gblSlideBoard.columnWidths = new int[]{0, 0, 0};
		gblSlideBoard.rowHeights = new int[]{0, 0, 0, 0};
		gblSlideBoard.columnWeights = new double[]{0.552052, 0.447948, Double.MIN_VALUE};
		gblSlideBoard.rowWeights = new double[]{0.550992, 0.127311, 0.321697, Double.MIN_VALUE};
		slideBoard.getContentPane().setLayout(gblSlideBoard);
		
		graphicProductionView.print();
		graphicHarvestView.print();
		graphicMarketView.print();
		graphicDiceView.print();
				
		JPanel productionPanel = graphicProductionView.getComponent();
		JPanel harvestPanel = graphicHarvestView.getComponent();
		JPanel marketPanel = graphicMarketView.getComponent();
		JPanel dicePanel = graphicDiceView.getComponent();
		
		GridBagConstraints gbcProduction = new GridBagConstraints();
		GridBagConstraints gbcHarvest = new GridBagConstraints();
		GridBagConstraints gbcMarket = new GridBagConstraints();
		GridBagConstraints gbcDice = new GridBagConstraints();
		
		gbcProduction.gridx = 0;
		gbcProduction.gridy = 0;
		gbcProduction.gridheight = 1;
		gbcProduction.fill = GridBagConstraints.BOTH;
		productionPanel.setPreferredSize(new Dimension(10, 10));
		slideBoard.getContentPane().add(productionPanel, gbcProduction);
		
		gbcHarvest.gridx = 0;
		gbcHarvest.gridy = 1;
		gbcHarvest.gridheight = 2;
		gbcHarvest.fill = GridBagConstraints.BOTH;
		harvestPanel.setPreferredSize(new Dimension(10, 10));
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
		dicePanel.setPreferredSize(new Dimension(10, 10));
		slideBoard.getContentPane().add(dicePanel, gbcDice);
		
		GridBagConstraints gbcOutButton = new GridBagConstraints();
		gbcOutButton.gridx = 6;
		gbcOutButton.gridy = 2;
		gbcOutButton.fill = GridBagConstraints.BOTH;
		gbcOutButton.anchor = GridBagConstraints.SOUTHEAST;
		slideOutButton = new JButton("X");
		slideOutButton.setPreferredSize(new Dimension(10, 10));
		slideOutButton.addActionListener(new CloseThis());
		dicePanel.add(slideOutButton, gbcOutButton);
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		this.productionView = graphicProductionView;
		this.harvestView = graphicHarvestView;
		this.marketView = graphicMarketView;
		this.diceView = graphicDiceView;
	}
	
	@Override
	public void attach(EventListener<ViewEventInterface> listener) {
		super.attach(listener);
		productionView.attach(listener);
		harvestView.attach(listener);
		marketView.attach(listener);
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
