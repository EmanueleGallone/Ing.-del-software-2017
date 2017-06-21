package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.graphicView.components.GraphicBoardView;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicPlayerView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class GraphicView extends View{

	JFrame window = new JFrame();
	protected GraphicPlayerView you;
	protected GraphicBoardView boardView;
	protected GraphicConsole console;
	private JOptionPane exit;

	
	public GraphicView() {
		you = new GraphicPlayerView();
		boardView = new GraphicBoardView();
		console = new GraphicConsole();
	}

	@Override
	public void print() {
		
		window.setTitle("Game Window");							//Setta la finestra
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setUndecorated(true);
        window.pack();
        window.setVisible(true);
        
        window.addKeyListener(listener);
        
        window.setLayout(new GridBagLayout());
               
        JPanel boardPanel = boardView.getComponent();
        JPanel playerlPanel = you.getComponent();
        JPanel consolePanel = console.getComponent();
        
		GridBagConstraints gbcBoard = new GridBagConstraints();
		GridBagConstraints gbcPlayer = new GridBagConstraints();
		GridBagConstraints gbcConsole = new GridBagConstraints();
        
		gbcBoard.gridx = 0;
		gbcBoard.gridy = 0;
		gbcBoard.gridheight = 2;
		gbcBoard.weightx = 0.384275;
		gbcBoard.fill = GridBagConstraints.BOTH;
		window.add(boardPanel, gbcBoard);
		
		gbcPlayer.gridx = 1;
		gbcPlayer.gridy = 1;
		gbcPlayer.gridwidth = 2;
		gbcPlayer.weightx = 0.615625;
		gbcPlayer.weighty = 0.703703;
		gbcPlayer.fill = GridBagConstraints.BOTH;
		window.add(playerlPanel, gbcPlayer);
		
		gbcConsole.gridx = 2;
		gbcConsole.gridy = 0;
		gbcConsole.weightx = 0.234375;
		gbcConsole.weighty = 0.296296;
		gbcConsole.fill = GridBagConstraints.BOTH;
		window.add(consolePanel, gbcConsole);
		
		JPanel playersTurn = new JPanel();
		GridBagConstraints gbcTurn = new GridBagConstraints();
		gbcTurn.gridx = 1;
		gbcTurn.gridy = 0;
		gbcTurn.weightx = 0.381250;
		gbcTurn.weighty = 0.296296;
		gbcTurn.fill = GridBagConstraints.BOTH;
		window.add(playersTurn, gbcTurn);
		        
        boardView.print();
        you.print();
        console.print("Benvenuto ne \"Lorenzo il Magnifico\" ");
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
	
	KeyAdapter listener = new KeyAdapter() {         
		@Override public void keyPressed(KeyEvent e){
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
			try{
				exit = new JOptionPane();
				
				if (JOptionPane.showOptionDialog(null, "Are you sure?", "Closing Game", JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) 
					window.dispose();
				exit.setVisible(true);
		} catch (Exception err){
			System.err.println("Errore nello zoom");
			}
			}
        }
		};
		
	public static void main(String[] args) {
		GraphicView tryout = new GraphicView();
		tryout.print();
	}
}
