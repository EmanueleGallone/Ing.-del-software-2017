package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class GraphicFloorView extends FloorView{
	
	//Piano della torre, ha la classe della torre e un int per il piano
	
	protected JPanel floor = new JPanel();
//	protected GraphicPaintedButton card = new GraphicPaintedButton(), 
//								   actionSpace = new GraphicPaintedButton(); 
	
	protected JButton card;
	protected GraphicActionSpace actionSpace;
	private Class<? extends Tower> whichTower;
	private int whichFloor;
	
	public GraphicFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.whichTower = whichTower;
		this.whichFloor = whichFloor;
		this.cardView = new GraphicDevelopmentCardView();
		card = new JButton();
		actionSpace = new GraphicActionSpace(whichTower.getClass().getSimpleName() + " " + (4-whichFloor));
		actionSpace.addActionListener(new FloorSelectedListener());
	}

	@Override
	public void print() {
		
		floor.setOpaque(false);
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
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
		gbcCard.fill = GridBagConstraints.BOTH;
		floor.add(card, gbcCard);
		
		gbcActionSPace.gridx = 2;
		gbcActionSPace.gridy = 1;
		gbcActionSPace.fill = GridBagConstraints.BOTH;
		floor.add(actionSpace, gbcActionSPace);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}
	
	public JPanel getComponent(){
		return floor;
	}
	
	private class FloorSelectedListener implements ActionListener{					//Se un piano viene selezionato invoca l'evento "Piano selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new FloorSelectedEvent(whichTower, whichFloor));			
		}
		
	}
	
	@Override
	public void update(Floor floor) {
		super.update(floor);
		if(!(floor.getActionSpace().getFamilyMember() == null)){
			String owner = floor.getActionSpace().getOwner().getColor().toString(),
			member = floor.getActionSpace().getFamilyMember().getClass().getSimpleName();
			actionSpace.loadImage("playerImages/" + owner + " " + member);
		}
//		if(!(floor.getCard() == null)) this.card.loadImage("" + floor.getCard().getName() + ".png");
		this.floor.repaint();
	}
}
