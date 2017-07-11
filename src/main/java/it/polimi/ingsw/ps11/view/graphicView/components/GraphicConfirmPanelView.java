package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
/**
 * <h3> GraphicConfiirmPanelView</h3>
 * <p> Pannello che mostra il riepilogo di un'zione che un giocatore vuole eseguire, sono riportati il costo del dado dell'azione,
 * il bonus di risorse dell'actionspace e la carta se presenti, e richiede se necessario l'aggiunta dei servitori. Il giocatore
 * può decidere se confermare l'azione o annullarla e ricominciare l'azione</p>
 */
public class GraphicConfirmPanelView {
	
	private JDialog dialog = new JDialog();
	private JTextField addServitori;
	private EventHandler<ViewEventInterface> eventHandler;
	private JFrame mainWindow;
	
	public GraphicConfirmPanelView(EventHandler<ViewEventInterface> viewEvent,ConfirmEvent confirmEvent, JFrame mainWindow, int spaceLeft, int spaceTop, int panelWidth, int panelHeight) {
		
		this.mainWindow = mainWindow;
		this.eventHandler = viewEvent; 	

		dialog.setBounds(spaceLeft, spaceTop, panelWidth, panelHeight);
		
		GraphicPaintedPanel internalPannel = new GraphicPaintedPanel();
		internalPannel.loadImage("BoardImages/Lorenzo LogIn.png");
		dialog.setContentPane(internalPannel);

		dialog.setAlwaysOnTop(true);
		dialog.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		GridBagLayout gblDialog = new GridBagLayout();
		gblDialog.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblDialog.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblDialog.columnWeights = new double[]{0.06, 0.9, 0.02, 0.01, 0.1, 
													0.06, 0.06, 0.06,Double.MIN_VALUE};
		gblDialog.rowWeights = new double[]{0.05, 0.1, 0.1, 0.15, 0.075, 0.075, 0.05, Double.MIN_VALUE};
		dialog.getContentPane().setLayout(gblDialog);
		
		JLabel scrittaServitori = new JLabel("<html><font color='white'>SERVANTS</font></html>");

		addServitori = new JTextField("0");
		JTextArea messaggio = new JTextArea(confirmEvent.getMessage());
		JButton confirm = new JButton("Confirm"),
				cancel = new JButton("Cancel");
		confirm.setName("Confirm"); cancel.setName("Cancel");
		
		GridBagConstraints gbcScrittaServitori = new GridBagConstraints();
		GridBagConstraints gbcServitori = new GridBagConstraints();
		GridBagConstraints gbcMessaggio = new GridBagConstraints();
		GridBagConstraints gbcCancel = new GridBagConstraints();
		GridBagConstraints gbcConfirm = new GridBagConstraints();

		if(confirmEvent.getFloor()!=null){
			
			if(confirmEvent.getFloor().getCard() != null){
				
				GraphicDevelopmentCardView cardView = new GraphicDevelopmentCardView();	
				GridBagConstraints gbcCard = new GridBagConstraints();
				
				cardView.update(confirmEvent.getFloor().getCard());
				cardView.print();
				gbcCard.gridx = 1;
				gbcCard.gridy = 1;
				gbcCard.gridheight = 5;
				gbcCard.fill = GridBagConstraints.BOTH;
				dialog.getContentPane().add(cardView.getComponent(), gbcCard);
			
			}
			
			if(confirmEvent.getFloor().getActionSpace() != null){
				
				JLabel scrittaCosto = new JLabel("<html><font color='white'>COST</font></html>");
				GridBagConstraints gbcScrittaCosto = new GridBagConstraints();
				
				GraphicPaintedPanel costo = new GraphicPaintedPanel();
				costo.loadImage("BoardImages/Dice cost " + confirmEvent.getFloor().getActionSpace().getActionCost() + ".png");
				costo.setOpaque(false);
				
				GridBagConstraints gbcCosto = new GridBagConstraints();
				
				gbcScrittaCosto.gridx = 3;
				gbcScrittaCosto.gridy = 1;
				gbcScrittaCosto.anchor = GridBagConstraints.WEST;
				scrittaCosto.setFont(new Font("Times New Roman", Font.PLAIN, panelHeight/20));
				dialog.getContentPane().add(scrittaCosto, gbcScrittaCosto);
				
				gbcCosto.gridx = 4;
				gbcCosto.gridy = 1;
				gbcCosto.gridwidth = 2;
				gbcCosto.fill = GridBagConstraints.BOTH;
				dialog.getContentPane().add(costo, gbcCosto);
			
			}
			
			gbcScrittaServitori.gridx = 3;
			gbcScrittaServitori.gridy = 2;
			gbcScrittaServitori.anchor = GridBagConstraints.WEST;
			scrittaServitori.setFont(new Font("Times New Roman", Font.PLAIN, panelHeight/20));
			dialog.getContentPane().add(scrittaServitori, gbcScrittaServitori);
	
			gbcServitori.gridx = 4;
			gbcServitori.gridy = 2;
			gbcServitori.fill = GridBagConstraints.HORIZONTAL;
			dialog.getContentPane().add(addServitori, gbcServitori);

		}
		
		
		gbcMessaggio.gridx = 3;
		gbcMessaggio.gridy = 4;
		gbcMessaggio.gridwidth = 4;
		
		gbcMessaggio.fill = GridBagConstraints.BOTH;
		messaggio.setFont(new Font("Arial", Font.PLAIN, 15));
		messaggio.setEditable(false);
		dialog.getContentPane().add(messaggio , gbcMessaggio);
		
		gbcCancel.gridx = 5;
		gbcCancel.gridy = 5;
		gbcCancel.anchor = GridBagConstraints.EAST;
		dialog.getContentPane().add(confirm, gbcCancel);
		
		gbcConfirm.gridx = 6;
		gbcConfirm.gridy = 5;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		dialog.getContentPane().add(cancel, gbcConfirm);		
		
		//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
		Confirm buttonsListener = new Confirm();
		confirm.addActionListener(buttonsListener);
		cancel.addActionListener(buttonsListener);
		
	}
	
	private class Confirm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if(button.getName().equals("Confirm")){
				int servant = getServant();
				eventHandler.invoke(new ConfirmViewEvent(true, servant));
			}
			else
				eventHandler.invoke(new ConfirmViewEvent(false));
			dialog.dispose();
			mainWindow.setEnabled(true);
		}
	}

	public int getServant() {
		int servitori;
		try {
			servitori = Integer.parseInt(addServitori.getText());
		} catch (NumberFormatException e) {
			servitori = 0;
		}
		return servitori;
	}
	
	public JDialog getComponent(){
		return dialog;
	}
	
	public void show(){
		this.mainWindow.setEnabled(false);
		if(!dialog.isVisible())
			dialog.setUndecorated(true);
		dialog.setVisible(true);
	}
}
