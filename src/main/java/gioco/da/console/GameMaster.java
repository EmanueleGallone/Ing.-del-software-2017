package gioco.da.console;

import java.util.ArrayList;

public class GameMaster {
	
	private final int MIN_PLAYER = 2;
	private final int MAX_PLAYER = 4;
	//private int timeout = 60;
	
	private ArrayList<Partita> games = new ArrayList<Partita>();
	private ArrayList<Client> clientNonInGioco = new ArrayList<Client>(); //ho davvero bisogno di questo?
	private ArrayList<Player> giocatori = new ArrayList<Player>();

	
	public void add(Client c){
		//ad ogni accept connection viene chiamato questo metodo
		clientNonInGioco.add(c);
		giocatori.add(c.getPlayer());
		System.out.println("Giocatore aggiunto!"+ "\t array size= " + clientNonInGioco.size());
		System.out.print("\n");
		
		if(clientNonInGioco.size() == MIN_PLAYER){
			//timeout.start
			creaPartita(); //va tolto una volta implementato il timeout; usato solo per testing
		}
		if (clientNonInGioco.size() == MAX_PLAYER){
			creaPartita(); //timeout.stop
		}
		
	}
	
	//metodo per ritornare la partita per delegarla al controller. Molto probabilmente inutile
	public Partita delegaPartitaController(int index){
		return games.get(index);
	}
	
	public void creaPartita(){
		System.out.println("Partita Creata! \n\n");
		@SuppressWarnings("unchecked") //come si fa il check per il casting? per ora lo neutralizzo
		Partita partita = new Partita((ArrayList<Player>)giocatori.clone());
		games.add(partita);
		clientNonInGioco.clear();
		giocatori.clear();
	}
	
	public Partita getPartita(int number){
		return games.get(number);
	}

}
