package it.polimi.ingsw.ps11.view.graphicView.components;

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
		gblPersonal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gblPersonal.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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

	}

	public JPanel getComponent() {
		return personal;
	}

}
