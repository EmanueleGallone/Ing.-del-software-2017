package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
/**
 * <h3> GraphicPaintedPanel</h3>
 * <p> Classe che estende JPanel. Aggiunge la possibilità di caricare un immagine direttamente sul pannello senza l'ulteriore 
 * aggiunta di componenti</p>
 * @see View
 */
public class GraphicPaintedPanel extends JPanel implements ToPaint{
		
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
