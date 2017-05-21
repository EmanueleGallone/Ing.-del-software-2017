package it.polimi.ingsw.ps11.mvc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.textual.TextualView;

public class Controller {
	private Game model;
	private TextualView view;

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		this.view = view;
	}
	
// _______________ EVENT LISTENER _____________________
	
	
	

	
//__________________________________________________________
	
	private void start(){
		model.startGame();
		gestisciPartita(model.getPlayers());
		
		view.start();
		
		
	
	}
	
	private void gestisciPartita(ArrayList<Player> players){
		//funzione per ciclare sui giocatori e fargli fare le loro scelte
		//a chi lo faccio fare? al controller o al game?
		
			for(int i = 0; i < model.MAX_PERIODS; i++)
				for(int j = 0; j < model.MAX_TURN ; j++){
					for(int h = 0; h < players.size(); h++) //per ogni giocatore
						model.setPlayerCorrente(model.getPlayers().get(h)); //al momento non c'è ordinamento!
					
					
					//finite le operazioni
				}//fine ciclo per turni
	}

	
//______________________________________________________________________________________________
	
	//MAIN
	
	public static void main(String[] args){
		
		
		TextualView textualView = new TextualView();
		ArrayList<Player> players = new ArrayList<>();
		Player p1 = new Player();
		p1.setName("Jack");
		Player p2 = new Player();
		p2.setName("Sparrow");
		
		players.add(p1);
		players.add(p2);
		
		Controller controller = new Controller(new Model(players), textualView);
		textualView.update(controller.model);
		controller.start();
	}
	
	
	
}
