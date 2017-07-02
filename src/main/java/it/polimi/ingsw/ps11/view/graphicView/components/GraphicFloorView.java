package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
/**
 * <h3> GraphicFloorView</h3>
 * <p> Classe per la visualizzazione dei Floor, sono caratterizzati dalla classe della torre dal piano, e contengono una 
 * DevelopmentCardView per la carta e un PaintedButton per l'actionspace</p>
 * @see FloorView
 * @see GraphicDevelopmentCardView
 * @see GraphicPaintedButton
 */
public class GraphicFloorView extends FloorView{
	
	//Piano della torre, ha la classe della torre e un int per il piano
	
	protected JPanel floorPanel = new JPanel();
	protected GraphicDevelopmentCardView cardView;
	protected GraphicPaintedButton actionSpace;
	private Class<? extends Tower> whichTower;
	private int whichFloor;
	
	public GraphicFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		
		super(whichTower, whichFloor);
		this.whichTower = whichTower;
		this.whichFloor = whichFloor;
		
		cardView = new GraphicDevelopmentCardView(null);
		actionSpace = new GraphicPaintedButton(whichTower.getClass().getSimpleName() + " " + (4-whichFloor));
		actionSpace.setContentAreaFilled(false);
		actionSpace.addActionListener(new FloorSelectedListener());
		cardView.getComponent().setContentAreaFilled(false);
		
		floorPanel.setOpaque(false);
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0, 0, 0};
		gblFloor.columnWeights = new double[]{0.6, 0.07, 0.257273, 0.072727, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{0.346939, 0.312925, 0.340136, Double.MIN_VALUE};
		floorPanel.setLayout(gblFloor);
		
		GridBagConstraints gbcCard = new GridBagConstraints();
		GridBagConstraints gbcActionSPace = new GridBagConstraints();
		
		gbcCard.gridx = 0;
		gbcCard.gridy = 0;
		gbcCard.gridheight = 3;
		gbcCard.insets = new Insets(10, 7, 0, 0);
		gbcCard.fill = GridBagConstraints.BOTH;
		floorPanel.add(cardView.getComponent(), gbcCard);
		
		gbcActionSPace.gridx = 2;
		gbcActionSPace.gridy = 1;
		gbcActionSPace.fill = GridBagConstraints.BOTH;
		floorPanel.add(actionSpace, gbcActionSPace);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}

	@Override
	public void print() {
		
		if(floor == null)
			return;
		if(!(floor.getActionSpace().getFamilyMember() == null)){
			actionSpace.loadImage("playerImages/" + floor.getActionSpace().getOwner().getColor().toString() + 
					" " + floor.getActionSpace().getFamilyMember().getClass().getSimpleName() + ".png");
		}
		
		if(!(floor.getCard() == null)) {
			cardView = new GraphicDevelopmentCardView(floor.getCard().getName());
			cardView.print();
			
			GridBagConstraints gbcCard = new GridBagConstraints();
			gbcCard.gridx = 0;
			gbcCard.gridy = 0;
			gbcCard.gridheight = 3;
			gbcCard.insets = new Insets(10, 7, 0, 0);
			gbcCard.fill = GridBagConstraints.BOTH;
			
			this.floorPanel.add(cardView.getComponent(), gbcCard);
			
			};
			
			this.floorPanel.repaint();
	}
	
	public JPanel getComponent(){
		return floorPanel;
	}
	
	private class FloorSelectedListener implements ActionListener{					//Se un piano viene selezionato invoca l'evento "Piano selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new FloorSelectedEvent(whichTower, whichFloor));			
		}
		
	}

}
