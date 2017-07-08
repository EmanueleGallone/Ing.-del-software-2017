package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicBoardView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicChooseResourceListPanel;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicConfirmPanelView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicLoginPanel;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPaintedButton;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPaintedPanel;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPlayerView;
import it.polimi.ingsw.ps11.view.viewEvents.EndTurnEvent;
import it.polimi.ingsw.ps11.view.viewEvents.TextualViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**<h3> Graphic View</h3>
 * <p> Classe che rappresenta la finestra generale della GUI, contiene un JPanel per la board Superiore(torri, chiesa e consiglio),
 * un JDialog per la board Inferiore(zone raccolta e produzione, mercato e dadi) un JPanel per la board Personale e un JTextPane per
 * la console vhe visualizza i messaggi  </p>
 * @see GraphicBoardView 
 * @see GraphicPlayerView 
 * @see GraphicConsole
 */
public class GraphicView extends View{

	JFrame window;																//Finestra Generale				
	protected JOptionPane exit;													//Finestra che si apre quando si vuole chiudere il gioco
	protected JDialog slideDialog;												//Pannello interno alla slideBoardView
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello

    private GraphicPaintedPanel cardZoomPanel;
    private GraphicLoginPanel loginPanel = new GraphicLoginPanel();
    //private EventHandler<Message> messageHandler = new EventHandler<>();
    
    private GraphicChooseResourceListPanel chooseResource;
    private GraphicConfirmPanelView confirmPanelView;
    
	public GraphicView() {
		
		window = new JFrame();
		window.setTitle("Game Window");											//Setup la finestra principale del gioco
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.pack();
        
        GraphicBoardView graphicBoardView = new GraphicBoardView();
        GraphicPlayerView graphicPlayerView = new GraphicPlayerView();
        GraphicConsole graphicConsole = new GraphicConsole();
        JButton exit = new JButton("X"), minimize = new JButton("_");
        JPanel panel = new JPanel();
                
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
                
		GridBagLayout gblView = new GridBagLayout();
		gblView.columnWidths = new int[]{0, 0, 0, 0};		//QUI VANNNO LE LARGHEZZE IN PIXEL DELLE COLONNE, MA CONSIGLIO DI NN USARLO, CAMBIANDO SCHERMO VIENE TUTTO SBALLATO
		gblView.rowHeights = new int[]{0, 0, 0};			//QUI LE ALTEZZE DELLE RIGHE, SEMPRE IN PIXEL
		gblView.columnWeights = new double[]{0.469271, 0.152933, 0.353838, Double.MIN_VALUE};	//USA QUESTI, LARGHEZZE IN "PESO", VEDILE COME PERCENTUALI, LA SOMMA DEVE FARE 1
		gblView.rowWeights = new double[]{0.44074, 0.55926, Double.MIN_VALUE};		//COME SOPRA
        window.setLayout(gblView);
        
		GridBagLayout gblTurnPanel = new GridBagLayout();
		gblTurnPanel.columnWidths = new int[]{0, 0, 0, 0};
		gblTurnPanel.rowHeights = new int[]{0, 0, 0};
		gblTurnPanel.columnWeights = new double[]{0.9, 0.05, 0.05, Double.MIN_VALUE};
		gblTurnPanel.rowWeights = new double[]{0.05, 0.95, Double.MIN_VALUE};
		panel.setLayout(gblTurnPanel);
               
        JPanel boardPanel = graphicBoardView.getMainBoard().getComponent(),
        	   playerPanel = graphicPlayerView.getComponent(),
        	   consolePanel = graphicConsole.getComponent();
        cardZoomPanel = new GraphicPaintedPanel();
        cardZoomPanel.loadImage("BoardImages/baseCard.jpg");
        slideDialog = graphicBoardView.getSlideBoard().getComponent();
               
		GridBagConstraints gbcMainBoard = new GridBagConstraints();
		GridBagConstraints gbcPlayers = new GridBagConstraints();
		GridBagConstraints gbcCardZoom = new GridBagConstraints();
		GridBagConstraints gbcPanel = new GridBagConstraints();
		GridBagConstraints gbcConsole = new GridBagConstraints();
		GridBagConstraints gbcMinimize = new GridBagConstraints();
		GridBagConstraints gbcClose = new GridBagConstraints();
        
		gbcMainBoard.gridx = 0;
		gbcMainBoard.gridy = 0;
		gbcMainBoard.gridheight = 2;
		gbcMainBoard.fill = GridBagConstraints.BOTH;
		boardPanel.setPreferredSize(new Dimension(10, 10));
		window.add(boardPanel, gbcMainBoard);
			
		gbcPlayers.gridx = 1;
		gbcPlayers.gridy = 1;
		gbcPlayers.gridwidth = 2;
		gbcPlayers.fill = GridBagConstraints.BOTH;
		playerPanel.setPreferredSize(new Dimension(10, 10));
		window.add(playerPanel, gbcPlayers);
		
		gbcCardZoom.gridx = 1;
		gbcCardZoom.gridy = 0;
		gbcCardZoom.fill = GridBagConstraints.BOTH;
		cardZoomPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		window.add(cardZoomPanel, gbcCardZoom);
		
        gbcPanel.gridx = 2;
        gbcPanel.gridy = 0;
        gbcPanel.fill = GridBagConstraints.BOTH;
		panel.setPreferredSize(new Dimension(10, 10));
        window.add(panel, gbcPanel);
		
        gbcConsole.gridx = 0;
        gbcConsole.gridy = 1;
        gbcConsole.gridwidth = 3;
        gbcConsole.fill = GridBagConstraints.BOTH;
        panel.add(consolePanel, gbcConsole);

		gbcMinimize.gridx = 1;
		gbcMinimize.gridy = 0;
		gbcMinimize.fill = GridBagConstraints.BOTH;
		panel.add(minimize, gbcMinimize);
        
        gbcClose.gridx = 2;
        gbcClose.gridy = 0;
        gbcClose.fill = GridBagConstraints.BOTH;
        panel.add(exit, gbcClose);
		
        slideDialog.setBounds(0, (int)Math.round(screenSize.getHeight()*0.695), 
				(int)Math.round(screenSize.getWidth()*0.477), (int)Math.round(screenSize.getHeight()*0.305));
                        
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
        
//<-------------------------------INIZIO LISTENER------------------------------->
		
		exit.addActionListener(new Close());
		minimize.addActionListener(new Minimize());
        
        graphicBoardView.attachSlideListener(new ShowPanel());						//listener per il bottone che fa entrare il pannello della slideBoardView
        graphicBoardView.attachChangePlayer(new ChangePlayer());
        graphicConsole.attach(this);
        
        graphicBoardView.attach(eventListener);
        graphicPlayerView.attach(eventListener);
        graphicBoardView.attachCardListener(cardClickListener);
        graphicPlayerView.attachCardListener(cardClickListener);
        graphicPlayerView.attachEndTurnListener(new EndTurn());
      
//<-------------------------------FINE LISTENER------------------------------->
        
		this.boardView = graphicBoardView;
		this.you = graphicPlayerView;
		this.console = graphicConsole;
        
	}
	
	public void send(String string){
		String toSend = string;
		viewEvent.invoke(new TextualViewEvent(toSend));
	}
	
	private transient EventListener<ViewEventInterface> eventListener = new EventListener<ViewEventInterface>() {

		@Override
		public void handle(ViewEventInterface e) {
			viewEvent.invoke(e);
		}
	};

	@Override
	public void print() {
		
		boardView.print();
		you.print();
		window.setVisible(true);
		checkPanel();
	}

	@Override
	public void run() {	
        //window.setVisible(true);
        loginPanel.show();
	}
	
	@Override
	public void attachMessageListener(EventListener<Message> listener) {
		loginPanel.attach(listener);
	}
	
	@Override
	public void update(FamilyMemberManager familyMemberManager) {
		you.getChooseFamilyView().update(familyMemberManager);
		you.getChooseFamilyView().print();
		checkPanel();
	}
	
	
	public void checkPanel(){
		if(chooseResource != null && chooseResource.getComponent().isVisible())
			chooseResource.getComponent().setVisible(true);
		if(confirmPanelView != null && confirmPanelView.getComponent().isVisible())
			confirmPanelView.show();
	}
	
	@Override
	public void confirm(ConfirmEvent confirm) {
		confirmPanelView = new GraphicConfirmPanelView(viewEvent,confirm.getFloor(), window);
		confirmPanelView.show();
		window.setEnabled(false);
	}
	
	@Override
	public void chooseResource(ArrayList<ResourceList> resource) {
		chooseResource = new GraphicChooseResourceListPanel(viewEvent,resource, window);
		chooseResource.getComponent().setBounds((int)Math.round(screenSize.getHeight()*0.25), (int)Math.round(screenSize.getHeight()*0.4), 
				 (int)Math.round(screenSize.getWidth()*0.5), (int)Math.round(screenSize.getHeight()*0.33));
		chooseResource.getComponent().setUndecorated(true);
		chooseResource.getComponent().setVisible(true);
		window.setEnabled(false);
	}
	
	private class Close implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {		
				exit = new JOptionPane();
				exit.setVisible(true);
				if (JOptionPane.showOptionDialog(null, "Are you sure?", "Closing Game", JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) 
					{
					window.dispose();
					slideDialog.dispose();
					}
		}
	}
	
	private transient EventListener<Card> cardClickListener = new EventListener<Card>() {

		@Override
		public void handle(Card e) {
			String cardType = e.getClass().getSimpleName();
			cardZoomPanel.loadImage(cardType+"/"+ e.getName()+".png");
			cardZoomPanel.repaint();
		}
	};
	
	private class Minimize implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {
			window.setState(JFrame.ICONIFIED);
		}
	}
	
	public class ShowPanel implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {			
			slideDialog.setVisible(true);
			}
		}
	
	public class EndTurn implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Turno finito");
			viewEvent.invoke(new EndTurnEvent());
			}
	}
	
	public class ChangePlayer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			int playerIndex = Integer.parseInt(((GraphicPaintedButton) event.getSource()).getName());
			ArrayList<Player> players = game.getRoundManager().getCurrentOrder();
			if(playerIndex < players.size()){
				you.update(players.get(playerIndex));
			}
		}
		
	}
}