package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class GraphicResourceView extends ResourceView {

	
	protected GraphicBackground resources = new GraphicBackground();
	
	@Override
	public void print(){
		resources.loadImage("boardImages/Resources.png");
	}

	public JPanel getComponent() {
		return resources;
	}

}