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
	
	JDialog dialog = new JDialog();
	private ButtonGroup selectResourceList = new ButtonGroup(); 
	private EventHandler<ViewEventInterface> eventHandler;
	
	public GraphicChooseResourceListPanel(EventHandler<ViewEventInterface> viewEvent, ArrayList<ResourceList> resourceLists) {
		
		this.eventHandler = viewEvent;
		this.costs = resourceLists;
		
		GridBagLayout gblDialog = new GridBagLayout();
		gblDialog.columnWidths = new int[]{0, 0};
		gblDialog.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gblDialog.columnWeights = new double[]{1.0,  Double.MIN_VALUE};
		gblDialog.rowWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, Double.MIN_VALUE};
		dialog.getContentPane().setLayout(gblDialog);		

		int i = 0;
		for (ResourceList resourceList : resourceLists) {
			
			ShowResourceList list = new ShowResourceList(resourceList);
			GridBagConstraints gbc = new GridBagConstraints();
			list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.fill = GridBagConstraints.BOTH;
			dialog.getContentPane().add(list, gbc);
			i++;
			
		}
		
		JButton confirm = new JButton("CONFIRM");
		confirm.addActionListener(new ChoiceMade());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.SOUTH;
		dialog.getContentPane().add(confirm, gbc);
		
	}
	
	

	public class ShowResourceList extends JPanel{
		public ShowResourceList(ResourceList resourceList) {
			
			JRadioButton selector = new JRadioButton();
			GraphicResourceListView resources = new GraphicResourceListView(resourceList);
			setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
			
			resources.print();
			selectResourceList.add(selector);
			add(selector);
			add(resources);
		}
	}
	
	public class ChoiceMade implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = getChoice();
			if(i >= 0){
				eventHandler.invoke(new ResourceSelectedEvent(costs.get(i)));
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

	@Override
	public void print() {		
	}
}