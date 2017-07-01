package it.polimi.ingsw.ps11.view.graphicView.components;


import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ChangePlayer;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ShowPanel;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
/**
 * <h3> GraphicBoardView</h3>
 * <p> Classe intermedia che raggruppa e fa da tramite tra la GraphicView e le sue due parti: 
 * MainBoard, sempre visibile, e SlideBoard, richiamabile con l'apposito tasto</p>
 * @see GraphicMainBoardView
 * @see GraphicSlideBoardView
 * @see BoardView
 */
public class GraphicBoardView extends BoardView {

	GraphicMainBoardView mainBoard = new GraphicMainBoardView();	//Parte fissa della Board
	GraphicSlideBoardView slideBoard = new GraphicSlideBoardView();	//Parte della Board che compare e scompare
	
	@Override
	public void print() {
		
		mainBoard.print();
		slideBoard.print();
		
	};
	
	//<-------------------------------INIZIO ATTACH------------------------------->
		
	@Override
	public void attach(EventListener<ViewEventInterface> listener) {	//attach il listener ad ogni parte della board
		super.attach(listener);
		mainBoard.attach(listener);
		slideBoard.attach(listener);
	}

	public void attachSlideListener(ShowPanel showPanel) {				//attach la finestra principale al bottone che 
		mainBoard.attachSlideListener(showPanel);						//mostra la parte della board nascosta
	}

	public void attachChangePlayer(ChangePlayer changePlayer) {			//attacha la finestra principale ai bottoni che
		mainBoard.attachChangePlayer(changePlayer);						//switchano tra le board dei player
	}
	
	//<-------------------------------INIZIO GETTER------------------------------->
	
	public GraphicMainBoardView getMainBoard(){
		return mainBoard;
	}
	
	public GraphicSlideBoardView getSlideBoard(){
		return slideBoard;
		
	}

}
