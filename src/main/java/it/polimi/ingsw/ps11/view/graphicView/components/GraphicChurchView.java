package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;

public class GraphicChurchView extends ChurchView {

	protected JPanel church = new JPanel();
	
	public JPanel getComponent(){
		return church;
	}
	
	@Override
	public void print() {
		church.setBorder(BorderFactory.createLoweredBevelBorder());

	}
}
