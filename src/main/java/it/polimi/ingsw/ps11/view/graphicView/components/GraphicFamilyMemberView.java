package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseFamilyView;
/**
 * <h3> GraphicFamilyMemberView</h3>
 * <p> Classe per la visualizzazione dei familiari di un giocatore. Ogni familiare è posto un PaintedButton e se è già stato
 * utilizzato dal giocatore viene oscurato e il pulsante reso inattivo</p>
 * @see ChooseFamilyView
 * @see GraphicPaintedButton
 */
public class GraphicFamilyMemberView extends ChooseFamilyView {
	
	//Selettore del Familiare
	
	protected JPanel familyMembers = new JPanel();
	protected HashMap<String, GraphicPaintedButton> familyMemberButtons = new HashMap<>();
	
	public GraphicFamilyMemberView() {

	}
	
	public void print() {
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFamilyMembers = new GridBagLayout();
		gblFamilyMembers.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblFamilyMembers.rowHeights = new int[]{0, 0};
		gblFamilyMembers.columnWeights = new double[]{0.72, 0.07, 0.07, 0.07, 0.07, Double.MIN_VALUE};
		gblFamilyMembers.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		familyMembers.setLayout(gblFamilyMembers);
		int i = 1;
		for (String familyMemberName : familyManager.getFamily().keySet()) {
			
			GraphicPaintedButton familyMember = new GraphicPaintedButton(familyManager.getFamily().get(familyMemberName).getClass().getSimpleName());
			familyMember.loadImage("playerImages/" + familyManager.getFamily().get(familyMemberName).getClass().getSimpleName() + ".png");
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.fill = GridBagConstraints.BOTH;
			familyMember.setContentAreaFilled(false);
			familyMembers.add(familyMember, gbc);
			i++;

			familyMember.addActionListener(new ChooseFamillyMemberListener(familyManager.getFamily().get(familyMemberName).getClass()));
			familyMemberButtons.put
			(familyMemberName, 
					familyMember);
			
		}

//<-------------------------------FINE ALLINEAMENTO------------------------------->
			
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
	
	@Override
	public void update(FamilyMemberManager familyMemberManager) {
		super.update(familyMemberManager);
		
		for(FamilyMember member : familyMemberManager.getFamily().values()){
			familyMemberButtons.get(member).loadImage("playerImages/" + member + ".png");
			familyMemberButtons.get(member).setEnabled(true);
			if(member.isUsed()){
				familyMemberButtons.get(member).setBackground(Color.BLACK);
				familyMemberButtons.get(member).setEnabled(false);
			}
		}
	}
	
}
