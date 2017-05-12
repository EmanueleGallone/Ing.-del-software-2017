package ProvaServerGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partita {
	
	int numPlayers;
		
	public Partita(Map<String, Client> PlayersIngame){
	
		List<String> Names = new ArrayList<>(PlayersIngame.keySet());
		
        System.out.println("Giocatori presenti :\n");
		for(String name : Names) {
            System.out.println(name+". \n");
        }
		
		numPlayers = Names.size();
		
		
		/**in base al numero di giocatori crea una partita diversA
		
			Client c1 = PlayersIngame.get(Names.get(0));   			associa a c1 la connessione del giocatore 1 ecc
			Board player1 = new Board(new Player(keys.get(0)), c1);	creo una board per ciascun giocatore
			Model model = new Model();								creo il model della partita
			Controller controller = new Controller(model);			creo il controller per la partita
			model.addObserver(player1);								aggiungo ogni giocatore tra gli observer del model
			player1.addObserver(controller);						aggiungo il controller tra gli osservatori di ogni giocatore
	}*/


	}
}

