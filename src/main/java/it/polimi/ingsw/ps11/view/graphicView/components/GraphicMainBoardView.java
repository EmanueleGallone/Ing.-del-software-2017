package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GraphicMainBoardView extends BoardView{
	
	protected JPanel mainBoard = new JPanel();
	protected JButton slideInButton;
	
	public GraphicMainBoardView() {

		towerViews.add(new GraphicTowerView(GreenTower.class));
		towerViews.add(new GraphicTowerView(BlueTower.class));
		towerViews.add(new GraphicTowerView(YellowTower.class));
		towerViews.add(new GraphicTowerView(PurpleTower.class));
		
		churchView = new GraphicChurchView();
		councilPalaceView = new GraphicCouncilPalaceView();
				
		//GraphicDiceView graphicDiceView = new GraphicDiceView();
		//this.diceView = graphicDiceView;
	}
	
	public GraphicMainBoardView(Board board){
		super(board);
	}
	
	@Override
	public void print() {
		
		GraphicTowerView graphicGreenTowerView = new GraphicTowerView(GreenTower.class);
		GraphicTowerView graphicBlueTowerView = new GraphicTowerView(BlueTower.class);
		GraphicTowerView graphicYellowTowerView = new GraphicTowerView(YellowTower.class);
		GraphicTowerView graphicPurpleTowerView = new GraphicTowerView(PurpleTower.class);

		GraphicChurchView graphicChurchView = new GraphicChurchView();
		GraphicCouncilPalaceView graphicCouncilPalaceView = new GraphicCouncilPalaceView();
		
		GraphicPaintedPanel paddingSX = new GraphicPaintedPanel();
		GraphicPaintedPanel paddingDX = new GraphicPaintedPanel();
		
		GridBagLayout gblMainBoard = new GridBagLayout();
		gblMainBoard.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblMainBoard.rowHeights = new int[]{0, 0, 0};
		gblMainBoard.columnWeights = new double[]{0.024774, 0.236987, 0.193944, 0.043043, 0.236987, 0.236987, 0.027277, Double.MIN_VALUE};
		gblMainBoard.rowWeights = new double[]{0.762163, 0.237837, Double.MIN_VALUE};
		mainBoard.setLayout(gblMainBoard);
		
		graphicGreenTowerView.print();
		graphicBlueTowerView.print();
		graphicYellowTowerView.print();
		graphicPurpleTowerView.print();
		graphicChurchView.print();
		graphicCouncilPalaceView.print();
		paddingSX.loadImage("boardImages/Paddingsx.png");
		paddingDX.loadImage("boardImages/Paddingdx.png");
		
		JPanel greenTowerPanel = graphicGreenTowerView.getComponent();
		JPanel blueTowerPanel = graphicBlueTowerView.getComponent();
		JPanel yellowTowerPanel = graphicYellowTowerView.getComponent();
		JPanel purpleTowerPanel = graphicPurpleTowerView.getComponent();
		JPanel churchPanel = graphicChurchView.getComponent();
		JPanel councilPalacePanel = graphicCouncilPalaceView.getComponent();
		slideInButton = new JButton("SlideIn");		
		
		GridBagConstraints gbcGreenTower = new GridBagConstraints();
		GridBagConstraints gbcBlueTower = new GridBagConstraints();
		GridBagConstraints gbcYellowTower = new GridBagConstraints();
		GridBagConstraints gbcPurpleTower = new GridBagConstraints();
		GridBagConstraints gbcChurch = new GridBagConstraints();
		GridBagConstraints gbcCouncilPalace = new GridBagConstraints();
		GridBagConstraints gbcSlideIn = new GridBagConstraints();
		GridBagConstraints gbcPaddingSX = new GridBagConstraints();
		GridBagConstraints gbcPaddingDX = new GridBagConstraints();

		gbcGreenTower.gridx = 1;
		gbcGreenTower.gridy = 0;
		gbcGreenTower.fill = GridBagConstraints.BOTH;
		councilPalacePanel.setPreferredSize(new Dimension(10, 10));
		mainBoard.add(greenTowerPanel, gbcGreenTower);
		
		gbcBlueTower.gridx = 2;
		gbcBlueTower.gridy = 0;
		gbcBlueTower.gridwidth = 2;
		gbcBlueTower.fill = GridBagConstraints.BOTH;
		councilPalacePanel.setPreferredSize(new Dimension(10, 10));
		mainBoard.add(blueTowerPanel, gbcBlueTower);
		
		gbcYellowTower.gridx = 4;
		gbcYellowTower.gridy = 0;
		gbcYellowTower.fill = GridBagConstraints.BOTH;
		councilPalacePanel.setPreferredSize(new Dimension(10, 10));
		mainBoard.add(yellowTowerPanel, gbcYellowTower);
		
		gbcPurpleTower.gridx = 5;
		gbcPurpleTower.gridy = 0;
		gbcPurpleTower.fill = GridBagConstraints.BOTH;
		councilPalacePanel.setPreferredSize(new Dimension(10, 10));
		mainBoard.add(purpleTowerPanel, gbcPurpleTower);
		
		gbcChurch.gridx = 0;
		gbcChurch.gridy = 1;
		gbcChurch.gridwidth = 3;
		gbcChurch.fill = GridBagConstraints.BOTH;
		councilPalacePanel.setPreferredSize(new Dimension(10, 10));
		mainBoard.add(churchPanel, gbcChurch);
		
		gbcCouncilPalace.gridx = 3;
		gbcCouncilPalace.gridy = 1;
		gbcCouncilPalace.gridwidth = 4;
		gbcCouncilPalace.fill = GridBagConstraints.BOTH;
		councilPalacePanel.setPreferredSize(new Dimension(10, 10));
		mainBoard.add(councilPalacePanel, gbcCouncilPalace);
		
		gbcPaddingSX.gridx = 0;
		gbcPaddingSX.gridy = 0;
		gbcPaddingSX.fill = GridBagConstraints.BOTH;
		mainBoard.add(paddingSX, gbcPaddingSX);
		
		gbcPaddingDX.gridx = 6;
		gbcPaddingDX.gridy = 0;
		gbcPaddingDX.fill = GridBagConstraints.BOTH;
		mainBoard.add(paddingDX, gbcPaddingDX);
		
		gbcSlideIn.gridx = 4 ;
		gbcSlideIn.gridy = 3 ;
		gbcSlideIn.fill = GridBagConstraints.BOTH;
		gbcSlideIn.anchor = GridBagConstraints.SOUTHEAST;
		slideInButton.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(slideInButton, gbcSlideIn);
		
		
		this.setTower(0, graphicGreenTowerView);
		this.setTower(1, graphicBlueTowerView);
		this.setTower(2, graphicYellowTowerView);
		this.setTower(3, graphicPurpleTowerView);
		
		this.churchView = graphicChurchView;
		this.councilPalaceView = graphicCouncilPalaceView;
		
	}

	public void attachListener(GraphicView graphicView) {
		slideInButton.addActionListener(graphicView);
	}

	public JPanel getComponent() {
		mainBoard.setBorder(BorderFactory.createLineBorder(Color.RED));
		return mainBoard;
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
