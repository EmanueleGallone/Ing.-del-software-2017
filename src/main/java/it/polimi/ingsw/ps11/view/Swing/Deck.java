package it.polimi.ingsw.ps11.view.Swing;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

public class Deck extends JPanel {
	
	private BufferedImage image;
	
	int cards = 0;

	public Deck(String type, Color color, Point origin) {
		
		image = loadImage(type);
		
		setBorder(BorderFactory.createLineBorder(color, 5));
		setName(type);
        setBounds(origin.x, origin.y, 1000, 286);
        
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

	}
	
	public void addCard(){
		
		Card btnNewButton = new Card("Name Card");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = cards;
		cards++;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);	
	}
	
	private BufferedImage loadImage(String type){
		URL imagePath = getClass().getResource("carte/Plancia " + type + ".png");
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
