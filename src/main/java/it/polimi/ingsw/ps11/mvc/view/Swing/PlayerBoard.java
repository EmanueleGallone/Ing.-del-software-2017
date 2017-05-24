package it.polimi.ingsw.ps11.mvc.view.Swing;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;

public class PlayerBoard extends JPanel implements ActionListener {
    
	private static final long serialVersionUID = -4730228043524904345L;
	GridBagConstraints gbc = new GridBagConstraints();
	
	DecksManager decksManager;
	ResourceManager Resources;
	FamilyMembersManager Familymembers;
    
    public PlayerBoard(String playersName, int maxcards, String[] types, Color[] colors, String[] familyMembers, String[] resources){
    	
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{0, 0, 0};
    	gridBagLayout.rowHeights = new int[]{5, 1, 0};
    	gridBagLayout.columnWeights = new double[]{4.0, 1.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	
    	decksManager = new DecksManager(types, colors);
    	GridBagConstraints gbc_decks = new GridBagConstraints();
    	gbc_decks.gridwidth = 2;
    	gbc_decks.fill = GridBagConstraints.BOTH;
    	gbc_decks.gridx = 0;
    	gbc_decks.gridy = 0;
    	add(decksManager, gbc_decks);
    	
    	Resources = new ResourceManager(resources);
    	GridBagConstraints gbc_resources = new GridBagConstraints();
    	Resources.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    	gbc_resources.fill = GridBagConstraints.BOTH;
    	Resources.setPreferredSize(new Dimension(200, 50));
    	Resources.setMaximumSize(Resources.getPreferredSize()); 
    	gbc_resources.gridx = 0;
    	gbc_resources.gridy = 1;
    	add(Resources, gbc_resources);
    	
    	Familymembers = new FamilyMembersManager(familyMembers);
    	GridBagConstraints gbc_familyMembers = new GridBagConstraints();
    	Familymembers.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    	gbc_familyMembers.fill = GridBagConstraints.BOTH;
    	Familymembers.setPreferredSize(new Dimension(350, 50));
    	Familymembers.setMaximumSize(Familymembers.getPreferredSize()); 
    	gbc_familyMembers.gridx = 1;
    	gbc_familyMembers.gridy = 1;
    	add(Familymembers, gbc_familyMembers);
    	    	    	
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
	public String getSelectedFamilyMember(){
		return Familymembers.getSelected();
	}
  }

