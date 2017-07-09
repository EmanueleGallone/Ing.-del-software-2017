package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicCardManagerView.LeaderAction;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;

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
