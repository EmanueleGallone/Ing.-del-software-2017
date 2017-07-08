package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;
/**
 * <h3> GraphicDevelopmentCardView</h3>
 * <p> Classe per la visualizzazione delle carte, contiene un pulsante raffigurante la carta che se cliccato crea una finestra
 * zoom che permette di visualizzare la carta su dimensione maggiore</p>
 * @see DevelopmentCardView
 */
public class GraphicDevelopmentCardView extends DevelopmentCardView{

	GraphicPaintedButton image;
	int cont = 0;
	
	private EventHandler<Card> cardClickEvent = new EventHandler<>();
	
	public GraphicDevelopmentCardView() {
		image = new GraphicPaintedButton();
		image.addActionListener(new ZoomCard());
	}
	
	public GraphicPaintedButton getComponent(){
		return image;
	}

	public void print(){

		if(developmentCard!= null){
			image.loadImage(developmentCard.getId() +"/" + developmentCard.getName() + ".png");
		}
		else 
			image.loadImage("PlayerImages/BLANK.png");
		image.repaint();
	}

	public void attachCardListener(EventListener<Card> zoomCardListener) {
		cardClickEvent.attach(zoomCardListener);
	}	
	
	public class ZoomCard implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(developmentCard != null)
				cardClickEvent.invoke(developmentCard);
		}
	}
	
}