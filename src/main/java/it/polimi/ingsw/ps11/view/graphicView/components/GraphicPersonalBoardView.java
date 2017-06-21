package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.PersonalBoardView;

public class GraphicPersonalBoardView extends PersonalBoardView {

	protected JPanel personalBoard = new JPanel();
	protected BufferedImage background;
	
	@Override
	public void print() {
		background = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("Tower.png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	public JPanel getComponent(){
		return personalBoard;
	}

}