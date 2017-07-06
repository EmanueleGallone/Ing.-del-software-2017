package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JToggleButton;

public class GraphicLeaderCardView extends JToggleButton{
	
	protected BufferedImage background;
	private boolean painted = false;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(painted){
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
		} catch (IOException | IllegalArgumentException e) {
			System.err.println("Errore, immagine non trovata");
			e.printStackTrace();
		}
		
		background = result;
	}

}
