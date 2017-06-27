package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class GraphicResourceView extends ResourceView {
	
	//Mostra le risorse di ogni giocatore
	
	protected GraphicPaintedPanel resourcesPanel = new GraphicPaintedPanel();
	protected HashMap<String, JLabel> resources;

	@Override
	public void print(){
		
		resourcesPanel.loadImage("playerImages/Resources.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0, 0};
		gblFloor.columnWeights = new double[]{0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		resourcesPanel.setLayout(gblFloor);
		
		for (String resourceName : resourceList.getResources().keySet()) {
			System.out.println("prova");
			JLabel resource = new JLabel("<html><font color='black'>" + resourceList.getValueOf(resourceName) + "</font></html>");
			resource.setFont(new Font("Arial", Font.PLAIN, 80));			
			resources.put(resourceName, resource);
			resourcesPanel.add(resource);
		}
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}

	public JPanel getComponent() {
		return resourcesPanel;
	}
	
	@Override
	public void update(ResourceList resourceList) {
		super.update(resourceList);
		
		for (String resource : resources.keySet()) {
			resources.get(resource).setText("<html><font color='black'>" + resourceList.getValueOf(resource) + "</font></html>");
		}		
	}

}