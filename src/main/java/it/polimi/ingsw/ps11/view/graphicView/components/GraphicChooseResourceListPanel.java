package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseResourceView;
/**
 * <h3> GraphicChooseResourceListPanel</h3>
 * <p> Pannello che mostra una lista di resourcelist ne caso una carta permetta una scelta, e richiede al giocatore per quale 
 * tra quelle elencate si vuole optare</p>
 * @see ResourceList
 */
public class GraphicChooseResourceListPanel extends ChooseResourceView{
	
	private JDialog dialog = new JDialog();
	private ButtonGroup selectResourceList = new ButtonGroup(); 
	private EventHandler<ViewEventInterface> eventHandler;
	private JFrame mainWindow;
	
	public GraphicChooseResourceListPanel(EventHandler<ViewEventInterface> viewEvent, ArrayList<ResourceList> resourceLists, JFrame mainWindow) {
		
		this.mainWindow = mainWindow;
		this.eventHandler = viewEvent;
		this.costs = resourceLists;
		
		dialog.setAlwaysOnTop(true);
		dialog.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		GridBagLayout gblDialog = new GridBagLayout();
		gblDialog.columnWidths = new int[]{0, 0, 0};
		gblDialog.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gblDialog.columnWeights = new double[]{0.9, 0.1,  Double.MIN_VALUE};
		gblDialog.rowWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, Double.MIN_VALUE};
		dialog.getContentPane().setLayout(gblDialog);		

		int i = 0;
		for (ResourceList resourceList : resourceLists) {
			
			ShowResourceList list = new ShowResourceList(resourceList);
			GridBagConstraints gbc = new GridBagConstraints();
			list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.BOTH;
			dialog.getContentPane().add(list, gbc);
			i++;
			
		}
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new Cancel());
		GridBagConstraints gbcCancel = new GridBagConstraints();
		gbcCancel.gridx = 1;
		gbcCancel.gridy = 4;
		gbcCancel.anchor = GridBagConstraints.EAST;
		dialog.getContentPane().add(cancel, gbcCancel);
		
		//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
	

	public class ShowResourceList extends JPanel{
		public ShowResourceList(ResourceList resourceList) {
			
			JRadioButton selector = new JRadioButton();
			selector.addActionListener(new ChoiceMade());
			GraphicResourceListView resources = new GraphicResourceListView(resourceList);
			setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
			
			selectResourceList.add(selector);
			add(selector);
			add(resources);
		}
	}
	
	public class Cancel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindow.setEnabled(true);
			dialog.dispose();
		}
		
	}
	
	public class ChoiceMade implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = getChoice();
			if(i >= 0){
				eventHandler.invoke(new ResourceSelectedEvent(costs.get(i)));
				mainWindow.setEnabled(true);
				dialog.dispose();
				}
		}
	}

	public int getChoice(){
		int i = 0;
        for (Enumeration<AbstractButton> buttons = selectResourceList.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return i;
            }
            else i++;			
	}
		return -1;
	}
	
	public JDialog getComponent(){
		return dialog;
	}
	
	public void show() {
		this.mainWindow.setEnabled(false);
		dialog.setUndecorated(true);
		dialog.setVisible(true);
	}

	@Override
	public void print() {		
	}
}