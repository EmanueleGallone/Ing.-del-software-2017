package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseFamilyView;

public class GraphicFamilyMemberView extends ChooseFamilyView {
	
	//Selettore del Familiare
	
	protected JPanel familyMembers = new JPanel();
	protected ArrayList<Class<? extends FamilyMember>> FamilyMemberTypes = new ArrayList<>();
	
	public GraphicFamilyMemberView() {
		
		FamilyMemberTypes.add(BlackFamilyMember.class);
		FamilyMemberTypes.add(WhiteFamilyMember.class);
		FamilyMemberTypes.add(OrangeFamilyMember.class);
		FamilyMemberTypes.add(NeutralFamilyMember.class);
		
	}
	
	public void print() {
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFamilyMembers = new GridBagLayout();
		gblFamilyMembers.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblFamilyMembers.rowHeights = new int[]{0, 0};
		gblFamilyMembers.columnWeights = new double[]{0.72, 0.07, 0.07, 0.07, 0.07, Double.MIN_VALUE};
		gblFamilyMembers.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		familyMembers.setLayout(gblFamilyMembers);
		
		for(int i = 0; i < FAMILYMEMBERNUMBER ; i++){
			
			GraphicPaintedButton familyMember = new GraphicPaintedButton();
			GridBagConstraints gbcFamilyMember = new GridBagConstraints();
			gbcFamilyMember.gridx = i+1;
			gbcFamilyMember.fill = GridBagConstraints.BOTH;
			familyMembers.add(familyMember, gbcFamilyMember);
			
			familyMember.addActionListener(new ChooseFamillyMemberListener(FamilyMemberTypes.get(i)));
			familyMember.setContentAreaFilled(false);
			familyMember.setName(FamilyMemberTypes.get(i).getSimpleName());
			familyMember.loadImage("playerImages/" + FamilyMemberTypes.get(i).getSimpleName() + ".png");

//<-------------------------------FINE ALLINEAMENTO------------------------------->
			
		}
		
	}

	public JPanel getComponent() {
		return familyMembers;
	}

	private class ChooseFamillyMemberListener implements ActionListener{			//Se un familiare è selezionato invoca l'evento "Familiare selezionato"
		
		Class<? extends FamilyMember> familyMemberType;
		
		public ChooseFamillyMemberListener(Class<? extends FamilyMember> familyMember) {
			this.familyMemberType = familyMember;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new FamilySelectedEvent(familyMemberType));
		}
	}
	
}
