package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.components.TextualCardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class GraphicFloorView extends FloorView {
	
	protected JPanel floor = new JPanel();
	protected BufferedImage background;
	
	public GraphicFloorView(int whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new TextualCardView();
	}

	@Override
	public void print() {
		background = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("BoardComponentsImages/Floor.png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	public JPanel getComponent() {
		return floor;
	}

}