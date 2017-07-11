package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * <h3> ToPaint</h3>
 * <p> Interfaccia per il caricamento di un immagine tramite BufferedImage e stampa su componente grafico.</p>
 */
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
