package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.PersonalBoardView;

public class GraphicPersonalBoardView extends PersonalBoardView {

	protected JPanel personalBoard = new JPanel();
	
	@Override
	public void print() {
	}

	public JPanel getComponent(){
		return personalBoard;
	}

}
