package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ProductionView;

public class GraphicProductionView extends ProductionView {

	protected GraphicPaintedPanel productionPanel = new GraphicPaintedPanel();
	protected GraphicActionSpace singleActionSpace = new GraphicActionSpace("Production single"),
			  					 multipleActionSpace = new GraphicActionSpace("Production multiple");
	
	@Override
	public void print() {
		productionPanel.loadImage("boardImages/Production.png");
		
		GridBagLayout gblProduction = new GridBagLayout();
		gblProduction.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblProduction.rowHeights = new int[]{0, 0, 0, 0};
		gblProduction.columnWeights = new double[]{0.048957, 0.08, 0.09, 0.35, 0.290571, Double.MIN_VALUE};
		gblProduction.rowWeights = new double[]{0.4621119, 0.361491, 0.176398, Double.MIN_VALUE};
		productionPanel.setLayout(gblProduction);
		
		GridBagConstraints gbcSingleActionSpace = new GridBagConstraints();
		GridBagConstraints gbcMultipleActionSpace = new GridBagConstraints();
		
		gbcSingleActionSpace.gridx = 1;
		gbcSingleActionSpace.gridy = 1;
		gbcSingleActionSpace.fill = GridBagConstraints.BOTH;
		productionPanel.add(singleActionSpace, gbcSingleActionSpace);
		
		gbcMultipleActionSpace.gridx = 3;
		gbcMultipleActionSpace.gridy = 1;
		gbcMultipleActionSpace.fill = GridBagConstraints.BOTH;
		productionPanel.add(multipleActionSpace, gbcMultipleActionSpace);
	}
	
	public JPanel getComponent(){
		return productionPanel;
	}

}
