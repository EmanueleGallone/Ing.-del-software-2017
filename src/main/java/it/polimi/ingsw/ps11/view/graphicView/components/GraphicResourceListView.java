package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> GraphicResourceListView</h3>
 * <p> Classe per la visualizzazione di una ResourceList. contiene fino a sette segmenti, ognuno composto da un'immagine
 * della risorsa e il suo valore</p>
 * @see ResourceList
 */
public class GraphicResourceListView extends JPanel{
	
	public GraphicResourceListView(ResourceList resourceList) {
		
		this.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		
		GridBagLayout gblResourceList = new GridBagLayout();
		gblResourceList.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblResourceList.rowHeights = new int[]{0, 0};
		gblResourceList.columnWeights = new double[]{0.071429, 0.071429, 0.071429, 0.071429, 0.071429, 0.071429, 0.071429,
				0.071429, 0.071429, 0.071429, 0.071429, 0.071429, 0.071429, 0.071429, Double.MIN_VALUE};
		gblResourceList.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gblResourceList);
		
		int i = 0;
		for (Resource resource : resourceList) {
			
			GraphicPaintedPanel img = new GraphicPaintedPanel();
			JLabel value = new JLabel("" + resource.getValue());
			img.loadImage("BoardImages/" + resource.getId() + ".png");
			
			gbc.gridx = i;
			gbc.gridy = 0;
			gbc.fill = GridBagConstraints.BOTH;
			add(img, gbc);
			i++;
			
			gbc.gridx = i;
			gbc.gridy = 0;
			gbc.fill = GridBagConstraints.BOTH;
			add(value, gbc);
			i++;

		}
	}

}
