package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

/**
 * <h3> GraphicLoginPanel</h3>
 * <p> Classe per la visualizzazione del pannello di login, in cui vanno inseriti nome utente e password, con la possibile scelta tra 
 * log in o registrazione</p>
 * @see 
 */
public class GraphicLoginPanel{
	
	private JFrame window = new JFrame();
	private JTextField username  = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton confirm = new JButton("Cancel");
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//dimensione del pannello
    
    
    private EventHandler<Message> messageEvent = new EventHandler<>();
    

	public GraphicLoginPanel() {
		
		window.setTitle("Game Window");							//Setta la finestra principale del gioco
		window.setBounds((int)Math.round(screenSize.getWidth()*0.239583), (int)Math.round(screenSize.getHeight()*0.15),
						 (int)Math.round(screenSize.getWidth()*0.520833), (int)Math.round(screenSize.getHeight()*0.678703));        
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        
        GraphicPaintedPanel image = new GraphicPaintedPanel();
        window.setContentPane(image);
        image.loadImage("BoardImages/Lorenzo LogIn.png");
        window.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		JLabel scrittaUsername = new JLabel("<html><font color='white'>Username</font></html>"),
			   scrittaPassword = new JLabel("<html><font color='white'>Password</font></html>");
		scrittaUsername.setFont(new Font("Times New Roman", Font.PLAIN, (int)Math.round(screenSize.getHeight()*0.678703)/15));
		scrittaPassword.setFont(new Font("Times New Roman", Font.PLAIN, (int)Math.round(screenSize.getHeight()*0.678703)/15));
		username.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		password.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblLoginPanel = new GridBagLayout();
		gblLoginPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblLoginPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblLoginPanel.columnWeights = new double[]{0.2, 0.3, 0.455, 0.05, 0.1, 0.2, Double.MIN_VALUE};
		gblLoginPanel.rowWeights = new double[]{0.8, 0.1, 0.1, 0.1, 0.04, 0.1, Double.MIN_VALUE};
		image.setLayout(gblLoginPanel);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		scrittaUsername.setPreferredSize(new Dimension(10, 10));
		image.add(scrittaUsername, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		scrittaPassword.setPreferredSize(new Dimension(10, 10));
		image.add(scrittaPassword, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		username.setPreferredSize(new Dimension(10, 10));
		image.add(username, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		password.setPreferredSize(new Dimension(10, 10));
		image.add(password, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		image.add(confirm, gbc);
		
		//<-------------------------------FINE ALLINEAMENTO------------------------------->

		confirm.addActionListener(new CancelListener());
		image.registerKeyboardAction(e -> {
			if(!(login() == null)){
				//System.out.println(login());
				messageEvent.invoke(new LogInMessage(username.getText(),password.getText()));
				window.dispose();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

	}
	
	
	public void attach(EventListener<Message> listener){
		this.messageEvent.attach(listener);
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
	
	public void show(){
		window.setVisible(true);
	}
	
	private class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				window.dispose();
		}
	}
}
