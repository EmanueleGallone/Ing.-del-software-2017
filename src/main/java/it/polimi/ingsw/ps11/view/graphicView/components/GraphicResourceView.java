package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class GraphicResourceView extends ResourceView {

	
	protected GraphicPaintedPanel resources = new GraphicPaintedPanel();
	
	@Override
	public void print(){
		resources.loadImage("playerImages/Resources.png");
	}

	public JPanel getComponent() {
		return resources;
	}

}