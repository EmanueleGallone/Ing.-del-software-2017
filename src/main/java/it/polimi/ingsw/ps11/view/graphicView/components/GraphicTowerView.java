package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class GraphicTowerView extends TowerView{

	protected GraphicBackground tower = new GraphicBackground();
	protected String towerName;
	
	public GraphicTowerView(int whichTower, String towerName) {
		super(whichTower,towerName);		
		for(int i = 0; i< TOWERNUMBER; i++){
			floors.add(new GraphicFloorView(whichTower, i));
		}
		this.towerName = towerName;
	}
	
	@Override
	public void print(){
		tower.loadImage("boardImages/" + towerName + ".png");
	}

	public JPanel getComponent() {
		return tower;
	}

}
