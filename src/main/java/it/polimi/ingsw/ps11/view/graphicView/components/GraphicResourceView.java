package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class GraphicResourceView extends ResourceView {
	
	//Mostra le risorse di ogni giocatore
	
	protected GraphicPaintedPanel resources = new GraphicPaintedPanel();
	protected JLabel coin, wood, stone, servant, faithPoint, militaryPoint, victorypoint;

	@Override
	public void print(){
		
		resources.loadImage("playerImages/Resources.png");
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblFloor = new GridBagLayout();
		gblFloor.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblFloor.rowHeights = new int[]{0, 0, 0};
		gblFloor.columnWeights = new double[]{0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, 0.142857, Double.MIN_VALUE};
		gblFloor.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		resources.setLayout(gblFloor);
		
		coin = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		coin.setFont(new Font("Arial", Font.PLAIN, 80));
		
		wood = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		wood.setFont(new Font("Arial", Font.PLAIN, 80));
		
		stone = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		stone.setFont(new Font("Arial", Font.PLAIN, 80));
		
		servant = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		servant.setFont(new Font("Arial", Font.PLAIN, 80));
		
		faithPoint = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		faithPoint.setFont(new Font("Arial", Font.PLAIN, 80));
		
		militaryPoint = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		militaryPoint.setFont(new Font("Arial", Font.PLAIN, 80));
		
		victorypoint = new JLabel("<html><font color='black'>" + "0" + "</font></html>");
		victorypoint.setFont(new Font("Arial", Font.PLAIN, 80));

		resources.add(coin);
		resources.add(wood);
		resources.add(stone);
		resources.add(servant);
		resources.add(faithPoint);
		resources.add(militaryPoint);
		resources.add(victorypoint);		
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->

	}

	public JPanel getComponent() {
		return resources;
	}

}