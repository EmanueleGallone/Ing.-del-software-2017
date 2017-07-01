package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * <h3> GraphicLoginPanel</h3>
 * <p> Classe per la visualizzazione del pannello di login, in cui vanno inseriti nome utente e password, con la possibile scelta tra 
 * log in o registrazione</p>
 * @see 
 */
public class GraphicLoginPanel{
	
	public JFrame window = new JFrame();
	public JTextField username  = new JTextField();
	public JPasswordField password = new JPasswordField();
	public JButton confirm = new JButton("Confirm");
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello

	public GraphicLoginPanel() {
		
		window.setTitle("Game Window");							//Setta la finestra principale del gioco
		window.setBounds((int)Math.round(screenSize.getWidth()*0.33), (int)Math.round(screenSize.getHeight()*0.33),
				(int)Math.round(screenSize.getWidth()*0.33), (int)Math.round(screenSize.getHeight()*0.30));        
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.getContentPane().setBackground(new Color(153, 204, 255));
		
		JLabel scrittaUsername = new JLabel("<html><font color='white'>Username</font></html>"),
		scrittaPassword = new JLabel("<html><font color='white'>Password</font></html>");
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblLoginPanel = new GridBagLayout();
		gblLoginPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblLoginPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblLoginPanel.columnWeights = new double[]{0.1, 0.1, 0.555, 0.05, 0.1, 0.1, Double.MIN_VALUE};
		gblLoginPanel.rowWeights = new double[]{0.2, 0.125, 0.125, 0.125, 0.06, 0.1, Double.MIN_VALUE};
		window.getContentPane().setLayout(gblLoginPanel);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(scrittaUsername, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(scrittaPassword, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(username, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(password, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(confirm, gbc);
		
		//<-------------------------------FINE ALLINEAMENTO------------------------------->

		confirm.addActionListener(new LoginListener());
		
		window.setVisible(true);

	}
		
	public HashMap<String, String> login(){
		
		if(username.getText().isEmpty() ||  password.getText().isEmpty()) 
			return null;
		else {
			
		HashMap<String, String> login = new HashMap<>();
		login.put(username.getText(), password.getText());
		return login;
		}
		
	}
	
	private class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!(login() == null)){
				System.out.println(login());
				window.dispose();
			}
		}
		
	}
}
