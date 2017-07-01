package it.polimi.ingsw.ps11.view.graphicView.components;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
//ANCORA DA FARE, JPANEL CON CAMBIAMENTO DI DIMENSIONE DINAMICO
public class GraphicMultipleActionSpaceButton extends JButton{
	
	MultipleActionSpace multiplaActionSpace;
	String name;
	
	public GraphicMultipleActionSpaceButton(String name) {
		
		this.name = name;
		
		
	
	}

	public void putFamilyMember(FamilyMember familyMember, Player owner) {
		// TODO Auto-generated method stub
		
	}

}
