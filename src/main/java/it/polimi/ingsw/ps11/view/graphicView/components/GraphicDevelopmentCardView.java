package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JDialog;

import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;

public class GraphicDevelopmentCardView extends DevelopmentCardView{

	ViewCard dialog;
	GraphicPaintedButton image = new GraphicPaintedButton();
	String cardName;
	
	public GraphicPaintedButton getComponent(){
		return image;
	}

	public void print(String cardName) {
		image.addActionListener(new Zoom());
		this.cardName = cardName;
		image.loadImage("/cards/" + cardName + ".png");
	}

	@Override
	public void print() {		
	}
	
	private class Zoom implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			dialog = new ViewCard();
			dialog.setPreferredSize(new Dimension(320,460));
			dialog.setLocationRelativeTo(null);
			dialog.setUndecorated(true);
			dialog.pack();
			dialog.setVisible(true);		
			
		}
	}
	
	private class ViewCard extends JDialog implements WindowFocusListener{

		GraphicPaintedPanel image = new GraphicPaintedPanel();
		
		public ViewCard() {
			image.loadImage(cardName);
		}
		
		@Override
		public void windowGainedFocus(WindowEvent arg0) {
			dialog.dispose();
		}

		@Override
		public void windowLostFocus(WindowEvent arg0) {	
			dialog.dispose();
		}
		
	}
}
