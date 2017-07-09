	package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
/**
 * <h3> GraphicConfiirmPanelView</h3>
 * <p> Pannello che mostra il riepilogo di un'zione che un giocatore vuole eseguire, sono riportati il costo del dado dell'azione,
 * il bonus di risorse dell'actionspace e la carta se presenti, e richiede se necessario l'aggiunta dei servitori. Il giocatore
 * può decidere se confermare l'azione o annullarla e ricominciare l'azione</p>
 */
public class GraphicConfirmPanelView {
	
	private JFrame window = new JFrame();
	private Floor floor; 
	private JTextField addServitori;
	private EventHandler<ViewEventInterface> eventHandler;
	private JFrame mainWindow;
	
	public GraphicConfirmPanelView(EventHandler<ViewEventInterface> viewEvent, Floor floor, JFrame mainWindow) {
		
		this.mainWindow = mainWindow;
		this.eventHandler = viewEvent;
		this.floor = floor;
		window.setAlwaysOnTop(true);
		
		window.setAlwaysOnTop(true);
		
		window = new JFrame();
		window.setTitle("Game Window");											//Setup la finestra principale del gioco
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.pack();
        window.setBackground(new Color(0, 0, 0, 0));
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblConfirmpanel = new GridBagLayout();
		gblConfirmpanel.columnWidths = new int[]{0, 0, 0, 0};
		gblConfirmpanel.rowHeights = new int[]{0, 0, 0, 0};
		gblConfirmpanel.columnWeights = new double[]{0.35, 0.3, 0.35, Double.MIN_VALUE};
		gblConfirmpanel.rowWeights = new double[]{0.25, 0.5, 0.25, Double.MIN_VALUE};
		window.getContentPane().setLayout(gblConfirmpanel);
		
		GraphicPaintedPanel interPanel = new GraphicPaintedPanel();
		interPanel.loadImage("BoardImages/Lorenzo LogIn.png");
		interPanel.setBorder(BorderFactory.createLineBorder(Color.black, 30));
		JPanel padding1 = new JPanel(),padding2 = new JPanel(),padding3 = new JPanel(),padding4 = new JPanel();
		padding1.setOpaque(false);
		padding2.setOpaque(false);
		padding3.setOpaque(false);
		padding4.setOpaque(false);

		GridBagConstraints gbcInterPanel = new GridBagConstraints();
		GridBagConstraints gbcpadding1 = new GridBagConstraints();
		GridBagConstraints gbcpadding2 = new GridBagConstraints();
		GridBagConstraints gbcpadding3 = new GridBagConstraints();
		GridBagConstraints gbcpadding4 = new GridBagConstraints();

		gbcInterPanel.gridx = 1;
		gbcInterPanel.gridy = 1;
		gbcInterPanel.fill = GridBagConstraints.BOTH;
		interPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		window.getContentPane().add(interPanel, gbcInterPanel);
		
		gbcpadding1.gridx = 0;
		gbcpadding1.gridy = 0;
		gbcpadding1.gridheight = 3;
		gbcpadding1.fill = GridBagConstraints.BOTH;
		window.getContentPane().add(padding1, gbcpadding1);
		
		gbcpadding2.gridx = 1;
		gbcpadding2.gridy = 0;
		gbcpadding2.fill = GridBagConstraints.BOTH;
		window.getContentPane().add(padding2, gbcpadding2);
		
		gbcpadding3.gridx = 2;
		gbcpadding3.gridy = 0;
		gbcpadding3.gridheight = 3;
		gbcpadding3.fill = GridBagConstraints.BOTH;
		window.getContentPane().add(padding3, gbcpadding3);
		
		gbcpadding4.gridx = 1;
		gbcpadding4.gridy = 2;
		gbcpadding4.fill = GridBagConstraints.BOTH;
		window.getContentPane().add(padding4, gbcpadding4);
		
		GridBagLayout gblInternPanel = new GridBagLayout();
		gblInternPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblInternPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblInternPanel.columnWeights = new double[]{0.023, 0.4, 0.025, 0.025, 0.075, 
													0.0375, 0.0375, 0.025,Double.MIN_VALUE};
		gblInternPanel.rowWeights = new double[]{0.05, 0.1, 0.1, 0.1, 0.15, 0.05, 0.05, Double.MIN_VALUE};
		interPanel.setLayout(gblInternPanel);
		
		JLabel scrittaCosto = new JLabel("<html><font color='white'>COSTO</font></html>"),
			   scrittaServitori = new JLabel("<html><font color='white'>SERVITORI</font></html>");
		GraphicDevelopmentCardView cardView = new GraphicDevelopmentCardView();
		GraphicPaintedPanel costo = new GraphicPaintedPanel();
		if(floor!=null){
			costo.loadImage("BoardImages/Dice cost " + floor.getActionSpace().getActionCost() + ".png");
			costo.setOpaque(false);
		}
		addServitori = new JTextField("0");
		JTextArea messaggio = new JTextArea("MESSAGGIO");			//DOVE SI TROVA IL MESSAGGIO?
		JButton confirm = new JButton("Conferma"),
				cancel = new JButton("Annulla");
		
		GridBagConstraints gbcCard = new GridBagConstraints();
		GridBagConstraints gbcScrittaCosto = new GridBagConstraints();
		GridBagConstraints gbcScrittaServitori = new GridBagConstraints();
		GridBagConstraints gbcCosto = new GridBagConstraints();
		GridBagConstraints gbcServitori = new GridBagConstraints();
		GridBagConstraints gbcMessaggio = new GridBagConstraints();
		GridBagConstraints gbcCancel = new GridBagConstraints();
		GridBagConstraints gbcConfirm = new GridBagConstraints();

		if(floor!=null){
			
		if(floor.getCard() != null){
		
		cardView.update(floor.getCard());
		cardView.print();
		gbcCard.gridx = 1;
		gbcCard.gridy = 1;
		gbcCard.gridheight = 5;
		gbcCard.fill = GridBagConstraints.BOTH;
		interPanel.add(cardView.getComponent(), gbcCard);
		
		}
		
		if(floor.getActionSpace() != null){
			
		gbcScrittaCosto.gridx = 3;
		gbcScrittaCosto.gridy = 1;
		gbcScrittaCosto.anchor = GridBagConstraints.WEST;
		scrittaCosto.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		interPanel.add(scrittaCosto, gbcScrittaCosto);
		
		gbcCosto.gridx = 4;
		gbcCosto.gridy = 1;
		gbcCosto.gridwidth = 2;
		gbcCosto.fill = GridBagConstraints.BOTH;
		interPanel.add(costo, gbcCosto);
		
		}
		
		gbcScrittaServitori.gridx = 3;
		gbcScrittaServitori.gridy = 2;
		gbcScrittaServitori.anchor = GridBagConstraints.WEST;
		scrittaServitori.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		interPanel.add(scrittaServitori, gbcScrittaServitori);

		gbcServitori.gridx = 4;
		gbcServitori.gridy = 2;
		gbcServitori.fill = GridBagConstraints.HORIZONTAL;
		interPanel.add(addServitori, gbcServitori);
		
		}
		
		gbcMessaggio.gridx = 3;
		gbcMessaggio.gridy = 4;
		gbcMessaggio.gridwidth = 4;
		gbcMessaggio.fill = GridBagConstraints.BOTH;
		messaggio.setFont(new Font("Arial", Font.PLAIN, 15));
		messaggio.setEditable(false);
		interPanel.add(messaggio , gbcMessaggio);
		
		gbcCancel.gridx = 5;
		gbcCancel.gridy = 5;
		gbcCancel.anchor = GridBagConstraints.EAST;
		interPanel.add(confirm, gbcCancel);
		
		gbcConfirm.gridx = 6;
		gbcConfirm.gridy = 5;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		interPanel.add(cancel, gbcConfirm);		
		
		//<-------------------------------FINE ALLINEAMENTO------------------------------->

		confirm.addActionListener(new Confirm());
		cancel.addActionListener(new Cancel());
		
	}
	
	private class Confirm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int servant = getConfirm();
			eventHandler.invoke(new ConfirmViewEvent(true, servant));
			mainWindow.setEnabled(true);
			window.dispose();
		}
	}
	
	private class Cancel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindow.setEnabled(true);
			window.dispose();
		}
		
	}

	public int getConfirm() {
		int servitori;
		try {
			servitori = Integer.parseInt(addServitori.getText());
		} catch (NumberFormatException e) {
			servitori = 0;
		}
		return servitori;
	}
	
	public JFrame getComponent(){
		return window;
	}
	
	public void show(){
		window.setVisible(true);
	}
}
