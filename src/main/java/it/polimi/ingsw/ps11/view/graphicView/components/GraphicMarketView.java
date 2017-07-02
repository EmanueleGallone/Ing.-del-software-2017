package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.MarketView;
/**
 * <h3> GraphicMarketView</h3>
 * <p> Classe per la visualizzazione della zona mercato. Contiene un arraylist di actionspace, uno per ogni diversa zona
 * del mercato </p>
 * @see MarketView
 * @see GraphicPaintedButton
 */
public class GraphicMarketView extends MarketView{
	
	//Zona mercato, ha un action space singolo per ogni zona intriore del mercato e un pannello che mostra i turni

	protected GraphicPaintedPanel marketPanel = new GraphicPaintedPanel();
	private ArrayList<GraphicPaintedButton> marketSpaces = new ArrayList<>();


	public GraphicMarketView() {

		marketPanel.loadImage("boardImages/Market.png");

		for(int i = 0; i < market.getPlayerNumber(); i++){
			GraphicPaintedButton actionSpace = new GraphicPaintedButton("Market space number " + i);
			actionSpace.addActionListener(new MarketSelectedListner(i));
			actionSpace.setContentAreaFilled(false);
			marketSpaces.add(actionSpace);
		}	
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		GridBagLayout gblMarket = new GridBagLayout();
		gblMarket.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblMarket.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblMarket.columnWeights = new double[]{0.18, 0.172626, 0.073743, 0.172626, 0.059777, 0.172626, 0.007821,0.172626, 0.034078,Double.MIN_VALUE};
		gblMarket.rowWeights = new double[]{0.27447, 0.122099, 0.160444 ,0.122099, 0.039354, 0.282543, Double.MIN_VALUE};
		marketPanel.setLayout(gblMarket);
		
		GridBagConstraints gbcGoldMarket = new GridBagConstraints();
		GridBagConstraints gbcServantMarket = new GridBagConstraints();
		GridBagConstraints gbcMixed1Market = new GridBagConstraints();
		GridBagConstraints gbcMixed2Market = new GridBagConstraints();
		
		gbcGoldMarket.gridx = 1;
		gbcGoldMarket.gridy = 1;
		gbcGoldMarket.gridheight = 2;
		gbcGoldMarket.fill = GridBagConstraints.BOTH;
		marketPanel.add(marketSpaces.get(0), gbcGoldMarket);
		
		gbcServantMarket.gridx = 3;
		gbcServantMarket.gridy = 1;
		gbcServantMarket.gridheight = 2;
		gbcServantMarket.fill = GridBagConstraints.BOTH;
		marketPanel.add(marketSpaces.get(1), gbcServantMarket);
		
		gbcMixed1Market.gridx = 5;
		gbcMixed1Market.gridy = 2;
		gbcMixed1Market.gridheight = 2;
		gbcMixed1Market.fill = GridBagConstraints.BOTH;
		marketPanel.add(marketSpaces.get(2), gbcMixed1Market);
		
		gbcMixed2Market.gridx = 7;
		gbcMixed2Market.gridy = 5;
		gbcMixed2Market.fill = GridBagConstraints.BOTH;
		marketPanel.add(marketSpaces.get(3), gbcMixed2Market);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
	@Override
	public void print(){
		for(int i = 0; i < market.getPlayerNumber(); i++){
			if(!(market.getActionSpace(i).getFamilyMember() == null)){
				marketSpaces.get(i).loadImage("playerImages/" + market.getActionSpace(i).getOwner().getColor().toString() + 
					" " + market.getActionSpace(i).getFamilyMember().getClass().getSimpleName() + ".png");
			}
		}
	}

	public JPanel getComponent() {
		return marketPanel;
	}
	
	private class MarketSelectedListner implements ActionListener{		//Se viene selezionatauna zona interiore del mercato invoca l'eveento "zona del mercato selezionata"

		int marketType;
		public MarketSelectedListner(int marketType) {
			this.marketType = marketType;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new MarketSelectedEvent(marketType));
		}
	}
}
