package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.view.graphicView.TestIt2;
import it.polimi.ingsw.ps11.view.graphicView.components.GraphicCouncilPalaceView.CouncilPalaceSelectedListener;
//ANCORA DA FARE, JPANEL CON CAMBIAMENTO DI DIMENSIONE DINAMICO
public class GraphicMultipleActionSpaceButton  extends JPanel{
	
	private static Dimension familySize;
	MultipleActionSpace multipleActionSpace;
	JPanel holderPanel;
	JButton selector = new JButton();
	
	public GraphicMultipleActionSpaceButton(){

		
		holderPanel = new JPanel();
		holderPanel.setOpaque(false);
		holderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    holderPanel.setLayout(new FlowLayout());
	    holderPanel.add(Box.createGlue(), BorderLayout.CENTER);

	    setLayout(new BorderLayout());
	    add(new JScrollPane(holderPanel,
	              JScrollPane.VERTICAL_SCROLLBAR_NEVER,
	              JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		GraphicMultipleActionSpaceButton mainPanel = new GraphicMultipleActionSpaceButton();

	      JFrame frame = new JFrame("TestIt2");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add(mainPanel);
	      frame.pack();
	      frame.setLocationByPlatform(true);
	      frame.setVisible(true);
	}
	
	public void print(ArrayList<ActionSpace> arrayList){
		holderPanel.removeAll();
		for (ActionSpace actionSpace : arrayList) {
			GraphicPaintedPanel familyMember = new GraphicPaintedPanel();
			familyMember.setPreferredSize(familySize);
			familyMember.loadImage("playersImages/" + actionSpace.getOwner().getColor().toString() + " " + actionSpace.getFamilyMember() + ".png");
			holderPanel.add(familyMember);
		}
		selector = new JButton();
		selector.setPreferredSize(familySize);
		holderPanel.add(selector);
	    revalidate();
	    repaint();
	}

	public void addListener(CouncilPalaceSelectedListener councilPalaceSelectedListener) {
		selector.addActionListener(councilPalaceSelectedListener);
	}
	
	public JPanel getComponent(){
		return holderPanel;
	}

	public void setFamilySize(int width, int height) {
		familySize = new Dimension(width, height / 4);
	}
}
