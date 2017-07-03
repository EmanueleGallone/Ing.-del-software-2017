package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;
/**
 * <h3> GraphicPlayerView</h3>
 * <p> Classe per la visualizzazione del pannello del singolo giocatore. Contiene un CardManager, una ResourceView e un 
 * FamilyManager</p>
 * @see PlayerView
 * @see GraphicCardManagerView
 * @see GraphicResourceView
 * @see GraphicFamilyMemberView
 */
public class GraphicPlayerView extends PlayerView{
		
	protected JPanel personal = new JPanel();
	JLabel playersName;
	
	public GraphicPlayerView() {
		
		//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GraphicCardManagerView graphicCardManagerView = new GraphicCardManagerView();
		GraphicResourceView graphicResourceView = new GraphicResourceView();
		GraphicFamilyMemberView graphicFamilyMemberView = new GraphicFamilyMemberView();
		
		GridBagLayout gblPersonal = new GridBagLayout();
		gblPersonal.columnWidths = new int[]{0, 0, 0};
		gblPersonal.rowHeights = new int[]{0, 0, 0};
		gblPersonal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblPersonal.rowWeights = new double[]{0.15, 0.515116, 0.234884, Double.MIN_VALUE};
		personal.setLayout(gblPersonal);
				
		JPanel personalPanel = graphicCardManagerView.getComponent();
		JPanel resourcePanel = graphicResourceView.getComponent();
		JPanel familyMemberPanel = graphicFamilyMemberView.getComponent();
		playersName = new JLabel("Player's Name");
		playersName.setFont(new Font("Times New Roman", Font.PLAIN, 30));	
			
		GridBagConstraints gbcPersonal = new GridBagConstraints();
		GridBagConstraints gbcResource = new GridBagConstraints();
		GridBagConstraints gbcFamilyMember = new GridBagConstraints();
		GridBagConstraints gbcName = new GridBagConstraints();
				
		gbcFamilyMember.gridx = 0;
		gbcFamilyMember.gridx = 0;
		gbcFamilyMember.fill = GridBagConstraints.BOTH;
		familyMemberPanel.setPreferredSize(new Dimension(10, 10));
		personal.add(familyMemberPanel, gbcFamilyMember);
		
		gbcName.gridx = 0;
		gbcName.gridy = 0;
		gbcName.fill = GridBagConstraints.BOTH;
		familyMemberPanel.add(playersName, gbcName);
				
		gbcPersonal.gridx = 0;
		gbcPersonal.gridy = 1;
		gbcPersonal.gridwidth = 2;
		gbcPersonal.fill = GridBagConstraints.BOTH;
		personalPanel.setPreferredSize(new Dimension(10, 10));
		personal.add(personalPanel, gbcPersonal);
				
		gbcResource.gridx = 0;
		gbcResource.gridy = 2;
		gbcResource.fill = GridBagConstraints.BOTH;
		resourcePanel.setPreferredSize(new Dimension(10, 10));
		personal.add(resourcePanel, gbcResource);
				
		//<-------------------------------FINE ALLINEAMENTO------------------------------->

		this.cardManagerView = graphicCardManagerView;
		this.resourceView = graphicResourceView;
		this.chooseFamilyView = graphicFamilyMemberView;
		
	}
	
	@Override
	public void print() {
		playersName.setText(player.getName());
		cardManagerView.print();
		resourceView.print();
		chooseFamilyView.print();
	}
	
	@Override
	public void attach(EventListener<ViewEventInterface> listener) {			//attach il listener della finestra principale ai soli familiari
		super.attach(listener);
		chooseFamilyView.attach(listener);
	}
	
	public JPanel getComponent() {
		return personal;
	}
}
