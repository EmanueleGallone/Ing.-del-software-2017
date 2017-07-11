package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;
/**
 * <h3> GraphicChurchView</h3>
 * <p> Classe che mostra la Chiesa e le carte scomunica, i punti del tracciato fede sono stati inseriti nella ResourceList
 * di ogni giocatore</p>
 * @see ChurchView
 */
public class GraphicChurchView extends ChurchView {
	
	private GraphicPaintedPanel churchPanel = new GraphicPaintedPanel();
	private ArrayList<GraphicPaintedPanel> excommunicationCards = new ArrayList<>();
	
	public GraphicChurchView() {
		churchPanel.loadImage("BoardImages/Church.png");
		
		GraphicPaintedPanel excommunicationCard1 = new GraphicPaintedPanel();
		GraphicPaintedPanel excommunicationCard2 = new GraphicPaintedPanel();
		GraphicPaintedPanel excommunicationCard3 = new GraphicPaintedPanel();
		
		excommunicationCards.add(excommunicationCard1);
		excommunicationCards.add(excommunicationCard2);
		excommunicationCards.add(excommunicationCard3);
		
		GridBagLayout gblChurch = new GridBagLayout();
		gblChurch.columnWidths = new int[]{0, 0, 0, 0, 0};
		gblChurch.rowHeights = new int[]{0, 0, 0, 0, 0, 0};	
		gblChurch.columnWeights = new double[]{0.43, 0.205382, 0.19989, 0.2048433, Double.MIN_VALUE};
		gblChurch.rowWeights = new double[]{0.2605, 0.060005, 0.42, 0.0208955, 0.006146, Double.MIN_VALUE};
		churchPanel.setLayout(gblChurch);
		
		GridBagConstraints gbcCard1 = new GridBagConstraints();
		GridBagConstraints gbcCard2 = new GridBagConstraints();
		GridBagConstraints gbcCard3 = new GridBagConstraints();
		
		gbcCard1.gridx = 1;
		gbcCard1.gridy = 1;
		gbcCard1.gridheight = 2;
		gbcCard1.fill = GridBagConstraints.BOTH;
		excommunicationCard1.setOpaque(false);
		churchPanel.add(excommunicationCard1, gbcCard1);
		
		gbcCard2.gridx = 2;
		gbcCard2.gridy = 2;
		gbcCard2.gridheight = 2;
		gbcCard2.fill = GridBagConstraints.BOTH;
		excommunicationCard2.setOpaque(false);
		churchPanel.add(excommunicationCard2, gbcCard2);
		
		gbcCard3.gridx = 3;
		gbcCard3.gridy = 1;
		gbcCard3.gridheight = 2;
		gbcCard3.fill = GridBagConstraints.BOTH;
		excommunicationCard3.setOpaque(false);
		churchPanel.add(excommunicationCard3, gbcCard3);
	}
	
	@Override
	public void print(){
		
		for(int i = 0; i < church.getMaxExcomunication(); i++){
			Excommunication excommunication = church.getExcomunications(i+1);
			if(excommunication != null)
				excommunicationCards.get(i).loadImage("ExcomunicationCard/" + excommunication.getId() + ".png");
		}
	}

	public JPanel getComponent() {
		return churchPanel;
	}
}

