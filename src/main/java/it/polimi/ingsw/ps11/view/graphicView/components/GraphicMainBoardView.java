package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;

public class GraphicMainBoardView extends BoardView{
	
	protected JPanel mainBoard = new JPanel();
	protected JDialog slideBoard;
	protected JButton slideInButton;
	protected ArrayList<GraphicTowerView> towerViews;
	protected GraphicHarvestView harvestView;
	protected GraphicProductionView productionView;
	protected GraphicDiceView diceView;
	protected GraphicCouncilPalaceView councilPalaceView;
	protected GraphicChurchView churchView;
	protected GraphicMarketView marketView;
	protected GraphicFaithPointsView faithPointsView;
	protected GraphicMilitaryPointsView militaryPointsView;
	
	public GraphicMainBoardView() {
		
		slideInButton = new JButton("SlideIn");
		mainBoard.add(slideInButton);

	}
	
	public JPanel getComponent() {
		mainBoard.setBorder(BorderFactory.createLineBorder(Color.RED));
		return mainBoard;
	}
	
	@Override
	public void print() {
		
	}

	public void attachListener(GraphicView graphicView) {
		slideInButton.addActionListener(graphicView);
	}


}

//CONSTRUCTOR
//GridBagLayout gbl_board = new GridBagLayout();
//gbl_board.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//gbl_board.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
//gbl_board.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
//gbl_board.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
//board.setLayout(gbl_board);
//
//towerViews = new ArrayList<>();
//towerViews.add(new GraphicTowerView(0,"GreenTower"));
//towerViews.add(new GraphicTowerView(1,"BlueTower"));
//towerViews.add(new GraphicTowerView(2,"YellowTower"));
//towerViews.add(new GraphicTowerView(3,"PurpleTower"));
//
//diceView = new GraphicDiceView();
//marketView = new GraphicMarketView();
//harvestView = new GraphicHarvestView();
//productionView = new GraphicProductionView();
//councilPalaceView = new GraphicCouncilPalaceView();
//churchView = new GraphicChurchView();
//faithPointsView = new GraphicFaithPointsView();
//militaryPointsView = new GraphicMilitaryPointsView();

//PRINT

//board.setLayout(new GridBagLayout());
//
//JPanel greenTowerPanel = towerViews.get(0).getComponent();
//JPanel blueTowerPanel = towerViews.get(1).getComponent();
//JPanel yellowTowerPanel = towerViews.get(2).getComponent();
//JPanel purpleTowerPanel = towerViews.get(3).getComponent();
//
//JPanel dicePanel = diceView.getComponent();
//JPanel harvestPanel = harvestView.getComponent();
//JPanel productionPanel = productionView.getComponent();
//JPanel councilPalacePanel = councilPalaceView.getComponent();
//JPanel churchPanel = churchView.getComponent();
//JPanel marketPanel = marketView.getComponent();
//JPanel faithPointsPanel = faithPointsView.getComponent();
//JPanel militaryPointsPanel = militaryPointsView.getComponent();
//JPanel paddingsx = new JPanel();
//JPanel paddingdx = new JPanel();
//
//GridBagConstraints gbcGreenTower = new GridBagConstraints();
//GridBagConstraints gbcBlueTower = new GridBagConstraints();
//GridBagConstraints gbcYellowTower = new GridBagConstraints();
//GridBagConstraints gbcPurpleTower = new GridBagConstraints();
//GridBagConstraints gbcDice = new GridBagConstraints();
//GridBagConstraints gbcHarvest = new GridBagConstraints();
//GridBagConstraints gbcProduction = new GridBagConstraints();
//GridBagConstraints gbcCouncilPalace = new GridBagConstraints();
//GridBagConstraints gbcChurch = new GridBagConstraints();
//GridBagConstraints gbcMarket = new GridBagConstraints();
//GridBagConstraints gbcFaithPoints = new GridBagConstraints();
//GridBagConstraints gbcMilitaryPoints = new GridBagConstraints();
//GridBagConstraints gbcpadSX = new GridBagConstraints();
//GridBagConstraints gbcpadDX = new GridBagConstraints();
//
//gbcGreenTower.gridx = 1;
//gbcGreenTower.gridy = 0;
//gbcGreenTower.gridwidth = 1;
//gbcGreenTower.weightx = 0.209652;
//gbcGreenTower.weighty = 0.552027;
//gbcGreenTower.fill = GridBagConstraints.BOTH;
//board.add(greenTowerPanel, gbcGreenTower);
//
//gbcBlueTower.gridx = 2;
//gbcBlueTower.gridy = 0;
//gbcBlueTower.gridwidth = 2;
//gbcBlueTower.weightx = 0.209652;
//gbcBlueTower.weighty = 0.552027;
//gbcBlueTower.fill = GridBagConstraints.BOTH;
//board.add(blueTowerPanel, gbcBlueTower);
//
//gbcYellowTower.gridx = 4;
//gbcYellowTower.gridy = 0;
//gbcYellowTower.gridwidth = 2;
//gbcYellowTower.weightx = 0.209652;
//gbcYellowTower.weighty = 0.552027;
//gbcYellowTower.fill = GridBagConstraints.BOTH;
//board.add(yellowTowerPanel, gbcYellowTower);
//
//gbcPurpleTower.gridx = 6;
//gbcPurpleTower.gridy = 0;
//gbcPurpleTower.weightx = 0.209652;
//gbcPurpleTower.weighty = 0.552027;
//gbcPurpleTower.fill = GridBagConstraints.BOTH;
//board.add(purpleTowerPanel, gbcPurpleTower);
//
//gbcDice.gridx = 5;
//gbcDice.gridy = 5;
//gbcDice.gridwidth = 3;
//gbcDice.weightx = 0.39628;
//gbcDice.weighty = 0.071082;
//gbcDice.fill = GridBagConstraints.BOTH;
//board.add(dicePanel, gbcDice);
//
//gbcHarvest.gridx = 0;
//gbcHarvest.gridy = 4;
//gbcHarvest.gridheight = 2;
//gbcHarvest.gridwidth = 5;
//gbcHarvest.weightx = 0.488377;
//gbcHarvest.weighty = 0.099214;
//gbcHarvest.fill = GridBagConstraints.BOTH;
//board.add(harvestPanel, gbcHarvest);
//
//gbcProduction.gridx = 0;
//gbcProduction.gridy = 3;
//gbcProduction.gridwidth = 5;
//gbcProduction.weightx = 0.488377;
//gbcProduction.weighty = 0.364914;
//gbcProduction.fill = GridBagConstraints.BOTH;
//board.add(productionPanel, gbcProduction);
//
//gbcCouncilPalace.gridx = 3;
//gbcCouncilPalace.gridy = 1;
//gbcCouncilPalace.gridwidth = 5;
//gbcCouncilPalace.weightx = 0.481514;
//gbcCouncilPalace.weighty = 0.172263;
//gbcCouncilPalace.fill = GridBagConstraints.BOTH;
//board.add(councilPalacePanel, gbcCouncilPalace);
//
//gbcChurch.gridx = 0;
//gbcChurch.gridy = 1;
//gbcChurch.gridwidth = 3;
//gbcChurch.weightx = 0.403143;
//gbcChurch.weighty = 0.172263;
//gbcChurch.fill = GridBagConstraints.BOTH;
//board.add(churchPanel, gbcChurch);
//
//gbcMarket.gridx = 5;
//gbcMarket.gridy = 3;
//gbcMarket.gridheight = 2;
//gbcMarket.gridwidth = 3;
//gbcMarket.weightx = 0.396281;
//gbcMarket.weighty = 0.149879;
//gbcMarket.fill = GridBagConstraints.BOTH;
//board.add(marketPanel, gbcMarket);
//
//gbcFaithPoints.gridx = 0;
//gbcFaithPoints.gridy = 2;
//gbcFaithPoints.gridwidth = 8;
//gbcFaithPoints.weightx = 0.884657;
//gbcFaithPoints.weighty = 0.054749;
//gbcFaithPoints.fill = GridBagConstraints.BOTH;
//board.add(faithPointsPanel, gbcFaithPoints);
//
//gbcMilitaryPoints.gridx = 8;
//gbcMilitaryPoints.gridy = 0;
//gbcMilitaryPoints.gridheight = 6;
//gbcMilitaryPoints.weightx = 0.115342;
//gbcMilitaryPoints.weighty = 1;
//gbcMilitaryPoints.fill = GridBagConstraints.BOTH;
//board.add(militaryPointsPanel, gbcMilitaryPoints);
//
//gbcpadSX.gridx = 0;
//gbcpadSX.gridy = 0;
//gbcpadSX.weightx = 0.021917;
//gbcpadSX.weighty = 0.552027;
//gbcpadSX.fill = GridBagConstraints.BOTH;
//board.add(paddingsx, gbcpadSX);
//
//gbcpadDX.gridx = 7;
//gbcpadDX.gridy = 0;
//gbcpadDX.weightx = 0.024131;
//gbcpadDX.weighty = 0.552027;
//gbcpadDX.fill = GridBagConstraints.BOTH;
//board.add(paddingdx, gbcpadDX);
//
//towerViews.get(0).print();
//towerViews.get(1).print();
//towerViews.get(2).print();
//towerViews.get(3).print();
//
//diceView.print();
//harvestView.print();
//productionView.print();
//councilPalaceView.print();
//churchView.print();
//marketView.print();
