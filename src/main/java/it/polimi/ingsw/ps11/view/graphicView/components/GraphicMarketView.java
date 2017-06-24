package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.MarketView;

public class GraphicMarketView extends MarketView{

	protected GraphicPaintedPanel market = new GraphicPaintedPanel();
	
	@Override
	public void print(){
		market.loadImage("boardImages/Market.png");
	}

	public JPanel getComponent() {
		return market;
	}

}
