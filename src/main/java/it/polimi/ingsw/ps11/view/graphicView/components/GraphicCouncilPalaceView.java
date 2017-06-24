package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;

public class GraphicCouncilPalaceView extends CouncilPalaceView{
	
	protected GraphicPaintedPanel councilPalace = new GraphicPaintedPanel();
	protected GraphicActionSpace multipleActionSpace = new GraphicActionSpace("Council");
	protected JPanel turns = new JPanel();
	
	@Override
	public void print(){
		councilPalace.loadImage("boardImages/CouncilPalace.png");
		
		GridBagLayout gblCouncilPalace = new GridBagLayout();
		gblCouncilPalace.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblCouncilPalace.rowHeights = new int[]{0, 0, 0, 0, 0};
		gblCouncilPalace.columnWeights = new double[]{0.130115, 0.548506, 0.135632, 0.10023, 0.085517, Double.MIN_VALUE};
		gblCouncilPalace.rowWeights = new double[]{0.063213, 0.375768, 0.3125555, 0.248464, Double.MIN_VALUE};
		councilPalace.setLayout(gblCouncilPalace);
		
		GridBagConstraints gbcMultipleActionSpace = new GridBagConstraints();
		GridBagConstraints gbcTurns = new GridBagConstraints();
		
		gbcMultipleActionSpace.gridx = 1;
		gbcMultipleActionSpace.gridy = 1;
		gbcMultipleActionSpace.fill = GridBagConstraints.BOTH;
		councilPalace.add(multipleActionSpace, gbcMultipleActionSpace);
		
		gbcTurns.gridx = 3;
		gbcTurns.gridy = 0;
		gbcTurns.gridheight = 3;
		gbcTurns.fill = GridBagConstraints.BOTH;
		councilPalace.add(turns, gbcTurns);
		
	}

	public JPanel getComponent() {
		return councilPalace;
	}

}
