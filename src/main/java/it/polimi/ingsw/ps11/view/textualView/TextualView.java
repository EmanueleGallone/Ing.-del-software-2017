package it.polimi.ingsw.ps11.view.textualView;


import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**
 * <h3>TextualView</h3>
 * <p> 
<<<<<<< HEAD
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco. Il suo funzionamento e' semplice:
 * dal server arriva un oggetto del gioco e viene stampato a video; la console e' sempre in ascolto di eventuali input; se il giocatore
 * inserisce un comando contenuto nella Map allora viene invocato l'evento ed inviato al server
=======
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco.
>>>>>>> GabLog
 * </p>
 */
public class TextualView extends View {
	
	//le istruzioni vanno aggiornate allora
	private String instructions = "\n instruction:"
			+ "\nif you want to select the Yellow Tower type -> yellow tower"
			+ "\nif you want to select the floor of a tower type \" yellow tower 1 \""
			+ "\netc etc "; 
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		console = new TextualConsole();

	}
	
	@Override
	public void print() {
		//questo metodo potrebbe essere eliminato
		//boardView.print();
		//you.print();
		console.println(instructions); 

	}

	@Override
	public void run() {
		//manca la map con i comandi
		//il menu si puo' togliere in quanto viene inviato dal server
		print();
		String input = new String();
		while (!(input = console.read()).equals("q")){

			//if(viewEvent.get(bla bla bla...) != null)
			//spara evento
		}
	}
	
	@Override
	public void update(Board board){
		boardView.update(board); //in realta' non serve, la faccio all'interno di textualboardview
		new TextualBoardView(board).print();
	}

	@Override
	public void update(Player player){
		you.update(player);
		new TextualPlayerView(player).print();
	}
	
	//se mi si chiede di scegliere un familiare?
	
}
