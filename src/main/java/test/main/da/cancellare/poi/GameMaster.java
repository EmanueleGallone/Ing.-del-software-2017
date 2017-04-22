package test.main.da.cancellare.poi;

import java.util.ArrayList;

public class GameMaster {
	
	private final int MIN_PLAYER = 2;
	private final int MAX_PLAYER = 4;
	private int timeout = 60;
	
	private ArrayList<Partita> games = new ArrayList<>();
	private ArrayList<Client> clientNonInGioco = new ArrayList<>();
	private ArrayList<Player> giocatori = new ArrayList<>();

	
	public void add(Client c){
		//ad ogni accept connection viene chiamato questo metodo
		clientNonInGioco.add(c);
		giocatori.add(new Player());
		System.out.println("Giocatore aggiunto!"+ clientNonInGioco.size());
		
		if(clientNonInGioco.size() == MIN_PLAYER){
			//timeout.start
			creaPartita();
		}
		if (clientNonInGioco.size() == MAX_PLAYER){
			creaPartita(); //timeout.stop
		}
		
	}
	
	public void creaPartita(){
		Partita partita = new Partita((ArrayList<Player>)giocatori.clone());
		games.add(partita);
		clientNonInGioco.clear();
		giocatori.clear();
	}
	
	public void gestisciPartita(){
		System.out.println("sono in gestisci partita!");
	}
	
	public Partita getPartita(int number){
		return games.get(number);
	}

}
