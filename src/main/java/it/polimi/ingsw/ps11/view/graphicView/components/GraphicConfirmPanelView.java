package it.polimi.ingsw.ps11.view.graphicView.components;

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
	
	public GraphicConfirmPanelView(EventHandler<ViewEventInterface> viewEvent, Floor floor) {
		
		this.eventHandler = viewEvent;
		this.floor = floor;
		
		window = new JFrame();
		window.setTitle("Game Window");											//Setup la finestra principale del gioco
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.pack();
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblConfirmpanel = new GridBagLayout();
		gblConfirmpanel.columnWidths = new int[]{0, 0, 0, 0};
		gblConfirmpanel.rowHeights = new int[]{0, 0, 0, 0};
		gblConfirmpanel.columnWeights = new double[]{0.25, 0.5, 0.25, Double.MIN_VALUE};
		gblConfirmpanel.rowWeights = new double[]{0.2, 0.6, 0.2, Double.MIN_VALUE};
		window.getContentPane().setLayout(gblConfirmpanel);
		
		JPanel interPanel = new JPanel();
		GridBagConstraints gbcInterPanel = new GridBagConstraints();
		gbcInterPanel.gridx = 1;
		gbcInterPanel.gridy = 1;
		gbcInterPanel.fill = GridBagConstraints.BOTH;
		interPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		window.getContentPane().add(interPanel, gbcInterPanel);
		
		GridBagLayout gblInternPanel = new GridBagLayout();
		gblInternPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblInternPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblInternPanel.columnWeights = new double[]{0.025, 0.20, 0.025, 0.025, 0.075, 
													0.0375, 0.0375, 0.025,Double.MIN_VALUE};
		gblInternPanel.rowWeights = new double[]{0.05, 0.1, 0.1, 0.1, 0.15, 0.05, 0.05, Double.MIN_VALUE};
		interPanel.setLayout(gblInternPanel);
		
		JLabel scrittaCosto = new JLabel("COSTO"),
			   scrittaBonus = new JLabel("BONUS"),
			   scrittaServitori = new JLabel("SERVITORI");
		GraphicDevelopmentCardView cardView = new GraphicDevelopmentCardView(/*floor.getCard().getName()*/);
		cardView.print();
		GraphicPaintedPanel costo = new GraphicPaintedPanel();
		GraphicResourceListView bonus = new GraphicResourceListView(floor.getActionSpace().getResources());
		addServitori = new JTextField("0");
		JTextArea messaggio = new JTextArea("INSERIRE QUI IL MESSAGGIO");
		JButton confirm = new JButton("Conferma"),
				cancel = new JButton("Annulla");
		
		GridBagConstraints gbcCard = new GridBagConstraints();
		GridBagConstraints gbcScrittaCosto = new GridBagConstraints();
		GridBagConstraints gbcScrittaBonus = new GridBagConstraints();
		GridBagConstraints gbcScrittaServitori = new GridBagConstraints();
		GridBagConstraints gbcCosto = new GridBagConstraints();
		GridBagConstraints gbcBonus = new GridBagConstraints();
		GridBagConstraints gbcServitori = new GridBagConstraints();
		GridBagConstraints gbcMessaggio = new GridBagConstraints();
		GridBagConstraints gbcCancel = new GridBagConstraints();
		GridBagConstraints gbcConfirm = new GridBagConstraints();

		if(!(floor == null)){
		gbcCard.gridx = 1;
		gbcCard.gridy = 1;
		gbcCard.gridheight = 5;
		gbcCard.fill = GridBagConstraints.BOTH;
		interPanel.add(cardView.getComponent(), gbcCard);
		}
		
		try {
			if(!(floor.getActionSpace() == null)){
			gbcScrittaCosto.gridx = 3;
			gbcScrittaCosto.gridy = 1;
			gbcScrittaCosto.anchor = GridBagConstraints.WEST;
			scrittaCosto.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			interPanel.add(scrittaCosto, gbcScrittaCosto);
			
			gbcCosto.gridx = 4;
			gbcCosto.gridy = 1;
			gbcCosto.fill = GridBagConstraints.BOTH;
			interPanel.add(costo, gbcCosto);
			}
		} catch (NullPointerException e) {
		}
		
		
		gbcScrittaBonus.gridx = 3;
		gbcScrittaBonus.gridy = 2;
		gbcScrittaBonus.anchor = GridBagConstraints.WEST;
		scrittaBonus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		interPanel.add(scrittaBonus, gbcScrittaBonus);
		
		gbcScrittaServitori.gridx = 3;
		gbcScrittaServitori.gridy = 3;
		gbcScrittaServitori.anchor = GridBagConstraints.WEST;
		scrittaServitori.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		interPanel.add(scrittaServitori, gbcScrittaServitori);
		
		gbcBonus.gridx = 4;
		gbcBonus.gridy = 2;
		gbcBonus.gridwidth = 3;
		gbcBonus.fill = GridBagConstraints.BOTH;
		interPanel.add(bonus, gbcBonus);
		
		gbcServitori.gridx = 4;
		gbcServitori.gridy = 3;
		gbcServitori.fill = GridBagConstraints.HORIZONTAL;
		interPanel.add(addServitori, gbcServitori);
		
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
			window.dispose();
		}
	}
	
	private class Cancel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
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
	
	public void show(){
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventHandler<ViewEventInterface> viewEvent = new EventHandler<>();
		Floor floor = new Floor();
		GraphicConfirmPanelView confirmPanelView = new GraphicConfirmPanelView(viewEvent, floor);
		confirmPanelView.show();
	}
}
