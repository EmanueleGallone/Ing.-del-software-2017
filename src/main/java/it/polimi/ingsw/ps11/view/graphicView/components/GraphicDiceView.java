package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;

public class GraphicDiceView extends DiceView {

	protected JPanel dice = new JPanel();
	protected BufferedImage background;
	
	@Override
	public void print() {
		dice.setBorder(BorderFactory.createLoweredBevelBorder());
		//background = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("BoardComponentsImages/Dices.png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	public JPanel getComponent(){
		return dice;
	}
	
	/*
	@Override
	public void update(DiceManager dices) {
		super.update(dices);
		
	}
	*/

}
