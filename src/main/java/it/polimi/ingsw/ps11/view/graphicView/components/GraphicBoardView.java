package it.polimi.ingsw.ps11.view.graphicView.components;


import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.player.Player;
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

	private GraphicMainBoardView mainBoardPanel = new GraphicMainBoardView();	//Parte fissa della Board
	private GraphicSlideBoardView slideBoardPanel = new GraphicSlideBoardView();	//Parte della Board che compare e scompare
	
	public GraphicBoardView() {
		
		this.councilPalaceView = mainBoardPanel.getGraphicCouncilPalaceView();
		this.towerViews = mainBoardPanel.getTowerViews();
		this.churchView = mainBoardPanel.getChurchView();
		
		this.productionView = slideBoardPanel.getProductionView();
		this.harvestView = slideBoardPanel.getHarvestView();
		this.diceView = slideBoardPanel.getDiceView();
		this.marketView = slideBoardPanel.getMarketView();
	}
	
	@Override
	public void print() {
		
		mainBoardPanel.getCouncilPalaceView().setCurrentOrder(this.currentOrder);
		mainBoardPanel.print();
		slideBoardPanel.print();
		
	};
	
	//<-------------------------------INIZIO ATTACH------------------------------->
		
	@Override
	public void attach(EventListener<ViewEventInterface> listener) {	//attach il listener ad ogni parte della board
		super.attach(listener);
		mainBoardPanel.attach(listener);
		slideBoardPanel.attach(listener);
	}

	public void attachSlideListener(ShowPanel showPanel) {				//attach la finestra principale al bottone che 
		mainBoardPanel.attachSlideListener(showPanel);						//mostra la parte della board nascosta
	}

	public void attachChangePlayer(EventListener<Player> changePlayer) {			//attacha la finestra principale ai bottoni che
		mainBoardPanel.attachChangePlayerListener(changePlayer);						//switchano tra le board dei player
	}
	
	public void attachCardListener(EventListener<Card> zoomCard) {
		mainBoardPanel.attachCardListener(zoomCard);
	}

	//<-------------------------------INIZIO GETTER------------------------------->
	
	public GraphicMainBoardView getMainBoard(){
		return mainBoardPanel;
	}
	
	public GraphicSlideBoardView getSlideBoard(){
		return slideBoardPanel;
		
	}
}
