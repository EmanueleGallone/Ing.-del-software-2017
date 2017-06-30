package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * <h3> GraphicPaintedPanel</h3>
 * <p> Classe che estende JPanel. Aggiunge la possibilità di caricare un immagine direttamente sul pannello senza l'ulteriore 
 * aggiunta di componenti</p>
 * @see View
 */
public class GraphicPaintedPanel extends JPanel {
	
	//JPanel con immagine fissa
	
	BufferedImage background;
	
	public GraphicPaintedPanel(){
	}
	
	 @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension size = getSize();
		g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);
		
	}
	
	public void loadImage(String url){
		
		URL imagePath = getClass().getResource(url);
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		background = result;
	}

}
