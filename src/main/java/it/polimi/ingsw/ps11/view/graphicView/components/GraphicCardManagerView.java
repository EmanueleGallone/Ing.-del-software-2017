package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;
/**
 * <h3> GraphicCardManagerView</h3>
 * <p> Classe per la visualizzazione dei vari deck di un giocatore, ogni deck è realizzato con un JPanel vuoto a cui 
 * vengono aggiunte le carte durante la partita. I deck sono organizzati su CardLayout, sovrapposti con un solo deck
 * mostrato alla volta, selezionabile tramite gli appositi tasti colorati</p>
 * @see CardManagerView
 */
public class GraphicCardManagerView extends CardManagerView implements ItemListener{
	
	protected JPanel personalBoard = new JPanel(),
					 overlayedDecksPanel;
	
	private LinkedHashMap<String, Color> colorMap = new LinkedHashMap<>();
	private ArrayList<GraphicPaintedPanel> allDecks = new ArrayList<>();

	private ArrayList<GraphicDevelopmentCardView> allCards = new ArrayList<>();
	private LinkedHashMap<JToggleButton, LeaderCard> leaderButtonCards;
	private ArrayList<JToggleButton> arrayJTButton;
	private ButtonGroup buttonGroupSelectors, buttonGroupLeaders;

	public GraphicCardManagerView() {
		
		colorMap.put("GreenCard", Color.GREEN); 
		colorMap.put("BlueCard", Color.BLUE); 
		colorMap.put("YellowCard", Color.YELLOW); 
		colorMap.put("PurpleCard", Color.PINK);
		colorMap.put("LeaderCard", Color.BLACK);

		arrayJTButton = new ArrayList<>();
		buttonGroupSelectors = new ButtonGroup();
		
		overlayedDecksPanel = new JPanel(new CardLayout());												//Pannello dei deck sovrapposti
		JPanel selectorButtonsPanel = new JPanel();
		GraphicPaintedPanel tile = new GraphicPaintedPanel();
		//tile.loadImage("playerImages/" + cardManager.getTile() + ".png");
		tile.loadImage("playerImages/Tile 1.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblPersonalBoard = new GridBagLayout();											//Layout generale
		gblPersonalBoard.columnWidths = new int[]{0, 0};
		gblPersonalBoard.rowHeights = new int[]{0, 0, 0};
		gblPersonalBoard.columnWeights = new double[]{0.03, 0.97, Double.MIN_VALUE};
		gblPersonalBoard.rowWeights = new double[]{0.06, 0.94, Double.MIN_VALUE};
		personalBoard.setLayout(gblPersonalBoard);
		
		GridBagLayout gblSelectors = new GridBagLayout();												//Layout dei bottoni
		gblSelectors.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblSelectors.rowHeights = new int[]{0, 0};
		gblSelectors.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.5, Double.MIN_VALUE};
		gblSelectors.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		selectorButtonsPanel.setLayout(gblSelectors);
				
		GridBagConstraints gbcSelectors = new GridBagConstraints();
		GridBagConstraints gbcDecks = new GridBagConstraints();
		GridBagConstraints gbcTile = new GridBagConstraints();
		
		gbcSelectors.gridx = 1;
		gbcSelectors.gridy = 0;
		gbcSelectors.fill = GridBagConstraints.BOTH;
		personalBoard.add(selectorButtonsPanel, gbcSelectors);
		
		gbcDecks.gridx = 1;
		gbcDecks.gridy = 1;
		gbcDecks.fill = GridBagConstraints.BOTH;
		overlayedDecksPanel.setPreferredSize(new Dimension(10, 10));
		personalBoard.add(overlayedDecksPanel, gbcDecks);
		
		gbcTile.gridx = 0;
		gbcTile.gridy = 1;
		gbcTile.fill = GridBagConstraints.BOTH;
		personalBoard.add(tile, gbcTile);
			
		int i = 0;
		for (String cardType : colorMap.keySet()) {
			
			JToggleButton selector = new JToggleButton();												//selettore
			selector.setBackground(colorMap.get(cardType));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.fill = GridBagConstraints.BOTH;
	        selector.addItemListener(this);																//per switchare tra i deck
	        arrayJTButton.add(selector);
			selectorButtonsPanel.add(selector, gbc);
			buttonGroupSelectors.add(selector);																	//un solo selettore attivo alla volta
			
			GraphicPaintedPanel deck = new GraphicPaintedPanel();
			deck.loadImage("boardImages/" + cardType + ".png");
			
			GridBagLayout gblDecks = new GridBagLayout();												//Layout dei bottoni
			gblDecks.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gblDecks.rowHeights = new int[]{0, 0};
			gblDecks.columnWeights = new double[]{0.15, 0.15, 0.15, 0.15, 0.15, 0.15, Double.MIN_VALUE};
			gblDecks.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			deck.setLayout(gblDecks);
			
			if(cardType.equals("LeaderCard")){
				GraphicPaintedButton activate= new GraphicPaintedButton();
				activate.loadImage("playerImages/Activate.png");
//				activate.addActionListener(new LeaderAction());
				GridBagConstraints gbcActivate = new GridBagConstraints();
				gbcActivate.gridx = 5;
				gbcActivate.fill = GridBagConstraints.BOTH;
				deck.add(activate, gbcActivate);
			}
			
			overlayedDecksPanel.add(deck, cardType);
			allDecks.add(deck);
			i++;
		}

//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
	@Override
	public void print() {
		
		allCards = new ArrayList<>();

		ArrayList<String> deckTypesList = new ArrayList<>(this.colorMap.keySet());
		buttonGroupLeaders = new ButtonGroup();
		leaderButtonCards = new LinkedHashMap<>();

		for (String deck : cardManager.getAllCards().keySet()) {
			
			int name = deck.lastIndexOf(".") + 1;
			String deckType = deck.substring(name, deck.length());
	    	int deckPosition = deckTypesList.indexOf(deckType);
			allDecks.get(deckPosition).removeAll();
			
			int cards = 0;
			if(!deckType.equals("LeaderCard")){
			for (DevelopmentCard card : cardManager.getCardList(deck)) {
				
				GraphicDevelopmentCardView cardButton = new GraphicDevelopmentCardView();
				cardButton.update(card);
				cardButton.print();
				
				GridBagConstraints gbcCard = new GridBagConstraints();
				gbcCard.gridx = cards;
				gbcCard.insets = new Insets(20, 0, 20, 5);
				gbcCard.fill = GridBagConstraints.BOTH;

				allCards.add(cardButton);
				allDecks.get(deckPosition).add(cardButton.getComponent(), gbcCard);
				cards++;
			}
		}
//			else{
//				ButtonGroup leaders = new ButtonGroup();
//				for (LeaderCard card : cardManager.getLadersCard()) {
//
//					GraphicLeaderCardView cardButton = new GraphicLeaderCardView();
//					cardButton.loadImage("LeaderCard/" + card.getName() + ".png");
//					leaders.add(cardButton);
//					leaderButtonCards.put(cardButton, card);
//					
//					GridBagConstraints gbcCard = new GridBagConstraints();
//					gbcCard.gridx = cards;
//					gbcCard.insets = new Insets(20, 0, 20, 5);
//					gbcCard.fill = GridBagConstraints.BOTH;
//					
//					allDecks.get(4).add(card, gbcCard);
//					cards++;
//				}
//			}
		}

	}
	
//	public class LeaderAction implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			int i = 0;
//	    	for (JToggleButton toggleButton : leaderButtonCards.keySet()) {
//	    		if(toggleButton.isSelected()){
//	    			eventHandler.invoke(new LeaderCardActivated(leaderButtonCards.get(toggleButton)));
//	    		}
//			}
//		}
//	}
	
    public void itemStateChanged(ItemEvent evt) {														//listener dei selectors, mostra il pannello corrispondente
    																									//al selector
    	CardLayout cl = (CardLayout) overlayedDecksPanel.getLayout();
    	int i = 0;
    	for (String deckName : colorMap.keySet()) {
    		if(arrayJTButton.get(i).isSelected())cl.show(overlayedDecksPanel, deckName);
    		i++;
		}
    }

	public JPanel getComponent(){
		return personalBoard;
	}

	public void attachCardListener(EventListener<Card> zoomCard) {
		for (GraphicDevelopmentCardView graphicDevelopmentCardView : allCards) {
			graphicDevelopmentCardView.attachCardListener(zoomCard);
		}
	}
}
