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
	
	public GraphicTowerView(int whichTower, String towerName) {
		super(whichTower,towerName);		
		tower = new JPanel();
		for(int i = 0; i< TOWERNUMBER; i++){
			floors.add(new GraphicFloorView(whichTower, i));
		}
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

	@Override
	public void selected() {
		// TODO Auto-generated method stub
		//occhio gab, sto facendo in modo che ogni componente chieda poi cosa fare.
		//per esempio se sei nella selected della torre, qui ti chiedo di scegliere il piano, poi invocherò la selected del Floor e così via..
		//l'idea e' quella, per ora non cambio
		
	}

}
