package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class GraphicTowerView extends TowerView{

	protected GraphicPaintedPanel tower = new GraphicPaintedPanel();
	protected ArrayList<GraphicFloorView> floors = new ArrayList<>();
	
	public GraphicTowerView(int whichTower, String towerName) {
		
		super(whichTower,towerName);		
		for(int i = 0; i< TOWERNUMBER; i++){
			floors.add(new GraphicFloorView(whichTower, i));
		}
		this.towerName = towerName;
		
		GridBagLayout gblTower = new GridBagLayout();
		gblTower.columnWidths = new int[]{0, 0};
		gblTower.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gblTower.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblTower.rowWeights = new double[]{ 0.030781 ,0.25, 0.25, 0.25, 0.25, Double.MIN_VALUE};
		tower.setLayout(gblTower);
	}
	
	@Override
	public void print(){
		tower.loadImage("boardImages/" + towerName + ".png");
		
		for(int i=0; i< TOWERNUMBER; i++){
			GridBagConstraints gbcFloor = new GridBagConstraints();
			gbcFloor.gridy = i+1;
			gbcFloor.fill = GridBagConstraints.BOTH;
			floors.get(i).getComponent().setOpaque(false);
			tower.add(floors.get(i).getComponent(), gbcFloor);
		}
	}

	public JPanel getComponent() {
		return tower;
	}

	@Override
	public void selected() {
		// TODO Auto-generated method stub
		//occhio gab, sto facendo in modo che ogni componente chieda poi cosa fare.
		//per esempio se sei nella selected della torre, qui ti chiedo di scegliere il piano, poi invocherò la selected del Floor e così via..
		//l'idea e' quella, per ora non cambio
		
	}

}
