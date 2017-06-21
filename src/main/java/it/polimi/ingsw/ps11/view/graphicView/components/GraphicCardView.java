package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import it.polimi.ingsw.ps11.view.viewGenerica.components.CardView;

public class GraphicCardView extends CardView{

	protected JButton card = new JButton();
	protected BufferedImage background;

	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource(card.getName());
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	@Override
	public void print() {
		background = loadImage();
		//Recupera da file card.getName()
		//Setti l'immagine
		//card.paint(g);
	}
	
	public JButton getComponent(){
		return card;
	}
}
