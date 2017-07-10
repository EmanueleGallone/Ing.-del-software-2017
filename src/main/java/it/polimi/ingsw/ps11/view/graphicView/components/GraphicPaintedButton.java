package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
/**
 * <h3> GraphicPaintedButton</h3>
 * <p> Classe che estende JButton. Aggiunge la possibilità di assegnare un nome al pulsante tramite costruttore e aggiunge
 * un'immagine al pulsante se richiesto senza l'ulteriore aggiunta di componenti </p>
 */

public class GraphicPaintedButton extends JButton implements ToPaint{
		
	private BufferedImage background;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(background!=null){
			Dimension size = getSize();
			g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);
		}
	}
	
	public void loadImage(String url){
		background = getImage(url);
	}
}