package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GraphicPlayerView extends PlayerView{
	
	protected JPanel personal = new JPanel();
	
	public GraphicPlayerView() {
			
		cardManagerView = new GraphicCardManagerView();
		resourceView = new GraphicResourceView();
		chooseFamilyView = new GraphicFamilyMemberView();
		
	}
	
	@Override
	public void print() {
		
		GraphicCardManagerView graphicCardManagerView = new GraphicCardManagerView();
		GraphicResourceView graphicResourceView = new GraphicResourceView();
		GraphicFamilyMemberView graphicFamilyMemberView = new GraphicFamilyMemberView();
		
		GridBagLayout gblPersonal = new GridBagLayout();
		gblPersonal.columnWidths = new int[]{0, 0, 0};
		gblPersonal.rowHeights = new int[]{0, 0, 0};
		gblPersonal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblPersonal.rowWeights = new double[]{0.20, 0.465116, 0.334884, Double.MIN_VALUE};
		personal.setLayout(gblPersonal);
		
		graphicCardManagerView.print();
		graphicResourceView.print();
		graphicFamilyMemberView.print();
		
		JPanel personalPanel = graphicCardManagerView.getComponent();
		JPanel resourcePanel = graphicResourceView.getComponent();
		JPanel familyMemberPanel = graphicFamilyMemberView.getComponent();
		
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
		
		this.cardManagerView = graphicCardManagerView;
		this.resourceView = graphicResourceView;
		this.chooseFamilyView = graphicFamilyMemberView;
		
	}

	public JPanel getComponent() {
		return personal;
	}

}
