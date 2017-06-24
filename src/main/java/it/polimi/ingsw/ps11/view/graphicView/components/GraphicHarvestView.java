package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.HarvestView;

public class GraphicHarvestView extends HarvestView {
	
	protected GraphicPaintedPanel harvestPanel = new GraphicPaintedPanel();
	protected GraphicActionSpace singleActionSpace = new GraphicActionSpace("Harvest single"),
			  					 multipleActionSpace = new GraphicActionSpace("Harvest multiple");
	
	@Override
	public void print() {
		harvestPanel.loadImage("boardImages/Harvest.png");
		
		GridBagLayout gblProduction = new GridBagLayout();
		gblProduction.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblProduction.rowHeights = new int[]{0, 0, 0, 0};
		gblProduction.columnWeights = new double[]{0.048957, 0.08, 0.09, 0.35, 0.290571, Double.MIN_VALUE};
		gblProduction.rowWeights = new double[]{0.222501, 0.432927, 0.344512, Double.MIN_VALUE};
		harvestPanel.setLayout(gblProduction);
		
		GridBagConstraints gbcSingleActionSpace = new GridBagConstraints();
		GridBagConstraints gbcMultipleActionSpace = new GridBagConstraints();
		
		gbcSingleActionSpace.gridx = 1;
		gbcSingleActionSpace.gridy = 1;
		gbcSingleActionSpace.fill = GridBagConstraints.BOTH;
		harvestPanel.add(singleActionSpace, gbcSingleActionSpace);
		
		gbcMultipleActionSpace.gridx = 3;
		gbcMultipleActionSpace.gridy = 1;
		gbcMultipleActionSpace.fill = GridBagConstraints.BOTH;
		harvestPanel.add(multipleActionSpace, gbcMultipleActionSpace);
	}
	
	public JPanel getComponent(){
		return harvestPanel;
	}

}
