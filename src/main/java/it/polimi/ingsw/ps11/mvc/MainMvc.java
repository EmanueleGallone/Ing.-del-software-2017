package it.polimi.ingsw.ps11.mvc;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.controller.Controller;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualView;

public class MainMvc {
	
	
		public static void main(String[] args){
			
			TextualView textualView = new TextualView();
			ArrayList<Player> players = new ArrayList<>();
			
			//Player p1 = new Player(Colors.RED);
			//Player p2 = new Player(Colors.BLUE);
			
			Player p1 = new Player();
			Player p2 = new Player();
			p1.setName("Jack");
			p2.setName("Sparrow");
			
			players.add(p1);
			players.add(p2);
			
			Game game = new Game(players);
			
			Controller controller = new Controller(new Model(game), textualView);
			controller.start();
		}
}
