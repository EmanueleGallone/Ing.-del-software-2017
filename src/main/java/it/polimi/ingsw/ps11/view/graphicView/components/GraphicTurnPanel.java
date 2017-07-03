package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicTurnPanel extends JPanel{
	
	public GraphicTurnPanel() {
		
		GridBagLayout gblTurnPanel = new GridBagLayout();
		gblTurnPanel.columnWidths = new int[]{0, 0, 0, 0};
		gblTurnPanel.rowHeights = new int[]{0, 0, 0};
		gblTurnPanel.columnWeights = new double[]{0.9, 0.05, 0.05, Double.MIN_VALUE};
		gblTurnPanel.rowWeights = new double[]{0.05, 0.95, Double.MIN_VALUE};
        setLayout(gblTurnPanel);
        
        JLabel playerTurn = new JLabel("'s Turn!");
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(playerTurn, gbc);
        
	}

}
