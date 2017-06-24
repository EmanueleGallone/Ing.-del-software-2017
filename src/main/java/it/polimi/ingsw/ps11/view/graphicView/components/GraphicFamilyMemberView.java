package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import java.awt.GridBagLayout;

public class GraphicFamilyMemberView {
	
	protected JPanel familyMembers = new JPanel();
	protected String arrayFamilyMemberTypes[] = { "Black Family Member", "White Family Member", 
										 "Orange Family Member", "Neutral Family Member"};
	protected ButtonGroup buttonGroup;

	public GraphicFamilyMemberView() {
		
		GridBagLayout gblFamilyMembers = new GridBagLayout();
		gblFamilyMembers.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblFamilyMembers.rowHeights = new int[]{0, 0};
		gblFamilyMembers.columnWeights = new double[]{0.72, 0.07, 0.07, 0.07, 0.07, Double.MIN_VALUE};
		gblFamilyMembers.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		familyMembers.setLayout(gblFamilyMembers);
		
		buttonGroup = new ButtonGroup();	
	}
	
	public void print() {
		
		for(int i = 0; i < arrayFamilyMemberTypes.length ; i++){
			
			GraphicPaintedButton familyMember = new GraphicPaintedButton();
			GridBagConstraints gbcFamilyMember = new GridBagConstraints();
			familyMember.setContentAreaFilled(false);
			gbcFamilyMember.gridx = i+1;
			gbcFamilyMember.fill = GridBagConstraints.BOTH;
			familyMember.setName(arrayFamilyMemberTypes[i]);
			familyMember.loadImage("playerImages/" + arrayFamilyMemberTypes[i] + ".png");
			buttonGroup.add(familyMember);
			familyMembers.add(familyMember, gbcFamilyMember);
			
		}
		
	}

	public JPanel getComponent() {
		return familyMembers;
	}

}
