package it.polimi.ingsw.ps11.view.Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import it.polimi.ingsw.ps11.model.player.Player;

public class GraphicView extends JFrame {
	
	private static final long serialVersionUID = -8755577984729829880L;
	protected String[]	types = { "Territories", "Buildings", "Characters", "Ventures"},
						familyMembers = {"black", "white", "orange", "neutral"},
						resources = {"Coin", "Wood", "Stone", "Servant"};
	private Color[] colors = { Color.GREEN, Color.YELLOW, Color.BLUE, Color.PINK};
	
	private static HashMap<String, PlayerBoard> playersAndBoards = new HashMap<>();	
	private static final int cardtypes = 4, floors = 4, maxCards = 6;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
    public GraphicView(ArrayList<String> players) {
    	
        setLayout(new GridBagLayout());// set LayoutManager
        Border eBorder = BorderFactory.createEtchedBorder();
                             
        MainBoard panel1 = new MainBoard(floors, cardtypes);
        panel1.setBorder(BorderFactory.createTitledBorder(eBorder, "Main Board"));
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 39;
        add(panel1, gbc); // add component to the ContentPane
        
        PlayerTurn playerTurn = new PlayerTurn();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        playerTurn.setPreferredSize(new Dimension(10, 10));
        gbc.weightx = 50;
        gbc.weighty = 1;
        add(playerTurn, gbc);

        JTabbedPane playersBoards = createTabs(maxCards, cardtypes,players, types, colors);
        playersBoards.setBorder(BorderFactory.createEmptyBorder());
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        playersBoards.setPreferredSize(new Dimension(10, 200));
        gbc.weightx = 50;
        gbc.weighty = 4;
        add(playersBoards, gbc); // add component to the ContentPane

        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // important
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true); // important
    }
    
    public JTabbedPane createTabs(int maxcards,  int cardtypes, ArrayList<String> players, String[] types, Color[] colors){
    	
    	JTabbedPane tabbedPane = new JTabbedPane();
        
        for (String playersName : players) {
        	
            PlayerBoard panel = new PlayerBoard(playersName, maxcards, types, colors, familyMembers, resources);
        	tabbedPane.add("<html><body><table width='200'><tr><td>" + playersName + "</td></tr></table></body></html>", panel);
            tabbedPane.setMnemonicAt(players.indexOf(playersName), KeyEvent.VK_1);
            playersAndBoards.put(playersName, panel);
        }

        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		return tabbedPane;
    	
    }
    
    public static PlayerBoard getPlayerPanel(String name){
    	return playersAndBoards.get(name);
    }
    
    
	public static void main(String[] args) {
		
		ArrayList<String> players = new ArrayList<String>(Arrays.asList("Luca", "Paolo", "Francesco", "Marta"));
        javax.swing.SwingUtilities.invokeLater(new Runnable() { // important

            public void run() {
            	GraphicView newGame = new GraphicView(players);
            }
        });
    }
}