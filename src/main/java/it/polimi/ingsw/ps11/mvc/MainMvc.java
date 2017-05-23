package it.polimi.ingsw.ps11.mvc;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.controller.Controller;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class MainMvc {
	
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
			//textualView.update(controller.model);
			controller.start();
		}
}
