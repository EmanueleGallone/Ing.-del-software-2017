package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class GraphicTowerView extends TowerView{

	protected JPanel tower = new JPanel();
	protected BufferedImage background;
	//pannello Tower
	
	public GraphicTowerView(Class<? extends Tower> whichTower, String towerName) {
		super(whichTower,towerName);		
		tower = new JPanel();
		for(int i = 0; i< TOWERNUMBER; i++){
			floorViews.add(new GraphicFloorView(whichTower, i));
		}
	}
	
	public GraphicTowerView(Class<? extends Tower> whichTower) {
		this(whichTower, whichTower.getSimpleName());
	}

	@Override
	public void print() {
		tower.setBorder(BorderFactory.createLoweredBevelBorder());
		//background = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("BoardComponentsImages/" + towerName + ".png");
		BufferedImage result = null;
		try {
			result = ImageIO.read(imagePath);
		} catch (IOException e) {
			System.err.println("Errore, immagine non trovata");
		}
		
		return result;
	}
	
	public JPanel getComponent(){
		return tower;
	}

}
