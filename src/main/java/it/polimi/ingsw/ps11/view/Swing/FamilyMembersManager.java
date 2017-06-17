package it.polimi.ingsw.ps11.view.Swing;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import java.awt.Insets;
import java.util.Enumeration;

public class FamilyMembersManager extends JPanel {
	
	private JTextField value;
	private String[] familyMembers;
    ButtonGroup memberSelector = new ButtonGroup();


	public FamilyMembersManager(String[] familyMembers) {
		
		this.familyMembers = familyMembers;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		for(int i=0; i<familyMembers.length; i++){
			
			JToggleButton member = new JToggleButton(familyMembers[i]);
			member.setName(familyMembers[i]);
			member.setPreferredSize(new Dimension(100, 100));
			gbc.gridx = i;
			gbc.gridy = 0;
			memberSelector.add(member);
			gbc.insets = new Insets(30, 10, 0, 0);
			add(member, gbc);
			
			value = new JTextField();
			value.setText(familyMembers[i] + "'s value");
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = i;
			gbc.gridy = 1;
			gbc.insets = new Insets(30, 10, 5, 0);
			add(value, gbc);
		}
	}
	
	public String getSelected(){
		for (Enumeration<AbstractButton> buttons = memberSelector.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getName();
            }
        }
        return "Error, no Family Member is selected";
	}
}
