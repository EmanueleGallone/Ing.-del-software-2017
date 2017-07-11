package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;
/**
 * <h3> GraphicDevelopmentCardView</h3>
 * <p> Classe per la visualizzazione delle carte di tipo Development card, contiene un pulsante raffigurante la carta che se cliccato crea 
 * notifica il pannello di zoom per visualizzare la carta su dimensione maggiore</p>
 * @see DevelopmentCardView
 */
public class GraphicDevelopmentCardView extends DevelopmentCardView{

	private GraphicPaintedButton buttonImage;
	
	private EventHandler<Card> cardClickEvent = new EventHandler<>();
	
	public GraphicDevelopmentCardView() {
		buttonImage = new GraphicPaintedButton();
		buttonImage.addActionListener(new ZoomCard());
	}
	
	public GraphicPaintedButton getComponent(){
		return buttonImage;
	}

	public void print(){

		if(developmentCard!= null){
			buttonImage.loadImage(developmentCard.getId() +"/" + developmentCard.getName() + ".png");
		}
		else 
			buttonImage.loadImage("PlayerImages/BLANK.png");
		buttonImage.repaint();
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