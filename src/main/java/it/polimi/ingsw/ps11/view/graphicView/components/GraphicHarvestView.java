package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.HarvestView;
/**
 * <h3> GraphicHarvestView</h3>
 * <p> Classe per la visualizzazione della zona Raccolta, presenta due action space distinti secondo le regole entrambi
 * realizzati con GraphicPaintedButton</p>
 * @see HarvestView 
 * @see GraphicPaintedButton
 */
public class GraphicHarvestView extends HarvestView {
		
	private GraphicPaintedPanel harvestPanel = new GraphicPaintedPanel();
	private GraphicPaintedButton singleActionSpace = new GraphicPaintedButton();
	private GraphicMultipleActionSpace multipleActionSpace = new GraphicMultipleActionSpace();
	
	public GraphicHarvestView() {
		
		harvestPanel.loadImage("BoardImages/Harvest.png");

		singleActionSpace.setContentAreaFilled(false);
		
		HarvestSelectedListener listener = new HarvestSelectedListener();
		
		singleActionSpace.addActionListener(listener);
		multipleActionSpace.getButton().addActionListener(listener);
				
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

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
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

		}
	
	@Override
	public void print() {
		
		if(!(harvest.getSingleActionSpace().getFamilyMember() == null)){
			singleActionSpace.loadImage("PlayerImages/" + harvest.getSingleActionSpace().getOwner().getColor().toString() + 
					" " + harvest.getSingleActionSpace().getFamilyMember().getId() + ".png");
			singleActionSpace.setEnabled(false);
		}
		else {
			singleActionSpace.loadImage("PlayerImages/BLANK.png");
			singleActionSpace.setEnabled(true);
		}
		multipleActionSpace.print(harvest.getMultipleActionSpace().getAllSpace());
		harvestPanel.repaint();
	}
	
	public JPanel getComponent(){
		return harvestPanel;
	}
	
	private class HarvestSelectedListener implements ActionListener{		//Se il single action space viene selezionato invoca l'evento "spazio singolo raccolta selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new HarvestSelectedEvent());
		}
	}
	
}
