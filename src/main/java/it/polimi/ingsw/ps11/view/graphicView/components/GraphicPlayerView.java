package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GraphicPlayerView extends PlayerView{
	
	protected JPanel personal = new JPanel();
	protected GraphicPersonalBoardView personalBoard;
	protected GraphicResourceView resource;
	protected GraphicFamilyMemberView familyMember;
	
	public GraphicPlayerView() {
			
		personalBoard = new GraphicPersonalBoardView();
		resource = new GraphicResourceView();
		familyMember = new GraphicFamilyMemberView();
		
		GridBagLayout gblPersonal = new GridBagLayout();
		gblPersonal.columnWidths = new int[]{0, 0, 0};
		gblPersonal.rowHeights = new int[]{0, 0, 0};
		gblPersonal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblPersonal.rowWeights = new double[]{0.20, 0.465116, 0.334884, Double.MIN_VALUE};
		personal.setLayout(gblPersonal);
	}
	
	@Override
	public void print() {
		
		personalBoard.print();
		resource.print();
		familyMember.print();
		
		JPanel personalPanel = personalBoard.getComponent();
		JPanel resourcePanel = resource.getComponent();
		JPanel familyMemberPanel = familyMember.getComponent();
		
		GridBagConstraints gbcPersonal = new GridBagConstraints();
		GridBagConstraints gbcResource = new GridBagConstraints();
		GridBagConstraints gbcFamilyMember = new GridBagConstraints();
		
		gbcFamilyMember.gridy = 0;
		gbcFamilyMember.gridy = 0;
		gbcFamilyMember.fill = GridBagConstraints.BOTH;
		personal.add(familyMemberPanel, gbcFamilyMember);
		
		gbcPersonal.gridx = 0;
		gbcPersonal.gridy = 1;
		gbcPersonal.gridwidth = 2;
		gbcPersonal.fill = GridBagConstraints.BOTH;
		personal.add(personalPanel, gbcPersonal);
		
		gbcResource.gridx = 0;
		gbcResource.gridy = 2;
		gbcResource.fill = GridBagConstraints.BOTH;
		personal.add(resourcePanel, gbcResource);
		

	}

	public JPanel getComponent() {
		return personal;
	}

}
