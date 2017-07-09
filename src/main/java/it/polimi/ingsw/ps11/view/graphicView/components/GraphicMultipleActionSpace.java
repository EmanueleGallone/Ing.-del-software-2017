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
	
	MultipleActionSpace multipleActionSpace;
	JButton selector = new JButton();
	ArrayList<GraphicPaintedPanel> players = new ArrayList<>();
	
	public GraphicMultipleActionSpace(){

		this.setOpaque(false);
		selector.setOpaque(false);
		selector.setContentAreaFilled(false);
		
		GridBagLayout gblActionSpace = new GridBagLayout();
		gblActionSpace.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblActionSpace.rowHeights = new int[]{0, 0};	
		gblActionSpace.columnWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, Double.MIN_VALUE};
		gblActionSpace.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gblActionSpace);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.BOTH;
		add(selector, gbc);
		
		setupMultipleActionSpace();
		
	}
	
	private void setupMultipleActionSpace(){
		
		for(int i = 1; i < 5; i++){
			
			GridBagConstraints gbc = new GridBagConstraints();
			GraphicPaintedPanel panel = new GraphicPaintedPanel();
			panel.loadImage("PlayerImages/BLANK.png");
			panel.setOpaque(false);
			gbc.gridx = i;
			gbc.gridy = 0;
			add(panel, gbc);
			players.add(panel);
			
		}
		
	}
	
	public void clean(GraphicPaintedPanel panel){
		panel.loadImage("PlayerImages/BLANK.png");
		panel.setOpaque(true);
	}
	
	public void print(ArrayList<ActionSpace> arrayList){
		if (arrayList != null) return;
		int i = 0;
		for (GraphicPaintedPanel panel : players) {
			if(arrayList.get(i) == null){
				clean(players.get(i));
			} else {
				if (arrayList.get(i).getFamilyMember() != null)
					clean(players.get(i));
				else {
					String ownerColor = arrayList.get(i).getOwner().getColor().toString();
					String familyMember = arrayList.get(i).getFamilyMember().getId();
					players.get(i).loadImage("PlayerImages/" + ownerColor + " " + familyMember + ".png");
				}
			}

		}
		
	    revalidate();
	    repaint();
	}
	
	public void attachListener(ActionListener listener) {
		selector.addActionListener(listener);
	}
}
