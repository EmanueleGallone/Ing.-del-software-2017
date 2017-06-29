package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;

public class GraphicConfirmPanelView extends JDialog{
	
	protected Floor floor; 
	private boolean confirmed = false;
	private JTextField addServitori;
	
	public GraphicConfirmPanelView(Floor floor) {
		
		this.floor = floor;
		int cost = floor.getActionSpace().getActionCost();
		ResourceList resourceList = floor.getActionSpace().getResources();
		JLabel scrittaCosto = new JLabel("COSTO"),
				   scrittaBonus = new JLabel("BONUS"),
				   scrittaServitori = new JLabel("SERViTORI");
		GraphicDevelopmentCardView cardView = new GraphicDevelopmentCardView();
		GraphicPaintedPanel costo = new GraphicPaintedPanel();
		GraphicResourceListView bonus = new GraphicResourceListView(resourceList);
		addServitori = new JTextField("0");
		JButton confirm = new JButton("Conferma"),
				cancel = new JButton("Annulla");
		cardView.print(floor.getCard().getName());
		
		GridBagLayout gblConfirmpanel = new GridBagLayout();
		gblConfirmpanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblConfirmpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblConfirmpanel.columnWeights = new double[]{0.071429, 0.241429, 0.044286, 0.142857, 0.428571, 0.071429,Double.MIN_VALUE};
		gblConfirmpanel.rowWeights = new double[]{0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, Double.MIN_VALUE};
		setLayout(gblConfirmpanel);
		
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
		
		confirm.addActionListener(new Confirmed());
		
	}
	
	private class Confirmed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			confirmed = true;
		}
	}

	public int getConfirm() {
		while(!confirmed)
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				System.err.println("Errore nel timer");
			}		
	int servitori = Integer.parseInt(addServitori.getText());
	return servitori;
	
	}
}
