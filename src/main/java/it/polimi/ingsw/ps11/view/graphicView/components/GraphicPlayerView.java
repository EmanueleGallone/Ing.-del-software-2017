package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;

public class GraphicPlayerView extends PlayerView{
	
	protected JPanel personal = new JPanel();

	@Override
	public void print() {
		
	}

	public JPanel getComponent() {
		personal.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		return personal;
	}
}
