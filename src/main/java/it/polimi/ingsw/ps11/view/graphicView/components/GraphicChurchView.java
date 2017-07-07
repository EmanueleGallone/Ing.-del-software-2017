package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;
/**
 * <h3> GraphicChurchView</h3>
 * <p> Classe che mostra la Chiesa e le carte scomunica, i punti del tracciato fede sono stati inseriti nella ResourceList
 * di ogni giocatore</p>
 * @see ChurchView
 */
public class GraphicChurchView extends ChurchView {
	
	protected GraphicPaintedPanel churchPanel = new GraphicPaintedPanel();
	private ArrayList<GraphicPaintedPanel> cards = new ArrayList<>();
	
	public GraphicChurchView() {
		churchPanel.loadImage("boardImages/Church.png");
		
		GraphicPaintedPanel card1 = new GraphicPaintedPanel();
		GraphicPaintedPanel card2 = new GraphicPaintedPanel();
		GraphicPaintedPanel card3 = new GraphicPaintedPanel();
		
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		
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
		card1.setOpaque(false);
		churchPanel.add(card1, gbcCard1);
		
		gbcCard2.gridx = 2;
		gbcCard2.gridy = 2;
		gbcCard2.gridheight = 2;
		gbcCard2.fill = GridBagConstraints.BOTH;
		card2.setOpaque(false);
		churchPanel.add(card2, gbcCard2);
		
		gbcCard3.gridx = 3;
		gbcCard3.gridy = 1;
		gbcCard3.gridheight = 2;
		gbcCard3.fill = GridBagConstraints.BOTH;
		card3.setOpaque(false);
		churchPanel.add(card3, gbcCard3);
	}
	
	@Override
	public void print(){
		
		for(int i = 0; i < church.getMaxExcomunication(); i++){
			Excommunication excommunication = church.getExcomunications(i+1);
			if(excommunication != null)
				cards.get(i).loadImage("exCards/" + excommunication.getId() + ".png");
		}
	}

	public JPanel getComponent() {
		return churchPanel;
	}
}

