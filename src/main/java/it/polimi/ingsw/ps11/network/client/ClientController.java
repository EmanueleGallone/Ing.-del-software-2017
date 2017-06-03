package it.polimi.ingsw.ps11.network.client;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.ps11.mvc.view.Swing.View;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualView; 

public class ClientController {

	public ClientController(String mode, Object read) {
		String[] parts = ((String) read).split(",");		//casting?
		ArrayList<String> players = new ArrayList<>(Arrays.asList(parts));
		if(mode.equals("testuale")) {
			TextualView view = new TextualView();
		}
		else {View view = new View(players);}
	}

	public void activate(Object object) {
		
	}

}
