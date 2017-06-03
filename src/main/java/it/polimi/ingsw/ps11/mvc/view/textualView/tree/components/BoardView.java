package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;

public class BoardView extends Container{

	
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

}
