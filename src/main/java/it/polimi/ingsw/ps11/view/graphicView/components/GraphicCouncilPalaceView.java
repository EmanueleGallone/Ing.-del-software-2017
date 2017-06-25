package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ShowPanel;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;

public class GraphicCouncilPalaceView extends CouncilPalaceView{
	
	//Palazzo del consiglio, contiene un action space singolo e uno multiplo
	
	protected GraphicPaintedPanel councilPalace = new GraphicPaintedPanel();
	protected GraphicActionSpace multipleActionSpace;
	protected JButton showPanelButton = new JButton("^");
	protected JPanel turns = new JPanel();
	
	public GraphicCouncilPalaceView() {
		multipleActionSpace = new GraphicActionSpace("Council");
		multipleActionSpace.addActionListener(new CouncilPalaceSelectedListener());
		}
	
	@Override
	public void print(){
		councilPalace.loadImage("boardImages/CouncilPalace.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		GridBagLayout gblCouncilPalace = new GridBagLayout();
		gblCouncilPalace.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblCouncilPalace.rowHeights = new int[]{0, 0, 0, 0, 0};
		gblCouncilPalace.columnWeights = new double[]{0.130115, 0.548506, 0.135632, 0.10023, 0.085517, Double.MIN_VALUE};
		gblCouncilPalace.rowWeights = new double[]{0.063213, 0.375768, 0.3125555, 0.248464, Double.MIN_VALUE};
		councilPalace.setLayout(gblCouncilPalace);
		
		GridBagConstraints gbcMultipleActionSpace = new GridBagConstraints();
		GridBagConstraints gbcTurns = new GridBagConstraints();
		GridBagConstraints gbcSlideIn = new GridBagConstraints();
		
		gbcMultipleActionSpace.gridx = 1;
		gbcMultipleActionSpace.gridy = 1;
		gbcMultipleActionSpace.fill = GridBagConstraints.BOTH;
		councilPalace.add(multipleActionSpace, gbcMultipleActionSpace);
		
		gbcTurns.gridx = 3;
		gbcTurns.gridy = 0;
		gbcTurns.gridheight = 3;
		gbcTurns.fill = GridBagConstraints.BOTH;
		councilPalace.add(turns, gbcTurns);
		
		gbcSlideIn.gridx = 4 ;
		gbcSlideIn.gridy = 3 ;
		gbcSlideIn.fill = GridBagConstraints.BOTH;
		gbcSlideIn.anchor = GridBagConstraints.SOUTHEAST;
		showPanelButton.setPreferredSize(new Dimension(10, 10));
		councilPalace.add(showPanelButton, gbcSlideIn);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}
	
	public void attachSlideListener(ShowPanel showPanel){					//Bottone che fa entrare la parte nascosta della board
		showPanelButton.addActionListener(showPanel);
	}

	public JPanel getComponent() {
		return councilPalace;
	}

	private class CouncilPalaceSelectedListener implements ActionListener{	//Se selezionato invoca l'evento "Palazzo del consiglio selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			//eventHandler.invoke(new CouncilSelectedEvent());
		}
	}

}
