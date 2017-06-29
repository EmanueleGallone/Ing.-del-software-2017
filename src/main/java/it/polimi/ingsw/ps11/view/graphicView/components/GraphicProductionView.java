package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ProductionView;

public class GraphicProductionView extends ProductionView {
	
	//Zona produzione, ha un single ActionSpace e un multiplo ActionSpace

	protected GraphicPaintedPanel productionPanel = new GraphicPaintedPanel();
	protected GraphicActionSpace singleActionSpace,
			  					 multipleActionSpace;
	
	public GraphicProductionView() {
		
		singleActionSpace = new GraphicActionSpace("Production single");
		multipleActionSpace = new GraphicActionSpace("Production multiple");
		
		singleActionSpace.setContentAreaFilled(false);
		multipleActionSpace.setContentAreaFilled(false);
		
		singleActionSpace.addActionListener(new SingleProductionSelectedListener());
		multipleActionSpace.addActionListener(new MultipleProductionSelectedListener());
	}
	
	@Override
	public void print() {
		productionPanel.loadImage("boardImages/Production.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

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
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}
	
	public JPanel getComponent(){
		return productionPanel;
	}
	
	private class SingleProductionSelectedListener implements ActionListener{		//Se il single action space viene selezionato invoca l'evento "spazio singolo produzione selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new ProductionSelectedEvent());
		}
	}
	
	private class MultipleProductionSelectedListener implements ActionListener{		//Se il multiple action space viene selezionato invoca l'evento "spazio multiplo produzione selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new ProductionSelectedEvent());
		}
	}
	
	@Override
	public void update(Yield production) {
		super.update(production);
		if(!(production.getSingleActionSpace().getFamilyMember() == null)){
			singleActionSpace.loadImage("playerImages/" + production.getSingleActionSpace().getOwner().getColor().toString() + 
					" " + production.getSingleActionSpace().getFamilyMember().getClass().getSimpleName() + ".png");
		}
		productionPanel.repaint();
		//DA FARE IL MULTI
	}
}
