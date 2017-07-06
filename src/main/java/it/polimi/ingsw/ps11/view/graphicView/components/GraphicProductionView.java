package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ProductionView;
/**
 * <h3> GraphicProductionView</h3>
 * <p> Classe per la visualizzazione della zona Produzione, presenta due action space distinti secondo le regole entrambi
 * realizzati con GraphicPaintedButton</p>
 * @see ProductionView
 * @see GraphicPaintedButton
 */
public class GraphicProductionView extends ProductionView {
	
	protected GraphicPaintedPanel productionPanel = new GraphicPaintedPanel();
	protected GraphicPaintedButton singleActionSpace = new GraphicPaintedButton();
	protected GraphicMultipleActionSpace multipleActionSpace = new GraphicMultipleActionSpace();
	
	public GraphicProductionView() {
		
		productionPanel.loadImage("boardImages/Production.png");
		
		singleActionSpace.setContentAreaFilled(false);
		
		singleActionSpace.addActionListener(new ProductionSelectedListener());
		multipleActionSpace.attachListener(new ProductionSelectedListener());
				
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
	
	@Override
	public void print() {
		if(!(production.getSingleActionSpace().getFamilyMember() == null)){
			System.out.println("pImages/" + production.getSingleActionSpace().getOwner().getColor().toString() + 
					" " + production.getSingleActionSpace().getFamilyMember().getClass().getSimpleName() + ".png");
			singleActionSpace.loadImage("pImages/" + production.getSingleActionSpace().getOwner().getColor().toString() + 
					" " + production.getSingleActionSpace().getFamilyMember().getClass().getSimpleName() + ".png");
		}
		multipleActionSpace.print(production.getMultipleActionSpace().getAllSpace());
		productionPanel.repaint();
	}
	
	public JPanel getComponent(){
		return productionPanel;
	}
	
	private class ProductionSelectedListener implements ActionListener{		//Se un action space viene selezionato invoca l'evento "spazio singolo produzione selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new ProductionSelectedEvent());
		}
	}
}
