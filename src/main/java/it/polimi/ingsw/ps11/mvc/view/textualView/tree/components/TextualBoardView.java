package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.mvc.view.textualView.TextualConsole;

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
		new TextualConsole().print("");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
	}
	
	public void update(Board board){
		this.board = board;
	}


}
