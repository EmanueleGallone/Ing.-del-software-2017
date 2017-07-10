package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.ArrayList;
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
/**
 * <h3> GraphicResourceView</h3>
 * <p> Classe per la visualizzazione delle risorse di un singolo giocatore. Contiene monete, legni, pietre, servitori, 
 * punti del tracciato fede, punti militari e punti vittoria</p>
 * @see ResourceView
 */
public class GraphicResourceView extends ResourceView {
		
	private GraphicPaintedPanel resourcesPanel = new GraphicPaintedPanel();
	private HashMap<String, JLabel> resourcesPosition = new HashMap<>();

	public GraphicResourceView() {
		
		resourcesPanel.loadImage("PlayerImages/Resources.png");
		resourcesPanel.setOpaque(false);
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0, 0};
		gblFloor.columnWeights = new double[]{0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{0.15, 0.85, Double.MIN_VALUE};
		resourcesPanel.setLayout(gblFloor);
		
//		for (String resourceName : resourceList.getResources().keySet()) {
//			JLabel resource = new JLabel("<html><font color='black'>" + resourceName + "</font></html>");
//			resource.setFont(new Font("Arial", Font.PLAIN, 80));			
//			resources.put(resourceName, resource);
//			resourcesPanel.add(resource);
//		}
		
		ArrayList<String> rList = new ArrayList<>();
		rList.add(new Coin().getId());
		rList.add(new Wood().getId());
		rList.add(new Stone().getId());
		rList.add(new Servant().getId());
		rList.add(new FaithPoint().getId());
		rList.add(new MilitaryPoint().getId());
		rList.add(new VictoryPoint().getId());
		
		for(String resourceName : rList){
			JLabel resourceLabel = new JLabel("<html><font color='black'>" + 0 + "</font></html>");
			resourceLabel.setFont(new Font("Arial", Font.PLAIN, 50));			
			resourcesPosition.put(resourceName, resourceLabel);
			resourcesPanel.add(resourceLabel);
		}
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
	}
	
	@Override
	public void print(){
		for(Resource resource : this.resourceList){
			JLabel label = resourcesPosition.get(resource.getId());
			label.setText("<html><font color='black'>" + resource.getValue() + "</font></html>");
		}
	}

	public JPanel getComponent() {
		return resourcesPanel;
	}
}