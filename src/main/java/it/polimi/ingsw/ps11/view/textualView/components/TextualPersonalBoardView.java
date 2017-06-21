package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PersonalBoardView;

public class TextualPersonalBoardView extends PersonalBoardView{

	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		TextualDevelopmentCardView developmentCardView = new TextualDevelopmentCardView();
		
		for(ArrayList<DevelopmentCard> deck : cardManager.getAllCards().values()){
			int i = 0;
			for(DevelopmentCard card : deck){
				if (i == 0){
					console.print(card.getClass().getSimpleName() + " : ");
					i++;
				}
				//console.print(card.getName() + "   ");
				developmentCardView.update(card);
				developmentCardView.print();
			}
			console.print("\n");
		}
	}

}
