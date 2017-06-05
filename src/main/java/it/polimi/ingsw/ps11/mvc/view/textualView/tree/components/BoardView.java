package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.mvc.view.textualView.Console;

public class BoardView extends Container{

	private Board board;
	
	public BoardView() {
		super();
	}
	
	public BoardView(String id) {
		super(id);
	}
	
	@Override
	public void print() {
		super.print();
		new Console().print("");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
	}
	
	public void update(Board board){
		this.board = board;
	}


}
