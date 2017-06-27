package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;

public class TextualPlayerView extends PlayerView{

	public TextualPlayerView() {
		resourceView = new TextualResourceView();
		cardManagerView = new TextualCardManagerView();
		chooseFamilyView = new TextualChooseFamilyView();
	}
	
	public TextualPlayerView(Player player){
		this();
		update(player);
	}
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.print("Player \nName: "  + player.getName() + "\nResources: ");
		resourceView.print();
		console.println("\nCards: ");
		cardManagerView.print();
		console.println("\n FamilyMembers");
		chooseFamilyView.print(); 
	}

}
