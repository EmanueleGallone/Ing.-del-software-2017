package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainBoard extends JPanel {

	public MainBoard(int floors, int cardtypes) {

	}
	
	private static final long serialVersionUID = -4151260962359176200L;
	private BufferedImage image = loadImage();
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("MainBoard.png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	public void paint(Graphics g) {
		Dimension size = getSize();
		g.drawImage(image, 0, 0,size.width, size.height,0, 0, image.getWidth(), image.getHeight(), null);
		
	}

}
