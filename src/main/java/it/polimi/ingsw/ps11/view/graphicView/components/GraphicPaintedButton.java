package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class GraphicPaintedButton extends JButton{
	
	protected BufferedImage background;
	protected Boolean painted = false;
	
	public GraphicPaintedButton() {
	}
	
	 @Override
		public void paintComponent(Graphics g) {
		 if(painted = true){
			super.paintComponent(g);
			Dimension size = getSize();
			g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);
		 }
		}
	
	public void loadImage(String url){
		
		painted = true;
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