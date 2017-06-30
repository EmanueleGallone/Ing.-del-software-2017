package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

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
/**
 * <h3> Graphic View</h3>
 * <p> Classe che rappresenta la finestra generale della GUI, contiene un JPanel per la board Superiore(torri, chiesa e consiglio),
 * un JDialog per la board Inferiore(zone raccolta e produzione, mercato e dadi) un JPanel per la board Personale e un JTextPane per
 * la console vhe visualizza i messaggi  </p>
 * @see GraphicBoardView 
 * @see GraphicPlayerView 
 * @see GraphicConsole
 */
public class GraphicView extends View{

	JFrame window = new JFrame();												//Finestra Generale				
	protected JOptionPane exit;													//Finestra che si apre quando si vuole chiudere il gioco
	protected JPanel boardPanel, playerPanel;									//Pannelli boardPrincipale e boardPersonale
	protected GraphicTurnPanel playersTurn = new GraphicTurnPanel();
	protected JDialog slideDialog;												//Pannello interno alla slideBoardView
	protected JTextPane consolePanel;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello

	public GraphicView() {
		you = new GraphicPlayerView();											//Board personale	
		boardView = new GraphicBoardView();										//Board generale
		console = new GraphicConsole();											//Console per la gestione dei messaggi
	}
	
	private transient EventListener<ViewEventInterface> eventListener = new EventListener<ViewEventInterface>() {

		@Override
		public void handle(ViewEventInterface e) {
			viewEvent.invoke(e);
		}
	};

	@Override
	public void print() {
		
		window.setTitle("Game Window");							//Setta la finestra principale del gioco
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
               
        boardPanel = graphicBoardView.getMainBoard().getComponent();
        slideDialog = graphicBoardView.getSlideBoard().getComponent();
        playerPanel = graphicPlayerView.getComponent();
        consolePanel = graphicConsole.getComponent();
               
		GridBagConstraints gbcMainBoard = new GridBagConstraints();
		GridBagConstraints gbcPlayers = new GridBagConstraints();
		GridBagConstraints gbcConsole = new GridBagConstraints();
		GridBagConstraints gbc = new GridBagConstraints();
        
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
		window.add(playersTurn, gbcTurn);
		
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        playersTurn.add(minimize, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        playersTurn.add(exit, gbc);
		
        slideDialog.setBounds(0, (int)Math.round(screenSize.getHeight()*0.695), 
				(int)Math.round(screenSize.getWidth()*0.467), (int)Math.round(screenSize.getHeight()*0.305));
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
				    
		graphicBoardView.print();
		graphicPlayerView.print();
		graphicConsole.println("Benvenuto ne: ");
		graphicConsole.printError("\"Lorenzo il Magnifico\"");
		
		exit.addActionListener(new Close());
		minimize.addActionListener(new Minimize());
		
		this.boardView = graphicBoardView;
		this.you = graphicPlayerView;
		this.console = graphicConsole;
        
        graphicBoardView.attachSlideListener(new ShowPanel());						//listener per il bottone che fa entrare il pannello della slideBoardView
        graphicBoardView.attachChangePlayer(new ChangePlayer());
        
        graphicBoardView.attach(eventListener);
        graphicPlayerView.attach(eventListener);
        
        window.setVisible(true);

	}

	@Override
	public void run() {
		
		GraphicView tryout = new GraphicView();
		tryout.print();
		
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
		GraphicView tryout = new GraphicView();
		tryout.print();
		
		BlueCard card = new BlueCard("name");
		
		ArrayList<Resource> array1 = new ArrayList<>();
		array1.add(new Coin(3));
		array1.add(new Wood(5));
		array1.add(new FaithPoint(2));
		array1.add(new VictoryPoint(4));
		ResourceList resourceList1 = new ResourceList(array1);

		Floor floor= new Floor();
		floor.getActionSpace().setResources(resourceList1);
		floor.setCard(card);
		
//		ArrayList<Resource> array1 = new ArrayList<>();
//		array1.add(new Coin(3));
//		array1.add(new Wood(5));
//		array1.add(new FaithPoint(2));
//		array1.add(new VictoryPoint(4));
//		
//		ArrayList<Resource> array2 = new ArrayList<>();
//		array2.add(new Servant(3));
//		array2.add(new Stone(5));
//		array2.add(new MilitaryPoint(2));
//		array2.add(new VictoryPoint(4));
//		
//		ResourceList resourceList1 = new ResourceList(array1), 
//				resourceList2 = new ResourceList(array2);
//		
//		ArrayList<ResourceList> list = new ArrayList<>();
//		list.add(resourceList1);
//		list.add(resourceList2);
//		
//		System.out.println(tryout.update(list));

	}


}