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
		
	protected GraphicPaintedPanel resourcesPanel = new GraphicPaintedPanel();
	protected HashMap<String, JLabel> resourcesPosition = new HashMap<>();

	
	
	
	public GraphicResourceView() {
		resourcesPanel.loadImage("playerImages/Resources.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0, 0};
		gblFloor.columnWeights = new double[]{0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		resourcesPanel.setLayout(gblFloor);
		
//		for (String resourceName : resourceList.getResources().keySet()) {
//			JLabel resource = new JLabel("<html><font color='black'>" + resourceName + "</font></html>");
//			resource.setFont(new Font("Arial", Font.PLAIN, 80));			
//			resources.put(resourceName, resource);
//			resourcesPanel.add(resource);
//		}
		
		ArrayList<String> rList = new ArrayList<>();
		rList.add(Coin.class.toString());
		rList.add(Wood.class.toString());
		rList.add(Stone.class.toString());
		rList.add(Servant.class.toString());
		rList.add(FaithPoint.class.toString());
		rList.add(MilitaryPoint.class.toString());
		rList.add(VictoryPoint.class.toString());
		
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
			JLabel label = resourcesPosition.get(resource.getClass().toString());
			label.setText("<html><font color='black'>" + resource.getValue() + "</font></html>");
		}
	}

	public JPanel getComponent() {
		return resourcesPanel;
	}
}