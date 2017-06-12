package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class RoundManager {

	private static final int MAX_PERIOD = 3;
	private ArrayList<Player> players = new ArrayList<>();
	private int round = 1;
	private static final int MAX_ROUND_PER_TURN = 4;
	private boolean gameFinished = false;
	private int turn = 1;
	private static int period = 1; //static perchè il returnRefreshCardTurn altrimenti non ritorna il turno dove refreshare le carte
	private int actualPlayer = 0;
	private static int refreshCardTurn;
	
	public RoundManager(ArrayList<Player> players){
		this.players = players;
		refreshCardTurn = 1; //immagino che quando venga creato il round manager, ha senso settare come refreshcardTurn, il primo turno
	}
	
	private void nextRound(){
		//faccio un controllo sulla variabile gameFinished?
		if(round == MAX_ROUND_PER_TURN){
			round = 1; //resetto il round
			turn++; //incremento il turno
			actualPlayer = 0; //punto al primo giocatore
			refreshCardTurn += 2; //dopo ad esempio il primo turno, sara' il terzo turno quello dove si fa refresh delle carte
			
			if(((turn+1) % 2) == 0){ //il periodo finisce sui turni pari; il +1 serve altrimenti sul secondo turno del terzo periodo non funziona
				period++; //incrementa il periodo, il turno ed il round sono già aggiornati nell'if precedente
				
				if(period == MAX_PERIOD)
					gameFinished = true; //se il periodo è = 3 gioco finito
			}
			return;
		}
		
		round++;
		actualPlayer = 0;
		
	}
	
	
	public void setNewOrder(ArrayList<Player> players){
		this.players = players; //immagino che sia il palazzo del consiglio a fare il sorting e a passarmi l'arraylist già sorted
	}
	
	public ArrayList<Player> getCurrentOrder() {
		return players; //sarebbe meglio restituire una clone?
	}
	
	public Player next(){
		if(!gameFinished && !roundIsOver()){
			actualPlayer++; //incrementa solo se il round non è finito
		}
		
		if(roundIsOver()){ //se il round è finito, nextRound()
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
	
	public boolean turnIsOver(){
		//il turno è finito quando i round sono pari al numero di giocatori
		return (round >= MAX_ROUND_PER_TURN);
	}
	
	public boolean roundIsOver(){
		//quando i giocatori hanno tutti fatto una mossa
		return (actualPlayer >= players.size());
	}
	
	public Player getCurrentPlayer() {
		return players.get(actualPlayer);
	}
	
	public boolean gameFinished(){
		return gameFinished;
	}
	
	public static int getRefreshCardsTurn(){
		return (refreshCardTurn / period); //visto che i turni sono solo 2, ritorno solo 1 o 2
		//oppure si potrebbe semplicemente ritornare un boolean
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private static final int MAX_TURN = 6;
	private static final int MAX_PERIOD = 3;
	private static final int ROUND_FOR_PERIOD = 2;
	private static final int REFRESH_CARDS_TURN = 1;
	private int round = 1;
	private ArrayList<Player> players = new ArrayList<>();
	private int actualPlayer = 0; 
	private int period = 1;
	private int turn = 1;
	
	public RoundManager(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Player next() {
		if(!roundIsOver()){
			actualPlayer++;
			return players.get(actualPlayer);
		}
		
		return null;
	}
	
	public void nextRound(){
		if(!gameIsOver()){
			actualPlayer++;
			round++;
		}
		if( round == 4 && roundIsOver()){
			nextTurn();
		}
		
	}
	
	private void nextTurn(){
		if(!gameIsOver()){
			actualPlayer = 0;
			round = 1;
			turn++;
		}
		
		if( turn == MAX_TURN && turnIsOver()){
			period++;
			round = 1;
			turn = 1;
			nextRound();
		}
	}
	
	public boolean roundIsOver(){
		return (actualPlayer + 1 >= players.size());
	}
	
	public boolean turnIsOver(){
		return (round >= players.size());
	}
	
	public boolean gameIsOver(){
		return (period >= MAX_PERIOD);
	}
	
	public Player getCurrentPlayer() {
		return players.get(actualPlayer);
	}
	
	public ArrayList<Player> getCurrentOrder() {
		return players;
	}
	public void setNewOrder(ArrayList<Player> players) {
		this.players = players;
		nextRound();
	}
	
	public int getRound() {
		return round;
	}
	public int getTurn(){
		return turn;
	}
	public int getPeriod() {
		return period;
	}
	
	public static int getRefreshCardsTurn() {
		return REFRESH_CARDS_TURN;
	}*/
}
