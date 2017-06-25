package it.polimi.ingsw.ps11.view.graphicView.components;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ShowPanel;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;

public class GraphicBoardView extends BoardView {
	
	//classe intermedia che raggruppa i due pannelli della mainBoard

	GraphicMainBoardView mainBoard = new GraphicMainBoardView();		//Parte fissa della Board
	GraphicSlideBoardView slideBoard = new GraphicSlideBoardView();		//Parte della Board che compare e scompare
	
	@Override
	public void print() {
		mainBoard.print();
		slideBoard.print();
	};
	
	public GraphicMainBoardView getMainBoard(){
		return mainBoard;
	}
	
	public GraphicSlideBoardView getSlideBoard(){
		return slideBoard;
		
	}
	
	@Override
	public void attach(EventListener<ViewEventInterface> listener) {		//attach il listener ad ogni parte della board
		super.attach(listener);
		mainBoard.attach(listener);
		slideBoard.attach(listener);
	}

	public void attachSlideListener(ShowPanel showPanel) {					//attach la finestra principale al bottone interno
		mainBoard.attachSlideListener(showPanel);
	}

}
