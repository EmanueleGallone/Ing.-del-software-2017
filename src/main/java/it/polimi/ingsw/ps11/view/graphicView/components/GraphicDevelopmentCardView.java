package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JDialog;

import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;
/**
 * <h3> GraphicDevelopmentCardView</h3>
 * <p> Classe per la visualizzazione delle carte, contiene un pulsante raffigurante la carta che se cliccato crea una finestra
 * zoom che permette di visualizzare la carta su dimensione maggiore</p>
 * @see DevelopmentCardView
 */
public class GraphicDevelopmentCardView extends DevelopmentCardView{

	ViewCard dialog;
	GraphicPaintedButton image;

	
	public GraphicDevelopmentCardView() {
		image = new GraphicPaintedButton();
		image.addActionListener(new Zoom());
	}
	
	public GraphicPaintedButton getComponent(){
		return image;
	}

	public void print(){
//		image.setName(card.getName());
		if(card!= null)
			image.loadImage("/cards/" + card.getName() + ".png");
	}


	private class Zoom implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			dialog = new ViewCard();
			dialog.setPreferredSize(new Dimension(320,460));
			dialog.setLocationRelativeTo(null);
			dialog.setUndecorated(true);
			dialog.pack();
			if(card != null)
				dialog.setVisible(true);		
			
		}
	}
	
	private class ViewCard extends JDialog implements WindowFocusListener{

		GraphicPaintedPanel image = new GraphicPaintedPanel();
		
		public ViewCard() {
			if(card != null)
				image.loadImage(card.getName());
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