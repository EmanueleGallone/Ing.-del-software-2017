package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class GraphicActionSpace extends JButton implements ToPaint{
	
	//JButton con aggiunta di nome nel costruttore e immagine caricabile
	
	private String name;
	private boolean painted = false;
	private BufferedImage background;
	
	public GraphicActionSpace(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
		
	}
	
	@Override
	public void paintComponent(Graphics g) {		//se è stata caricata l'iimagine, allora la mostra
	 if(painted = true){
		super.paintComponent(g);
		Dimension size = getSize();
		//g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);
	 }
	}

	@Override
	public void loadImage(String url){				//riceve l'url dell'immagine da carica e la carica
		
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
