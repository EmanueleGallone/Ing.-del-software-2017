package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;

public class GraphicCouncilPalaceView extends CouncilPalaceView{
	
	protected JPanel councilPalace = new JPanel();
	protected BufferedImage background;

	@Override
	public void print() {
		councilPalace.setBorder(BorderFactory.createLoweredBevelBorder());
		//background = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("BoardComponentsImages/CouncilPalace.png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	public JPanel getComponent(){
		return councilPalace;
	}
}
