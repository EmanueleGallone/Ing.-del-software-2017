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

public class GraphicCooseResourceListPanel extends JDialog{
	// Da aggiornare, deve estendere ChooseResourceView
	
	ButtonGroup selectResourceList = new ButtonGroup(); 
	private EventHandler<ViewEventInterface> eventHandler;
	
	public GraphicCooseResourceListPanel(EventHandler<ViewEventInterface> viewEvent, ArrayList<ResourceList> resourceLists) {
		
		this.eventHandler = viewEvent;
		//this.cost = resourceLists;
		
		GridBagLayout gblDialog = new GridBagLayout();
		gblDialog.columnWidths = new int[]{0, 0};
		gblDialog.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gblDialog.columnWeights = new double[]{1.0,  Double.MIN_VALUE};
		gblDialog.rowWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, Double.MIN_VALUE};
		this.getContentPane().setLayout(gblDialog);		

		int i = 0;
		for (ResourceList resourceList : resourceLists) {
			
			ShowResourceList list = new ShowResourceList(resourceList);
			GridBagConstraints gbc = new GridBagConstraints();
			list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.fill = GridBagConstraints.BOTH;
			getContentPane().add(list, gbc);
			i++;
			
		}
		
		JButton confirm = new JButton("CONFIRM");
		confirm.addActionListener(new ChoiceMade());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.SOUTH;
		getContentPane().add(confirm, gbc);
		
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
			//eventHandler.invoke(new ResourceSelectedEvent(cost.get(i)));
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
}























