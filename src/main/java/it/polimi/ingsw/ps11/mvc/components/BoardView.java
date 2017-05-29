package it.polimi.ingsw.ps11.mvc.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class BoardView extends TextualContainer{

	
	public BoardView() {
		
	}
	
	public BoardView(String id) {
		super(id);
	}
	
	
	
	@Override
	public void print() {
		printChild();
	}

	@Override
	public void selected() {
		System.out.println("Hai selezionato la board");
	}
}
