package it.polimi.ingsw.ps11.view.graphicView;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PlayerTurn extends JPanel {
	
	String player = "Luca";

	public PlayerTurn() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 0, 0, 200, 60, 0};
		gridBagLayout.rowHeights = new int[]{60, 100, 10, 60, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Player's Turn");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		lblNewLabel.setFont(new Font("Showcard gothic", Font.PLAIN, 30));
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.gridwidth = 2;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 2;
		add(progressBar, gbc_progressBar);
		
		JButton startButton = new JButton("START");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		add(startButton, gbc_btnNewButton);
		
		startButton.addActionListener(new ButtonListener());		
	}
	
	public void setPlayerTurn(String player){
		this.player = player;
	}
	
	private class ButtonListener implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {
			sendChoice();
		}

		private void sendChoice() {
			System.out.println(GraphicView.getPlayerPanel(player).getSelectedFamilyMember()); //chiede di settarlo static ma non so il perchè
		}
	}

}
