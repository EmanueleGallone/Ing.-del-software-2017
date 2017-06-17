package it.polimi.ingsw.ps11.view.Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResourceManager extends JPanel {

	String[] resources;
	
	private BufferedImage image;
	
	public ResourceManager(String[] resources) {
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		for(int i=0; i<resources.length; i++){
			
			JLabel value = new JLabel("Resource value");
			value.setForeground(Color.BLUE);
			add(value);
		}
		
		image = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("Resources.png");
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
