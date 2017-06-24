package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;

public class GraphicPersonalBoardView extends CardManagerView implements ItemListener{

	protected JPanel personalBoard = new JPanel();
	protected JPanel overlayedDecksPanel;
	protected String arrayDeckType[] = { "Territories Cards", "Characters Cards", 
										 "Buildings Cards", "Ventures Cards"};
	protected JToggleButton[] arrayJTButton;
	protected ButtonGroup buttonGroup;

	public GraphicPersonalBoardView() {
		
		GridBagLayout gblPersonalBoard = new GridBagLayout();
		gblPersonalBoard.columnWidths = new int[]{0, 0};
		gblPersonalBoard.rowHeights = new int[]{0, 0, 0};
		gblPersonalBoard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblPersonalBoard.rowWeights = new double[]{0.175, 0.825, Double.MIN_VALUE};
		personalBoard.setLayout(gblPersonalBoard);
		
		arrayJTButton = new JToggleButton[arrayDeckType.length];
		buttonGroup = new ButtonGroup();
	}
	
	@Override
	public void print() {
		
		JPanel selectorButtonsPanel = new JPanel();
		
		GridBagLayout gblFamilyMembers = new GridBagLayout();
		gblFamilyMembers.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblFamilyMembers.rowHeights = new int[]{0, 0};
		gblFamilyMembers.columnWeights = new double[]{0.02, 0.02, 0.02, 0.02, 0.92, Double.MIN_VALUE};
		gblFamilyMembers.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		selectorButtonsPanel.setLayout(gblFamilyMembers);
		
		overlayedDecksPanel = new JPanel(new CardLayout());
		
		GridBagConstraints gbcSelectors = new GridBagConstraints();
		GridBagConstraints gbcDecks = new GridBagConstraints();
		
		gbcSelectors.gridy = 0;
		gbcSelectors.fill = GridBagConstraints.BOTH;
		personalBoard.add(selectorButtonsPanel, gbcSelectors);
		
		gbcDecks.gridy = 1;
		gbcDecks.fill = GridBagConstraints.BOTH;
		personalBoard.add(overlayedDecksPanel, gbcDecks);
		
		for(int i = 0; i<arrayDeckType.length; i++){
			
			JToggleButton selector = new JToggleButton();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.fill = GridBagConstraints.BOTH;
	        selector.addItemListener(this);	
	        arrayJTButton[i] = selector;
			selectorButtonsPanel.add(selector, gbc);
			buttonGroup.add(selector);
			
			GraphicPaintedPanel deck = new GraphicPaintedPanel();
			deck.loadImage("boardImages/" + arrayDeckType[i] + ".png");
			overlayedDecksPanel.add(deck, arrayDeckType[i]);
		}

	}
	
    public void itemStateChanged(ItemEvent evt) {
    	
    	CardLayout cl = (CardLayout) overlayedDecksPanel.getLayout();
    	for(int i=0; i<arrayDeckType.length; i++){
    		if(arrayJTButton[i].isSelected())cl.show(overlayedDecksPanel, arrayDeckType[i]);
    	}
    }

	public JPanel getComponent(){
		return personalBoard;
	}

}
