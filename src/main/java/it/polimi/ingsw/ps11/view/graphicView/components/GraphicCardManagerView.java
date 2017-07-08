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
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
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
	private LinkedHashMap<JToggleButton, LeaderCard> leaderButtonCards;

	private HashMap<GraphicPaintedPanel, ArrayList<GraphicDevelopmentCardView>> allCards = new HashMap<>();
	private ArrayList<GraphicPaintedPanel> allDecks = new ArrayList<>();
	private HashMap<GraphicPaintedPanel, String> allDecks2 = new HashMap<>();

	public EventListener<Card> zoomCard;
	//private ArrayList<GraphicDevelopmentCardView> allCards = new ArrayList<>();
	private ArrayList<JToggleButton> arrayJTButton;
	private ButtonGroup buttonGroupSelectors, buttonGroupLeaders;

	public GraphicCardManagerView() {
		
		personalBoard.setOpaque(false);
		
		colorMap.put(new GreenCard().getId(), Color.GREEN); 
		colorMap.put(new BlueCard().getId(), Color.BLUE); 
		colorMap.put(new YellowCard().getId(), Color.YELLOW); 
		colorMap.put(new PurpleCard().getId(), Color.PINK);
		colorMap.put(new LeaderCard("").getId(), Color.BLACK);

		arrayJTButton = new ArrayList<>();
		buttonGroupSelectors = new ButtonGroup();
		
		overlayedDecksPanel = new JPanel(new CardLayout());												//Pannello dei deck sovrapposti
		JPanel selectorButtonsPanel = new JPanel();
		selectorButtonsPanel.setOpaque(false);
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
			deck.loadImage("PlayerImages/" + cardType + ".png");
			
			GridBagLayout gblDecks = new GridBagLayout();												//Layout dei bottoni
			gblDecks.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gblDecks.rowHeights = new int[]{0, 0};
			gblDecks.columnWeights = new double[]{0.15, 0.15, 0.15, 0.15, 0.15, 0.15, Double.MIN_VALUE};
			gblDecks.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			deck.setLayout(gblDecks);
			
			if(cardType.equals("LeaderCard")){
				GraphicPaintedButton activate= new GraphicPaintedButton();
				activate.loadImage("PlayerImages/Activate.png");
//				activate.addActionListener(new LeaderAction());
				GridBagConstraints gbcActivate = new GridBagConstraints();
				gbcActivate.gridx = 5;
				gbcActivate.insets = new Insets(20, 0, 20, 5);
				gbcActivate.fill = GridBagConstraints.BOTH;
				deck.add(activate, gbcActivate);
			}
			
			allDecks2.put(deck, cardType); 
			overlayedDecksPanel.add(deck, cardType);
			allDecks.add(deck);
			i++;
		}


//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
	private void setCard(GraphicPaintedPanel deckPanel, ArrayList<DevelopmentCard> cards){
		
		int i = 0;
		for (GraphicDevelopmentCardView developmentCardButton : allCards.get(deckPanel)) {
			if(i<cards.size()){
				developmentCardButton.update(cards.get(i));
			}	
			else 
				developmentCardButton.update(null);
			i++;
			developmentCardButton.print();
		}
	}
	
	private void initializeCardManager(GraphicPaintedPanel deckPanel){
		
		ArrayList<GraphicDevelopmentCardView> deckCards = new ArrayList<>();
		
		for(int j = 0; j < cardManager.getMaxCards(); j++){
			
			GraphicDevelopmentCardView card = new GraphicDevelopmentCardView();
			card.getComponent().setOpaque(false);
			card.getComponent().setContentAreaFilled(false);
			card.getComponent().setEnabled(false);
			card.getComponent().loadImage("PlayerImages/BLANK.png");
			
			GridBagConstraints gbcCard = new GridBagConstraints();
			
			gbcCard.gridx = j;
			gbcCard.gridy = 0;
			gbcCard.fill = GridBagConstraints.BOTH;
			gbcCard.insets = new Insets(20, 0, 20, 5);
			deckCards.add(card);
			deckPanel.add(card.getComponent(), gbcCard);	
		}
		allCards.put(deckPanel, deckCards);
	}
	
	@Override
	public void print() {
		
		for(GraphicPaintedPanel deckPanel : allDecks) {
			if(allCards.get(deckPanel) == null)
				initializeCardManager(deckPanel);
		}
		
		for (GraphicPaintedPanel deckPanel : allDecks) {
			setCard(deckPanel, cardManager.getCardList(allDecks2.get(deckPanel)));
		}
	}
				
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
		this.zoomCard = zoomCard;
		for (GraphicPaintedPanel deckPanel: allCards.keySet()) {
			for(int cards = 0; cards < cardManager.getMaxCards(); cards++){
				allCards.get(deckPanel).get(cards).attachCardListener(zoomCard);
		}
	}
	}
}
