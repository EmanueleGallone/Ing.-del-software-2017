package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.events.EventHandler;
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
	
	private  JPanel cardBoardPanel = new JPanel(),
					 overlayedDecksPanel;
	
	private GraphicPaintedPanel leaderDeckPanel;
	private GraphicPaintedPanel tile = new GraphicPaintedPanel();
	private ArrayList<GraphicLeaderCardView> leaderButtonCards = new ArrayList<>();
	
	
	private LinkedHashMap<String, Color> mapStringColor = new LinkedHashMap<>();
	private HashMap<GraphicPaintedPanel, String> mapPanelString = new HashMap<>();
	private HashMap<GraphicPaintedPanel, ArrayList<GraphicDevelopmentCardView>> mapPanelCardsViews = new HashMap<>();
	private ArrayList<GraphicPaintedPanel> arrayAllDecks = new ArrayList<>();

	private EventHandler<LeaderCard> activateLeader = new EventHandler<>();
	private ArrayList<JToggleButton> arrayDeckSelectors;
	private ButtonGroup buttonGroupSelectors;

	public GraphicCardManagerView() {
		
		cardBoardPanel.setOpaque(false);
		
		mapStringColor.put(new GreenCard().getId(), Color.GREEN); 
		mapStringColor.put(new BlueCard().getId(), Color.BLUE); 
		mapStringColor.put(new YellowCard().getId(), Color.YELLOW); 
		mapStringColor.put(new PurpleCard().getId(), Color.PINK);
		mapStringColor.put(new LeaderCard("").getId(), Color.BLACK);

		arrayDeckSelectors = new ArrayList<>();
		buttonGroupSelectors = new ButtonGroup();
		
		overlayedDecksPanel = new JPanel(new CardLayout());												//Pannello dei deck sovrapposti
		JPanel selectorButtonsPanel = new JPanel();
		selectorButtonsPanel.setOpaque(false);
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblPersonalBoard = new GridBagLayout();											//Layout generale
		gblPersonalBoard.columnWidths = new int[]{0, 0};
		gblPersonalBoard.rowHeights = new int[]{0, 0, 0};
		gblPersonalBoard.columnWeights = new double[]{0.03, 0.97, Double.MIN_VALUE};
		gblPersonalBoard.rowWeights = new double[]{0.06, 0.94, Double.MIN_VALUE};
		cardBoardPanel.setLayout(gblPersonalBoard);
		
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
		cardBoardPanel.add(selectorButtonsPanel, gbcSelectors);
		
		gbcDecks.gridx = 1;
		gbcDecks.gridy = 1;
		gbcDecks.fill = GridBagConstraints.BOTH;
		overlayedDecksPanel.setPreferredSize(new Dimension(10, 10));
		cardBoardPanel.add(overlayedDecksPanel, gbcDecks);
		
		gbcTile.gridx = 0;
		gbcTile.gridy = 1;
		gbcTile.fill = GridBagConstraints.BOTH;
		cardBoardPanel.add(tile, gbcTile);
		
		int i = 0;
		for (String cardType : mapStringColor.keySet()) {
			
			JToggleButton selector = new JToggleButton();												//selettore
			selector.setBackground(mapStringColor.get(cardType));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.fill = GridBagConstraints.BOTH;
	        selector.addItemListener(this);																//per switchare tra i deck
	        arrayDeckSelectors.add(selector);
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
				activate.addActionListener(new LeaderAction());
				GridBagConstraints gbcActivate = new GridBagConstraints();
				gbcActivate.gridx = 5;
				gbcActivate.insets = new Insets(20, 0, 20, 0);
				gbcActivate.fill = GridBagConstraints.BOTH;
				deck.add(activate, gbcActivate);	
				leaderDeckPanel = deck;
				
			}
				
			else
			arrayAllDecks.add(deck);
			
			mapPanelString.put(deck, cardType); 
			overlayedDecksPanel.add(deck, cardType);
			i++;
		}


//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
	private void initializeCardManager(GraphicPaintedPanel deckPanel){
		
		ArrayList<GraphicDevelopmentCardView> deckCards = new ArrayList<>();
		
		for(int j = 0; j < cardManager.getMaxCards(); j++){
			
			GraphicDevelopmentCardView card = new GraphicDevelopmentCardView();
			card.getComponent().setOpaque(false);
			card.getComponent().setContentAreaFilled(false);
			//card.getComponent().setEnabled(false);
			card.getComponent().loadImage("PlayerImages/BLANK.png");
			
			GridBagConstraints gbcCard = new GridBagConstraints();
			
			gbcCard.gridx = j;
			gbcCard.gridy = 0;
			gbcCard.fill = GridBagConstraints.BOTH;
			gbcCard.insets = new Insets(20, 0, 20, 0);
			deckCards.add(card);
			deckPanel.add(card.getComponent(), gbcCard);	
		}
		mapPanelCardsViews.put(deckPanel, deckCards);
	}
	
	private void setCard(GraphicPaintedPanel deckPanel, ArrayList<DevelopmentCard> cards){
		//ArrayList<DevelopmentCard> cards = new ArrayList<>();
//		for(int c =0; c<cards2.size(); c++){
//			if(cards.get(c).getName().equals(cardManager.getTiles()))
//				cards.remove(cards.get(c));
//		}
//		for(DevelopmentCard card : cards2){
//			if(!card.getName().equals(cardManager.getTiles()))
//				cards.add(card);
//		}
		
		int i = 0;
		for (GraphicDevelopmentCardView developmentCardButton : mapPanelCardsViews.get(deckPanel)) {
			if(i<cards.size()){
				developmentCardButton.update(cards.get(i));
				developmentCardButton.getComponent().setEnabled(true);
				developmentCardButton.getComponent().setName(cards.get(i).getName());

			}	
			else {
				developmentCardButton.update(null);
				developmentCardButton.getComponent().setEnabled(false);
			}
			i++;
			developmentCardButton.print();
		}
	}
	
	private void initializeLeaderManager(){
		ButtonGroup buttonGroupLeaders = new ButtonGroup();
		int j = leaderButtonCards.size();
		for(; j < cardManager.getLeaderCards().size(); j++){
		
			GraphicLeaderCardView leaderCardView = new GraphicLeaderCardView();
			leaderCardView.setOpaque(false);
			leaderCardView.setContentAreaFilled(false);
			leaderCardView.loadImage("PlayerImages/BLANK.png");
			
			GridBagConstraints gbcCard = new GridBagConstraints();
			
			gbcCard.gridx = j;
			gbcCard.gridy = 0;
			gbcCard.fill = GridBagConstraints.BOTH;
			gbcCard.insets = new Insets(20, 0, 20, 0);
			leaderButtonCards.add(leaderCardView);
			buttonGroupLeaders.add(leaderCardView);
			leaderDeckPanel.add(leaderCardView, gbcCard);
		}
		}
	
	private void setLeaderCard(ArrayList<LeaderCard> deck){
		
		int i = 0;
		for( GraphicLeaderCardView leaderPanel : leaderButtonCards){
			if(i< deck.size()){
				leaderPanel.update(deck.get(i));
				if(deck.get(i).isActivated()){
					leaderPanel.setEnabled(false);
					leaderPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				leaderPanel.setEnabled(true);
				leaderPanel.setBorder(UIManager.getBorder("Button.border"));
			}
			else {
				leaderPanel.clean();
			}
			i++;
			leaderPanel.repaint();
		}
	}
	
	@Override
	public void print() {
		
		for(GraphicPaintedPanel deckPanel : arrayAllDecks) {
			if(mapPanelCardsViews.get(deckPanel) == null)
				initializeCardManager(deckPanel);
		}
		
		if(leaderButtonCards.size() < cardManager.getLeaderCards().size())
			initializeLeaderManager();
		
		for (GraphicPaintedPanel deckPanel : arrayAllDecks) {
			setCard(deckPanel, cardManager.getCardList(mapPanelString.get(deckPanel)));
		}
		
		setLeaderCard(cardManager.getLeaderCards());	
		tile.loadImage("PlayerImages/" + cardManager.getTiles() + ".png");
	}
	
	public class LeaderAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i= 0; i < cardManager.getLeaderCards().size() ; i++){
				if(leaderButtonCards.get(i).isSelected()){
					activateLeader.invoke(cardManager.getLeaderCards().get(i));
				}
			}
		}
	}
	
    public void itemStateChanged(ItemEvent evt) {														//listener dei selectors, mostra il pannello corrispondente
    																									//al selector
    	CardLayout cl = (CardLayout) overlayedDecksPanel.getLayout();
    	int i = 0;
    	for (String deckName : mapStringColor.keySet()) {
    		if(arrayDeckSelectors.get(i).isSelected())cl.show(overlayedDecksPanel, deckName);
    		i++;
		}
    }

	public JPanel getComponent(){
		return cardBoardPanel;
	}

	public void attachLeaderListener(EventListener<LeaderCard> leaderActivateListener) {
		activateLeader.attach(leaderActivateListener);
	}

	public void attachCardListener(EventListener<Card> cardClickListener) {
		for (ArrayList<GraphicDevelopmentCardView> panel : mapPanelCardsViews.values()) {
			for (GraphicDevelopmentCardView card : panel) {
				card.attachCardListener(cardClickListener);
			}
		}
		
	}
}
