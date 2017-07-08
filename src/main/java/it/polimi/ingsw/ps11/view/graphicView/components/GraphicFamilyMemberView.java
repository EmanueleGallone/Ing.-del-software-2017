package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
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
		
	protected JPanel familyMembers = new JPanel();
	protected HashMap<String, GraphicPaintedButton> familyMemberButtons = new HashMap<>();
	private HashMap<String, JLabel> familyMemberValues = new HashMap<>();
	
	public GraphicFamilyMemberView() {
		familyMembers.setOpaque(false);

//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFamilyMembers = new GridBagLayout();
		gblFamilyMembers.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblFamilyMembers.rowHeights = new int[]{0, 0};
		gblFamilyMembers.columnWeights = new double[]{0.2, 0.6, 0.04, 0.04, 0.04, 0.04, Double.MIN_VALUE};
		gblFamilyMembers.rowWeights = new double[]{0.9, 0.1, Double.MIN_VALUE};
		familyMembers.setLayout(gblFamilyMembers);

		int i = 2;
		
		ArrayList<Class<? extends FamilyMember>> familyList = new ArrayList<>();
		
		familyList.add(BlackFamilyMember.class);
		familyList.add(WhiteFamilyMember.class);
		familyList.add(OrangeFamilyMember.class);
		familyList.add(NeutralFamilyMember.class);
		
		for (Class<? extends FamilyMember> familyMemberName : familyList) {

			GraphicPaintedButton familyMemberPanel = new GraphicPaintedButton();
			JLabel value = new JLabel("0", SwingConstants.CENTER);
			value.setBackground(Color.WHITE);
//			familyMemberPanel.loadImage("playerImages/" + color + familyMemberName.getSimpleName() + ".png");
			GridBagConstraints gbcButton = new GridBagConstraints();
			GridBagConstraints gbcValue = new GridBagConstraints();
			gbcButton.gridx = i;
			gbcButton.gridy = 0;
			gbcButton.fill = GridBagConstraints.BOTH;
			familyMemberPanel.setContentAreaFilled(false);
			familyMembers.add(familyMemberPanel, gbcButton);
			
			gbcValue.gridx = i;
			gbcValue.gridy = 1;
			gbcValue.fill = GridBagConstraints.BOTH;
			familyMemberPanel.setContentAreaFilled(false);
			familyMembers.add(value, gbcValue);
			
			familyMemberPanel.addActionListener(new ChooseFamillyMemberListener(familyMemberName));
			String memberName = familyMemberName.toString();
			familyMemberButtons.put(memberName,familyMemberPanel);
			familyMemberValues.put(memberName,
					value);
			
			i++;
			
		}

//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}
	
	public void print() {
		for(FamilyMember member : familyManager.getFamily().values()){
			String memberName = member.getClass().toString();
			if(member.isUsed()){
				familyMemberButtons.get(memberName).loadImage("PlayerImages/BLANK.png");
				familyMemberButtons.get(memberName).repaint();
				familyMemberButtons.get(memberName).setEnabled(false);
				familyMemberValues.get(memberName).setText("Used");
			} else {
			familyMemberButtons.get(memberName).loadImage("PlayerImages/" + playerColor + " " + member.getClass().getSimpleName() + ".png");
			familyMemberButtons.get(memberName).repaint();
			familyMemberButtons.get(memberName).setEnabled(true);
			familyMemberValues.get(memberName).setFont(new Font("Arial", Font.PLAIN, 13));
			familyMemberValues.get(memberName).setText("<html><font color='" + playerColor + "'>" + member.getValue() + "</font></html>");
			}
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
