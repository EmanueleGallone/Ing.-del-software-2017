package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;

public class GraphicCardManagerView extends CardManagerView implements ItemListener{

	//mostra i deck di ogni giocatore attraverso dei pannelli sovrapposti comandati da una serie di tasti
	
	protected JPanel personalBoard = new JPanel();
	protected JPanel overlayedDecksPanel;
	protected String arrayDeckType[] = { "Territories Cards", "Characters Cards", 
										 "Buildings Cards", "Ventures Cards"};
	protected JToggleButton[] arrayJTButton;
	protected ArrayList<GraphicPaintedPanel> allDecks = new ArrayList<>();
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
			
			GridBagLayout gblDecks = new GridBagLayout();												//Layout dei bottoni
			gblDecks.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gblDecks.rowHeights = new int[]{0, 0};
			gblDecks.columnWeights = new double[]{0.1666, 0.1666, 0.1666, 0.1666, 0.1666, 0.1666, Double.MIN_VALUE};
			gblDecks.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			deck.setLayout(gblDecks);
			
			overlayedDecksPanel.add(deck, arrayDeckType[i]);
			allDecks.add(deck);
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

	@Override
	public void update(CardManager cardManager) {
		super.update(cardManager);
		
    	CardLayout cl = (CardLayout) overlayedDecksPanel.getLayout();
    	int decks = 0;
    	
		for (String deck : cardManager.getAllCards().keySet()) {
			
			int cards = 0;
			
			for (DevelopmentCard card : cardManager.getCardList(deck)) {
				
				GraphicDevelopmentCardView cardButton = new GraphicDevelopmentCardView();
				cardButton.getComponent().loadImage("cards/" + deck + "/" + card.getName());
				GridBagConstraints gbcCard = new GridBagConstraints();
				gbcCard.gridx = cards;
				gbcCard.insets = new Insets(10, 10, 10, 10);
				gbcCard.fill = GridBagConstraints.BOTH;
				allDecks.get(decks).add(cardButton.getComponent(), gbcCard);				
			}
		}
	}
	
}
