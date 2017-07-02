package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicBoardView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicChooseResourceListPanel;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicConfirmPanelView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPaintedButton;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPlayerView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicTurnPanel;
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

	JFrame window;												//Finestra Generale				
	protected JOptionPane exit;													//Finestra che si apre quando si vuole chiudere il gioco
	protected JDialog slideDialog;												//Pannello interno alla slideBoardView
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello

	public GraphicView() {
		
		window = new JFrame();
		window.setTitle("Game Window");											//Setup la finestra principale del gioco
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.pack();
                
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
                
		GridBagLayout gblView = new GridBagLayout();
		gblView.columnWidths = new int[]{0, 0, 0, 0};		//QUI VANNNO LE LARGHEZZE IN PIXEL DELLE COLONNE, MA CONSIGLIO DI NN USARLO, CAMBIANDO SCHERMO VIENE TUTTO SBALLATO
		gblView.rowHeights = new int[]{0, 0, 0};			//QUI LE ALTEZZE DELLE RIGHE, SEMPRE IN PIXEL
		gblView.columnWeights = new double[]{0.469271, 0.192933, 0.313838, Double.MIN_VALUE};	//USA QUESTI, LARGHEZZE IN "PESO", VEDILE COME PERCENTUALI, LA SOMMA DEVE FARE 1
		gblView.rowWeights = new double[]{0.196296, 0.803703, Double.MIN_VALUE};		//COME SOPRA
        window.setLayout(gblView);
        
        GraphicBoardView graphicBoardView = new GraphicBoardView();
        GraphicPlayerView graphicPlayerView = new GraphicPlayerView();
        GraphicConsole graphicConsole = new GraphicConsole();
        JButton exit = new JButton("X"), minimize = new JButton("_");
        GraphicTurnPanel playersTurn = new GraphicTurnPanel();
               
        JPanel boardPanel = graphicBoardView.getMainBoard().getComponent(),
        	   playerPanel = graphicPlayerView.getComponent(),
        	   consolePanel = graphicConsole.getComponent();
        slideDialog = graphicBoardView.getSlideBoard().getComponent();
               
		GridBagConstraints gbcMainBoard = new GridBagConstraints();
		GridBagConstraints gbcPlayers = new GridBagConstraints();
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
		
		gbcConsole.gridx = 1;
		gbcConsole.gridy = 0;
		gbcConsole.fill = GridBagConstraints.BOTH;
		consolePanel.setPreferredSize(new Dimension(10, 10));
		window.add(consolePanel, gbcConsole);
		
		GridBagConstraints gbcTurn = new GridBagConstraints();
		gbcTurn.gridx = 2;
		gbcTurn.gridy = 0;
		gbcTurn.fill = GridBagConstraints.BOTH;
		playersTurn.setPreferredSize(new Dimension(10, 10));
		window.add(playersTurn, gbcTurn);

		gbcMinimize.gridx = 1;
		gbcMinimize.gridy = 0;
		gbcMinimize.fill = GridBagConstraints.BOTH;
        playersTurn.add(minimize, gbcMinimize);
        
        gbcClose.gridx = 2;
        gbcClose.gridy = 0;
        gbcClose.fill = GridBagConstraints.BOTH;
        playersTurn.add(exit, gbcClose);
		
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
      
//<-------------------------------FINE LISTENER------------------------------->
        
		this.boardView = graphicBoardView;
		this.you = graphicPlayerView;
		this.console = graphicConsole;
        
	}
	
	public void send(String string){
		String toSend = string;
		System.out.println(toSend);
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
		console.println("Benvenuto ne: ");
		console.printError("\"Lorenzo il Magnifico\"");

	}

	@Override
	public void run() {
		
        window.setVisible(true);
        
	}
	
	@Override
	public void update(FamilyMemberManager familyMemberManager) {
		FamilyMemberManager fManager = you.getPlayer().getFamilyManager();
		fManager = familyMemberManager;
	}
	
	@Override
	public void confirm(ConfirmEvent confirm) {
		GraphicConfirmPanelView confirmPanelView = new GraphicConfirmPanelView(viewEvent,confirm.getFloor());
		confirmPanelView.setBounds((int)Math.round(screenSize.getHeight()*0.5), (int)Math.round(screenSize.getHeight()*0.3), 
				 (int)Math.round(screenSize.getWidth()*0.5), (int)Math.round(screenSize.getHeight()*0.462));
		confirmPanelView.setUndecorated(true);
		confirmPanelView.setVisible(true);		
	}

	@Override
	public void chooseResource(ArrayList<ResourceList> resource) {
		GraphicChooseResourceListPanel chooseResource = new GraphicChooseResourceListPanel(viewEvent,resource);
		chooseResource.getComponent().setBounds((int)Math.round(screenSize.getHeight()*0.85), (int)Math.round(screenSize.getHeight()*0.4), 
				 (int)Math.round(screenSize.getWidth()*0.5), (int)Math.round(screenSize.getHeight()*0.33));
		chooseResource.getComponent().setUndecorated(true);
		chooseResource.getComponent().setVisible(true);
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
	
	public class ChangePlayer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			int playerIndex = Integer.parseInt(((GraphicPaintedButton) event.getSource()).getName());
			you.update(game.getRoundManager().getCurrentOrder().get(playerIndex));
		}
		
	}
	public static void main(String[] args) {
		GraphicView view = new GraphicView();
		view.run();
	}
}