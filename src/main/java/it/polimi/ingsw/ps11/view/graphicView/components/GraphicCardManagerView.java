package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;

public class GraphicCardManagerView extends CardManagerView implements ItemListener{

	//mostra i deck di ogni giocatore attraverso dei pannelli sovrapposti comandati da una serie di tasti
	
	protected JPanel personalBoard = new JPanel();
	protected JPanel overlayedDecksPanel;
	protected String arrayDeckType[] = { "Territories Cards", "Characters Cards", 
										 "Buildings Cards", "Ventures Cards"};
	protected JToggleButton[] arrayJTButton;
	protected ButtonGroup buttonGroup;

	public GraphicCardManagerView() {
		
		arrayJTButton = new JToggleButton[CARDTYPES];
		buttonGroup = new ButtonGroup();
	}
	
	@Override
	public void print() {
		
		JPanel selectorButtonsPanel = new JPanel();
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblPersonalBoard = new GridBagLayout();											//Layout generale
		gblPersonalBoard.columnWidths = new int[]{0, 0};
		gblPersonalBoard.rowHeights = new int[]{0, 0, 0};
		gblPersonalBoard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblPersonalBoard.rowWeights = new double[]{0.175, 0.825, Double.MIN_VALUE};
		personalBoard.setLayout(gblPersonalBoard);
		
		GridBagLayout gblSelectors = new GridBagLayout();												//Layout dei bottoni
		gblSelectors.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblSelectors.rowHeights = new int[]{0, 0};
		gblSelectors.columnWeights = new double[]{0.02, 0.02, 0.02, 0.02, 0.92, Double.MIN_VALUE};
		gblSelectors.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		selectorButtonsPanel.setLayout(gblSelectors);
		
		overlayedDecksPanel = new JPanel(new CardLayout());												//Pannello dei deck sovrapposti
		
		GridBagConstraints gbcSelectors = new GridBagConstraints();
		GridBagConstraints gbcDecks = new GridBagConstraints();
		
		gbcSelectors.gridy = 0;
		gbcSelectors.fill = GridBagConstraints.BOTH;
		personalBoard.add(selectorButtonsPanel, gbcSelectors);
		
		gbcDecks.gridy = 1;
		gbcDecks.fill = GridBagConstraints.BOTH;
		personalBoard.add(overlayedDecksPanel, gbcDecks);
		
		for(int i = 0; i<CARDTYPES; i++){
			
			JToggleButton selector = new JToggleButton();												//selettore
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.fill = GridBagConstraints.BOTH;
	        selector.addItemListener(this);																//per switchare tra i deck
	        arrayJTButton[i] = selector;
			selectorButtonsPanel.add(selector, gbc);
			buttonGroup.add(selector);																	//un solo selettore attivo alla volta
			
			GraphicPaintedPanel deck = new GraphicPaintedPanel();
			deck.loadImage("boardImages/" + arrayDeckType[i] + ".png");
			overlayedDecksPanel.add(deck, arrayDeckType[i]);
		}
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}
	
    public void itemStateChanged(ItemEvent evt) {														//listener dei selectors, mostra il pannello corrispondente
    																									//al selector
    	CardLayout cl = (CardLayout) overlayedDecksPanel.getLayout();
    	for(int i=0; i<CARDTYPES; i++){
    		if(arrayJTButton[i].isSelected())cl.show(overlayedDecksPanel, arrayDeckType[i]);
    	}
    }

	public JPanel getComponent(){
		return personalBoard;
	}

}
