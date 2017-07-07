package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
public class GraphicMultipleActionSpace  extends JPanel{
	
	MultipleActionSpace multipleActionSpace;
	JButton selector = new JButton();
	
	public GraphicMultipleActionSpace(){

		this.setOpaque(false);
		selector.setOpaque(false);
		selector.setContentAreaFilled(false);
		
		GridBagLayout gblActionSpace = new GridBagLayout();
		gblActionSpace.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblActionSpace.rowHeights = new int[]{0, 0};	
		gblActionSpace.columnWeights = new double[]{0.25, 0.25, 0.25, 0.25, Double.MIN_VALUE};
		gblActionSpace.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gblActionSpace);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.BOTH;
		add(selector, gbc);
		
	}
	
	public void print(ArrayList<ActionSpace> arrayList){
		removeAll();
		int i = 0;
		for (ActionSpace actionSpace : arrayList) {
			
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.gridx = i;
			gbc.gridx = 0;
			gbc.fill = GridBagConstraints.BOTH;
			
			GraphicPaintedPanel familyMember = new GraphicPaintedPanel();
			if(actionSpace != null && actionSpace.getOwner() != null  && actionSpace.getFamilyMember() != null){
				String familyName = actionSpace.getFamilyMember().getClass().getSimpleName();
				familyMember.loadImage("pImages/" + actionSpace.getOwner().getColor().toString() + " " + familyName + ".png");
				add(familyMember, gbc);
				i++;
			}

		}
		if(i<4){
			
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = i;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.BOTH;
		
		add(selector, gbc);
		}
	    revalidate();
	    repaint();
	}
	
	public void attachListener(ActionListener listener) {
		selector.addActionListener(listener);
	}
}
