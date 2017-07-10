package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public interface ToPaint {
	
	public void paintComponent(Graphics g);
	
	public default BufferedImage getImage(String url){
		BufferedImage result = null;
		try {
			result = ImageIO.read(getClass().getClassLoader().getResource(url));
		} catch (IOException | IllegalArgumentException e) {
			System.err.println("Errore, immagine non trovata url: " + url);
			e.printStackTrace();
		}
		
		return result;
	}	
}
