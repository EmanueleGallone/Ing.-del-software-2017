package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.components.TextualCardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualDevelopmentCardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class GraphicFloorView extends FloorView {
	
	protected JPanel floor = new JPanel();
	protected BufferedImage background;
	
	public GraphicFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new TextualDevelopmentCardView();
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
	
	@Override
	public void selected() {
		// TODO Auto-generated method stub
		//cosa accade quando e' selezionata? zan zan zaaaan
	}

}
