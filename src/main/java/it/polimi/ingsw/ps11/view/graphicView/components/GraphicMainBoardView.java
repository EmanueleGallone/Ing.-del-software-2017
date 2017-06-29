package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ChangePlayer;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ShowPanel;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;

public class GraphicMainBoardView extends BoardView{
	
	//Parte della board sempre visibile, contiene le torri, la chiesa e il palazzo del consiglio
	
	protected JPanel mainBoard = new JPanel();
	protected JButton slideInButton;
	GraphicCouncilPalaceView graphicCouncilPalaceView;
	
	public GraphicMainBoardView() {

		towerViews.add(new GraphicTowerView(GreenTower.class));
		towerViews.add(new GraphicTowerView(BlueTower.class));
		towerViews.add(new GraphicTowerView(YellowTower.class));
		towerViews.add(new GraphicTowerView(PurpleTower.class));
		
		churchView = new GraphicChurchView();
		councilPalaceView = new GraphicCouncilPalaceView();

	}
	
	public GraphicMainBoardView(Board board){
		super(board);	
	}
	
	@Override
	public void print() {
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GraphicTowerView graphicGreenTowerView = new GraphicTowerView(GreenTower.class);
		GraphicTowerView graphicBlueTowerView = new GraphicTowerView(BlueTower.class);
		GraphicTowerView graphicYellowTowerView = new GraphicTowerView(YellowTower.class);
		GraphicTowerView graphicPurpleTowerView = new GraphicTowerView(PurpleTower.class);

		GraphicChurchView graphicChurchView = new GraphicChurchView();
		graphicCouncilPalaceView = new GraphicCouncilPalaceView();
		
		GraphicPaintedPanel paddingSX = new GraphicPaintedPanel();
		GraphicPaintedPanel paddingDX = new GraphicPaintedPanel();
		
		GridBagLayout gblMainBoard = new GridBagLayout();
		gblMainBoard.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblMainBoard.rowHeights = new int[]{0, 0, 0};
		gblMainBoard.columnWeights = new double[]{0.016, 0.236987, 0.193944, 0.043043, 0.236987, 0.236987, 0.027277, Double.MIN_VALUE};
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
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

		this.setTower(0, graphicGreenTowerView);
		this.setTower(1, graphicBlueTowerView);
		this.setTower(2, graphicYellowTowerView);
		this.setTower(3, graphicPurpleTowerView);
		
		this.churchView = graphicChurchView;
		this.councilPalaceView = graphicCouncilPalaceView;
		
	}
	
	@Override
	public void attach(EventListener<ViewEventInterface> listener){			//attach l'eventa handler ad ogni suo componente
		super.attach(listener);
		for(int i = 0; i < towerViews.size(); i++){
			towerViews.get(i).attach(listener);
		}
		councilPalaceView.attach(listener);
	}
	
	
	public JPanel getComponent() {
		return mainBoard;
	}

	public void attachSlideListener(ShowPanel showPanel) {				//Se viene cliccato il pulsante, mostra la parte nascosta della board
		graphicCouncilPalaceView.attachSlideListener(showPanel);
	}

	public void attachChangePlayer(ChangePlayer changePlayer) {
		graphicCouncilPalaceView.attachChangePlayer(changePlayer);
	}

}