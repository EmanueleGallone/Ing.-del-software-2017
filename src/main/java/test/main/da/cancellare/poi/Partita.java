package test.main.da.cancellare.poi;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.dices.BlackDice;

public class Partita {
	private Board board;
	private ArrayList<Player> giocatori;
	
	
	public Partita(ArrayList<Player> lista) {
		giocatori = lista;
		board = new Board();
	}

	@Override
	public String toString() {
		return "Partita [board=" + board + "\n\nGiocatori= "+giocatori.toString() + "]";
	}
	
	public void nuovoTurno(){
		Iterator<Player> it = giocatori.iterator();
		
		BlackDice b = board.getBlackDice();
		b.rollDice();
		
		for(Player p : giocatori)
			p.setFamilyMemberValue(b);
		
	}
	
	

}
