package it.polimi.ingsw.ps11.view.textualView.tree.components;

import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;

public class TextualBoardView extends TextualContainer{

	private Board board;
	
	public TextualBoardView() {
		super();
	}
	
	public TextualBoardView(String id) {
		super(id);
	}
	
	@Override
	public void print() {
		super.print();
		new TextualConsole().println("");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
	}
	
	public void update(Board board){
		this.board = board;
	}


}
