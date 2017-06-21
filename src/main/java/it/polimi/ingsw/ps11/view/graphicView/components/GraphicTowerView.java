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
	Class<? extends Tower> color;

	//pannello Tower
	
	public GraphicTowerView(Class<? extends Tower> towerColor) {
		super(towerColor);
		this.color = towerColor;
		
		tower = new JPanel();
		
		floors.add(new GraphicFloorView(towerColor, 0));
		floors.add(new GraphicFloorView(towerColor, 1));
		floors.add(new GraphicFloorView(towerColor, 2));
		floors.add(new GraphicFloorView(towerColor, 3));
	}

	@Override
	public void print() {
		tower.setBorder(BorderFactory.createLoweredBevelBorder());
		//background = loadImage();
	}
	
	private BufferedImage loadImage(){
		URL imagePath = getClass().getResource("BoardComponentsImages/" + color.getClass().getSimpleName() + ".png");
		System.out.println(color.getClass().getSimpleName());
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
