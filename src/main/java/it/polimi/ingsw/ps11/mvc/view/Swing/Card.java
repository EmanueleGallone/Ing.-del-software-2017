package it.polimi.ingsw.ps11.mvc.view.Swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Card extends JButton{
	
private BufferedImage image;

	public Card(String cardName) {
		
		image = loadImage(cardName);
	}
	
	private BufferedImage loadImage(String name){
		URL imagePath = getClass().getResource(name + ".png");
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
