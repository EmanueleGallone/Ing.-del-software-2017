package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicBoardView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPlayerView;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class GraphicView extends View{

	JFrame window = new JFrame();							//Finestra Generale				
	protected JOptionPane exit;								//Finestra che si apre quando si vuole chiudere il gioco
	protected JDialog slidePanel;							//Pannello interno alla slideBoardView
	
	public GraphicView() {
		you = new GraphicPlayerView();						//Board personale	
		boardView = new GraphicBoardView();					//Board generale
		console = new GraphicConsole();						//Console per la gestione dei messaggi
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
		gblView.columnWidths = new int[]{0, 0, 0, 0};
		gblView.rowHeights = new int[]{0, 0, 0};
		gblView.columnWeights = new double[]{0.469271, 0.192933, 0.313838, Double.MIN_VALUE};
		gblView.rowWeights = new double[]{0.196296, 0.803703, Double.MIN_VALUE};
        window.setLayout(gblView);
        
        GraphicBoardView graphicBoardView = new GraphicBoardView();
        GraphicPlayerView graphicPlayerView = new GraphicPlayerView();
        GraphicConsole graphicConsole = new GraphicConsole();
		JButton exitButton = new JButton("X");
		JButton showPanelButton = new JButton("^");
               
        JPanel boardPanel = graphicBoardView.getMainBoard().getComponent();
        slidePanel = graphicBoardView.getSlideBoard().getComponent();
        JPanel playerlPanel = graphicPlayerView.getComponent();
        JTextPane consolePanel = graphicConsole.getComponent();
		JTabbedPane allPlayers = new JTabbedPane();
		allPlayers.add("<html><body><table width='200'><tr><td>" + "YOU" + "</td></tr></table></body></html>", playerlPanel);
       
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello
        slidePanel.setBounds(0, (int)Math.round(screenSize.getHeight()*0.695), 
        					(int)Math.round(screenSize.getWidth()*0.467), (int)Math.round(screenSize.getHeight()*0.305));
        
		GridBagConstraints gbcMainBoard = new GridBagConstraints();
		GridBagConstraints gbcPlayers = new GridBagConstraints();
		GridBagConstraints gbcConsole = new GridBagConstraints();
        
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
		allPlayers.setPreferredSize(new Dimension(10, 10));
		window.add(allPlayers, gbcPlayers);
		
		gbcConsole.gridx = 1;
		gbcConsole.gridy = 0;
		gbcConsole.fill = GridBagConstraints.BOTH;
		consolePanel.setPreferredSize(new Dimension(10, 10));
		window.add(consolePanel, gbcConsole);
		
		JPanel playersTurn = new JPanel();
		GridBagConstraints gbcTurn = new GridBagConstraints();
		gbcTurn.gridx = 2;
		gbcTurn.gridy = 0;
		gbcTurn.fill = GridBagConstraints.BOTH;
		window.add(playersTurn, gbcTurn);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
				    
		graphicBoardView.print();
		graphicPlayerView.print();
		graphicConsole.println("Benvenuto ne: ");
		graphicConsole.printError("\"Lorenzo il Magnifico\"");
		
		playersTurn.add(exitButton);
		exitButton.addActionListener(new Close());
		
		this.boardView = graphicBoardView;
		this.you = graphicPlayerView;
		this.console = graphicConsole;
        
        graphicBoardView.attachSlideListener(new ShowPanel());						//listener per il bottone che fa entrare il pannello della slideBoardView
        
        graphicBoardView.attach(new BoardListener());
        graphicPlayerView.attach(new PlayerListener());
        
        window.setVisible(true);

	}
	
	public class BoardListener implements EventListener<ViewEventInterface>{

		@Override
		public void handle(ViewEventInterface e) {
			System.out.println("BoardSelected");
		}
		
	}
	
	public class PlayerListener implements EventListener<ViewEventInterface>{

		@Override
		public void handle(ViewEventInterface e) {
			System.out.println("PlayerSelected");
		}
		
	}

	@Override
	public void run() {
		String input;
		while (!(input = console.read()).equals("q")){
			selectComponent(input);
		}
	}
	
	public void selectComponent(String input){
		
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
					slidePanel.dispose();
					}
		}
	}
	
	public class ShowPanel implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {			
			slidePanel.setVisible(true);
			}
		}

	public static void main(String[] args) {
		GraphicView tryout = new GraphicView();
		tryout.print();
	}
}
