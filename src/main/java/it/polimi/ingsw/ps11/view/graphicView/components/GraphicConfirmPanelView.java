package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CardManagerView;
/**
 * <h3> GraphicConfiirmPanelView</h3>
 * <p> Pannello che mostra il riepilogo di un'zione che un giocatore vuole eseguire, sono riportati il costo del dado dell'azione,
 * il bonus di risorse dell'actionspace e la carta se presenti, e richiede se necessario l'aggiunta dei servitori. Il giocatore
 * può decidere se confermare l'azione o annullarla e ricominciare l'azione</p>
 */
public class GraphicConfirmPanelView extends JDialog{
	
	protected Floor floor; 
	private JTextField addServitori;
	private EventHandler<ViewEventInterface> eventHandler;
	
	public GraphicConfirmPanelView(EventHandler<ViewEventInterface> viewEvent, Floor floor) {
		
		this.eventHandler = viewEvent;
		this.floor = floor;
		int cost = floor.getActionSpace().getActionCost();
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblConfirmpanel = new GridBagLayout();
		gblConfirmpanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblConfirmpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblConfirmpanel.columnWeights = new double[]{0.071429, 0.241429, 0.044286, 0.142857, 0.428571, 0.071429,Double.MIN_VALUE};
		gblConfirmpanel.rowWeights = new double[]{0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, Double.MIN_VALUE};
		setLayout(gblConfirmpanel);
		
		ResourceList resourceList = floor.getActionSpace().getResources();
		JLabel scrittaCosto = new JLabel("COSTO"),
			   scrittaBonus = new JLabel("BONUS"),
			   scrittaServitori = new JLabel("SERVITORI");
		GraphicDevelopmentCardView cardView = new GraphicDevelopmentCardView(/*floor.getCard().getName()*/);
		cardView.print();
		GraphicPaintedPanel costo = new GraphicPaintedPanel();
		GraphicResourceListView bonus = new GraphicResourceListView(resourceList);
		addServitori = new JTextField("0");
		JButton confirm = new JButton("Conferma"),
				cancel = new JButton("Annulla");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(scrittaCosto, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		add(scrittaBonus, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		add(scrittaServitori, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 5;
		gbc.fill = GridBagConstraints.BOTH;
		add(cardView.getComponent(), gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(costo, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		add(bonus, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		add(addServitori , gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.EAST;
		add(confirm, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		add(cancel, gbc);		
		
		//<-------------------------------FINE ALLINEAMENTO------------------------------->

		confirm.addActionListener(new Confirmed());
		
	}
	
	private class Confirmed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int servant = getConfirm();
			eventHandler.invoke(new ConfirmViewEvent(true, servant));
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
}
