package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;

public class GraphicLeaderCardView extends JToggleButton implements ToPaint{
	
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
	
	void update(LeaderCard leaderCard){
		if(leaderCard != null)
		loadImage("LeaderCard/" + leaderCard.getName() + ".jpg");
		else
			clean();
	}

	public void clean(){
		loadImage("PlayerImages/BLANK.png");
		this.setEnabled(false);
	}
	
}
