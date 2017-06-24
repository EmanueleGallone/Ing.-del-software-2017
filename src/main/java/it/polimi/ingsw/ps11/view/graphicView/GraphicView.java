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

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicMainBoardView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPlayerView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicSlideBoardView;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class GraphicView extends View implements ActionListener{

	JFrame window = new JFrame();							//Finestra Generale
	protected GraphicPlayerView you;						//Board Personale	
	protected GraphicMainBoardView mainBoardView;			//Parte fissa della Board
	protected GraphicSlideBoardView slideBoardView;			//Parte della Board che compare e scompare
	protected GraphicConsole console;						//Console per la gestione dei messaggi
	protected JOptionPane exit;								//Finestra che si apre quando si vuole chiudere il gioco
	protected JDialog slidePanel;							//Pannello internno alla slideBoardView
	
	public GraphicView() {
		you = new GraphicPlayerView();
		mainBoardView = new GraphicMainBoardView();
		slideBoardView = new GraphicSlideBoardView();
		console = new GraphicConsole();
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
                        
        window.setLayout(new GridBagLayout());
               
        JPanel boardPanel = mainBoardView.getComponent();
        slidePanel = slideBoardView.getComponent();
        JPanel playerlPanel = you.getComponent();
        JPanel consolePanel = console.getComponent();
		JTabbedPane allPlayers = new JTabbedPane();
		allPlayers.add("<html><body><table width='200'><tr><td>" + "YOU" + "</td></tr></table></body></html>", playerlPanel);
       
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello
        slidePanel.setBounds(0, (int)Math.round(screenSize.getHeight()*0.689815), 
        					(int)Math.round(screenSize.getWidth()*0.465), (int)Math.round(screenSize.getHeight()*0.310185));
        
		GridBagConstraints gbcMainBoard = new GridBagConstraints();
		GridBagConstraints gbcPlayers = new GridBagConstraints();
		GridBagConstraints gbcConsole = new GridBagConstraints();
        
		gbcMainBoard.gridx = 0;
		gbcMainBoard.gridy = 0;
		gbcMainBoard.gridheight = 2;
		gbcMainBoard.weightx = 0.469271;
		gbcMainBoard.fill = GridBagConstraints.BOTH;
		window.add(boardPanel, gbcMainBoard);
			
		gbcPlayers.gridx = 1;
		gbcPlayers.gridy = 1;
		gbcPlayers.gridwidth = 2;
		gbcPlayers.weightx = 0.530729166;
		gbcPlayers.weighty = 0.803703;
		gbcPlayers.fill = GridBagConstraints.BOTH;
		allPlayers.setPreferredSize(new Dimension(10, 10));
		window.add(allPlayers, gbcPlayers);
		
		gbcConsole.gridx = 1;
		gbcConsole.gridy = 0;
		gbcConsole.weightx = 0.192933;
		gbcConsole.weighty = 0.196296;
		gbcConsole.fill = GridBagConstraints.BOTH;
		window.add(consolePanel, gbcConsole);
		
		JPanel playersTurn = new JPanel();
		GridBagConstraints gbcTurn = new GridBagConstraints();
		gbcTurn.gridx = 2;
		gbcTurn.gridy = 0;
		gbcTurn.weightx = 0.313838;
		gbcTurn.weighty = 0.196296;
		gbcTurn.fill = GridBagConstraints.BOTH;
		window.add(playersTurn, gbcTurn);
		
		JButton exitButton = new JButton("X");
		playersTurn.add(exitButton);
		exitButton.addActionListener(new Close());
				        
        mainBoardView.print();
        you.print();
        slideBoardView.print();
        console.print("Benvenuto ne \"Lorenzo il Magnifico\" ");
        
        mainBoardView.attachListener(this);						//listener per il bottone che fa entrare il pannello della slideBoardView
        window.setVisible(true);

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
						
			try{
				exit = new JOptionPane();
				exit.setVisible(true);
				
				if (JOptionPane.showOptionDialog(null, "Are you sure?", "Closing Game", JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) 
					{
					window.dispose();
					slidePanel.dispose();
					}
				
			} catch (Exception err){
				System.err.println("Errore nello zoom");
			}
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		slidePanel.setVisible(true);
	}
	
	public static void main(String[] args) {
		GraphicView tryout = new GraphicView();
		tryout.print();
	}
}
