package it.polimi.ingsw.ps11.model.game;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3>RoundManager</h3>
 * <p> Classe che gestisce e organizza i turni dei giocatori.</p>
 */
public class RoundManager implements Serializable{

	private static final int MAX_ROUND_PER_TURN = 4;
	private static final int MAX_PERIOD = 3;
	
	private ArrayList<Player> players = new ArrayList<>();
	private int round = 1; //il round finisce quando i giocatori hanno tutti fatto 1 mossa. Quando i giocatori hanno fatto 4 mosse, allora vuol dire che siamo alla fine del round 4
	private int turn = 1; //dopo che è finito il round 4, vuol dire che e' terminato il turno
	private int period = 1; 
	private int actualPlayer = -1; 
	
	private EventHandler<RoundManager> newPeriod = new EventHandler<>();
	private EventHandler<RoundManager> newTurn = new EventHandler<>();
	
	public RoundManager(ArrayList<Player> players){
		this.players = players;
	}
	/**<h3> void nextRound() </h3>
	 * <p> Riporta il round al numero 1, incrementa il contatore del turno e ricomincia dal nuovo primo giocatore</p>
	 */
	private void nextRound(){
		if(round == MAX_ROUND_PER_TURN){
			round = 1; //resetto il round
			turn++; //incremento il turno
			actualPlayer = 0; //punto al primo giocatore
			
			if(((turn+1) % 2) == 0){ //il periodo finisce sui turni pari; il +1 serve altrimenti sul secondo turno del terzo periodo non funziona
				period++; //incrementa il periodo, il turno ed il round sono già aggiornati nell'if precedente
				
			}
			return;
		}
		
		round++;
		actualPlayer = 0;
		
	}

	public void setNewOrder(ArrayList<Player> players){
		this.players = players;
	}
	
	public ArrayList<Player> getCurrentOrder() {
		return players;
	}
	
	/**<h3> Player next() </h3>
	 * <p>Se non è finito il round passa al prossimo giocatore, se è finito passa al prossimo round</p>
	 * @return il prossimo player nell'ordine di gioco
	 */
	public Player next(){
		if(!gameIsOver() && !roundIsOver()){
			actualPlayer++;
		}
		
		if(roundIsOver()){
			nextRound();
		}
		
		return this.players.get(actualPlayer);
	}
	
	public int getRound() {
		return round;
	}
	public int getTurn() {
		return (turn/period); //all'esterno i turni sono solo 2, per periodo
	}
	public int getPeriod() {
		return period;
	}
	
	/**<h3> boolean turnIsOver() </h3>
	 * <p>Indica se il turno è finito</p>
	 * @return true se il turno è finito, false altrimenti
	 */
	public boolean turnIsOver(){
		//il turno è finito quando i round sono pari al numero di giocatori
		return (round >= MAX_ROUND_PER_TURN);
	}
	
	/**<h3> boolean roundIsOver() </h3>
	 * <p>Indica se il round è finito, ovvero ogni giocatore ha terminato il proprio turno</p>
	 * @return true se il round è finito, false altrimenti
	 */
	public boolean roundIsOver(){
		//quando i giocatori hanno tutti fatto una mossa
		return (actualPlayer >= players.size());
	}
	
	public Player getCurrentPlayer() {
		return players.get(actualPlayer);
	}
	
	/**<h3> boolean gameIsOver </h3>
	 * <p>Indica se l'intera partita è terminata</p>
	 * @return true se il periodo ha raggiunto il limite, false altrimenti
	 */
	public boolean gameIsOver(){
		return period>MAX_PERIOD;
	}
	
	/**<h3> void newPeriod(EventListener<RoundManager>) </h3>
	 * <p>Attacca il listener alla nuova partita</p>
	 */
	public void newPeriod(EventListener<RoundManager> listener){
		newPeriod.attach(listener);
	}
	
	/**<h3> void newTurn(EventListener<RoundManager>) </h3>
	 * <p>Attacca il listener al nuovo turno</p>
	 */
	public void newTurn(EventListener<RoundManager> listener){
		newTurn.attach(listener);
	}
	
}
