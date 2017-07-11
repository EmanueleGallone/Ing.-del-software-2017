package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
public class GraphicMultipleActionSpace  extends JPanel{
	
	private MultipleActionSpace multipleActionSpace;
	private JButton selector = new JButton();
	private ArrayList<GraphicPaintedPanel> playersPanel = new ArrayList<>();
	
	public GraphicMultipleActionSpace(){

		this.setOpaque(false);
		selector.setOpaque(false);
		selector.setContentAreaFilled(false);
		
		GridBagLayout gblActionSpace = new GridBagLayout();
		gblActionSpace.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblActionSpace.rowHeights = new int[]{0, 0};	
		gblActionSpace.columnWeights = new double[]{0.1, 0.225, 0.225, 0.225, 0.225, Double.MIN_VALUE};
		gblActionSpace.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gblActionSpace);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.BOTH;
		add(selector, gbc);
		
		for(int i = 1; i < 5; i++){
			
			GridBagConstraints gbcPanel = new GridBagConstraints();
			GraphicPaintedPanel panel = new GraphicPaintedPanel();
			panel.loadImage("PlayerImages/BLANK.png");
			panel.setOpaque(false);
			gbcPanel.gridx = i;
			gbcPanel.gridy = 0;
			gbcPanel.fill = GridBagConstraints.BOTH;
			add(panel, gbcPanel);
			playersPanel.add(panel);
			
		}		
	}
	
	public void clean(GraphicPaintedPanel panel){
		panel.loadImage("PlayerImages/BLANK.png");
		panel.setOpaque(false);
	}
	
	public void print(ArrayList<ActionSpace> arrayList){
		
		ArrayList<String> players = new ArrayList<>();
		if (arrayList == null) 
			return;
		int i = 0;
		for (GraphicPaintedPanel panel : playersPanel) {

			if(i<arrayList.size() && arrayList.get(i).getFamilyMember() == null){
				clean(panel);
			} else if(i<arrayList.size()) {
				String ownerColor = arrayList.get(i).getOwner().getColor().toString();
				if(!players.contains(ownerColor)){
					players.add(ownerColor);
					String familyMember = arrayList.get(i).getFamilyMember().getId();
					panel.loadImage("PlayerImages/" + ownerColor + " " + familyMember + ".png");
				}
				}
			i++;
			}
		
	    revalidate();
	    repaint();
	}

	public JButton getButton(){
		return selector;
	}
}
