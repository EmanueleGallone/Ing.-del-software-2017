package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;
/**
 * <h3> GraphicTowerView</h3>
 * <p> Classe per la visualizzazione della torre contente 4 piani. E' caratterizzato dalla classe della torre e il nome
 * della torre</p>
 * @see GraphicFloorView
 */
public class GraphicTowerView extends TowerView{
	
	protected GraphicPaintedPanel tower = new GraphicPaintedPanel();
	
	public GraphicTowerView(Class<? extends Tower> whichTower, String towerName) {

		super(whichTower,towerName);
		this.towerName = towerName;
		
		tower.loadImage("boardImages/" + towerName + ".png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		ArrayList<GraphicFloorView> graphicFloorViews = new ArrayList<>();

		GridBagLayout gblTower = new GridBagLayout();
		gblTower.columnWidths = new int[]{0, 0};
		gblTower.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gblTower.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblTower.rowWeights = new double[]{ 0.030781 ,0.25, 0.25, 0.25, 0.25, Double.MIN_VALUE};
		tower.setLayout(gblTower);
		
		for(int i = 0; i < TOWERNUMBER; i++){
			
			graphicFloorViews.add(new GraphicFloorView(whichTower, i));
			GridBagConstraints gbcFloor = new GridBagConstraints();
			gbcFloor.gridy = (4-i);
			gbcFloor.fill = GridBagConstraints.BOTH;
			graphicFloorViews.get(i).getComponent().setPreferredSize(new Dimension(10, 10));
			tower.add(graphicFloorViews.get(i).getComponent(), gbcFloor);
			floorViews.add(graphicFloorViews.get(i));		
			}
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
		for(int i = 0; i< TOWERNUMBER; i++){
			floorViews.add(graphicFloorViews.get(0));
		}

	}
	
	public GraphicTowerView(Class<? extends Tower> whichTower) {
		this(whichTower, whichTower.getSimpleName());
	}

	@Override
	public void print(){
		for(int i=0; i<TOWERNUMBER; i++){
		floorViews.get(i).print();
		}
	}

	public JPanel getComponent() {
		return tower;
	}
	
	@Override
	public void attach(EventListener<ViewEventInterface> listener){			//Attach l'eventHandler principale ad ogni piano
		super.attach(listener);
		for(int i = 0; i < TOWERNUMBER; i++){
			floorViews.get(i).attach(listener);
		}
	}

}
