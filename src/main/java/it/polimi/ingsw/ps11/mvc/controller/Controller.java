package it.polimi.ingsw.ps11.mvc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
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
		view.start();
	
	}

	
//______________________________________________________________________________________________
	
	//MAIN
	
	public static void main(String[] args){
		
		/*System.out.println("Premi t per view testuale e g per grafica");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		TextualView textualView = null;
		
		if ( input.equals("t")){
			textualView = new TextualView();
		}
		*/
		TextualView textualView = new TextualView();
		ArrayList<Player> players = new ArrayList<>();
		
		Controller controller = new Controller(new Model(players), textualView);
		textualView.getGame().update(controller.model);
		controller.start();
	}
	
	
	
}
