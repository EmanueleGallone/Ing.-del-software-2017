package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;
/**
 * <h3> TextualCardManagerView</h3>
 * <p> Classe per la visualizzazione testuale del CardManager di ogni giocatore</p>
 * @see CardManagerView
 */
public class TextualCardManagerView extends CardManagerView{

	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
//		TextualDevelopmentCardView developmentCardView = new TextualDevelopmentCardView();
		
		for(ArrayList<DevelopmentCard> deck : cardManager.getAllCards().values()){
			int i = 0;
			for(DevelopmentCard card : deck){
				if (i == 0){
					console.println(card.getId() + "s : ");
					i++;
				}
				console.println("\n • "+card.getName());
//				developmentCardView.update(card);
//				developmentCardView.print();
			}
			console.print("\n");
		}
		console.println("LeaderCards : ");
		for(LeaderCard card : cardManager.getLeaderCards())
			if (card != null) {
				console.println(card.getName());
			}
	}

}
