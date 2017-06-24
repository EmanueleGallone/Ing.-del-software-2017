package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class GraphicFloorView extends FloorView {
	
	protected JPanel floor = new JPanel();
//	protected GraphicPaintedButton card = new GraphicPaintedButton(), 
//								   actionSpace = new GraphicPaintedButton(); 
	
	protected JButton card = new JButton();
	protected GraphicActionSpace actionSpace;
	
	public GraphicFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new GraphicDevelopmentCardView();
		actionSpace = new GraphicActionSpace(whichTower.getSuperclass().getSimpleName() + " " + whichFloor);
	}

	@Override
	public void print() {
		
		floor.setOpaque(false);
		floor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0, 0, 0};
		gblFloor.columnWeights = new double[]{0.6, 0.07, 0.257273, 0.072727, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{0.346939, 0.312925, 0.340136, Double.MIN_VALUE};
		floor.setLayout(gblFloor);
		
		GridBagConstraints gbcCard = new GridBagConstraints();
		GridBagConstraints gbcActionSPace = new GridBagConstraints();
		gbcCard.gridx = 0;
		gbcCard.gridy = 0;
		gbcCard.gridheight = 3;
		gbcCard.insets = new Insets(10, 7, 0, 0);
		//gbcCard.insets = new Insets((int)Math.round(floor.getHeight()*0.5), 0, 0, 0);
		gbcCard.fill = GridBagConstraints.BOTH;
		floor.add(card, gbcCard);
		
		gbcActionSPace.gridx = 2;
		gbcActionSPace.gridy = 1;
		gbcActionSPace.fill = GridBagConstraints.BOTH;
		floor.add(actionSpace, gbcActionSPace);
	}
	
	public JPanel getComponent(){
		return floor;
	}

	@Override
	public void selected() {
		// TODO Auto-generated method stub
		
	}
}
