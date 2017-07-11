package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView.ShowPanel;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.CouncilSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;
/**
 * <h3> GraphicCouncilPalaceView</h3>
 * <p> Classe per la visualizzazione del Palazzo del Consiglio, con l'actionspace multiplo realizzato con un pannello a 
 * scorrimento e dei pulsanti ordinati che rappresentano l'ordine corrente di gioco. I pulsanti sono anche usati per cambiare la
 * plancia personale da visualizzare</p>
 * @see ConcilPalaceView
 */
public class GraphicCouncilPalaceView extends CouncilPalaceView{
		
	private GraphicPaintedPanel councilPalacePanel = new GraphicPaintedPanel();
	private GraphicMultipleActionSpace multipleActionSpace;
	private JButton showPanelButton;
	private GraphicPaintedButton toPlayer1, toPlayer2, toPlayer3, toPlayer4;
	private ArrayList<GraphicPaintedButton> playerSelectors = new ArrayList<>();
	private EventHandler<Player> changePlayerEvent = new EventHandler<>();
	
	public GraphicCouncilPalaceView() {
		
		councilPalacePanel.loadImage("BoardImages/CouncilPalace.png");
		
		multipleActionSpace = new GraphicMultipleActionSpace();
		multipleActionSpace.getButton().addActionListener(new CouncilPalaceSelectedListener());

		
		showPanelButton = new JButton("^");
		
		toPlayer1 = new GraphicPaintedButton();
		toPlayer2 = new GraphicPaintedButton();
		toPlayer3 = new GraphicPaintedButton();
		toPlayer4 = new GraphicPaintedButton();
		
		playerSelectors.add(toPlayer1);
		playerSelectors.add(toPlayer2);
		playerSelectors.add(toPlayer3);
		playerSelectors.add(toPlayer4);
		
		Integer i=0;
		for (GraphicPaintedButton button : playerSelectors) {
			button.setName(i.toString());
			button.addActionListener(changePlayerListener);
			i++;
		}
	
		//multipleActionSpace.setContentAreaFilled(false);
		
		toPlayer1.setContentAreaFilled(false);
		toPlayer2.setContentAreaFilled(false);
		toPlayer3.setContentAreaFilled(false);
		toPlayer4.setContentAreaFilled(false);
				
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->

		GridBagLayout gblCouncilPalace = new GridBagLayout();
		gblCouncilPalace.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gblCouncilPalace.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gblCouncilPalace.columnWeights = new double[]{0.127816, 0.545747, 0.142989, 0.097471, 0.01 ,0.06, Double.MIN_VALUE};
		gblCouncilPalace.rowWeights = new double[]{0.03, 0.131694, 0.18964, 0.058824, 0.130817, 0.18964, 0.1518, 0.08964, Double.MIN_VALUE};
		councilPalacePanel.setLayout(gblCouncilPalace);
		
		GridBagConstraints gbcMultipleActionSpace = new GridBagConstraints();
		GridBagConstraints gbcSlideIn = new GridBagConstraints();
		GridBagConstraints gbcToPlayer1 = new GridBagConstraints();
		GridBagConstraints gbcToPlayer2 = new GridBagConstraints();
		GridBagConstraints gbcToPlayer3 = new GridBagConstraints();
		GridBagConstraints gbcToPlayer4 = new GridBagConstraints();
		
		gbcMultipleActionSpace.gridx = 1;
		gbcMultipleActionSpace.gridy = 1;
		gbcMultipleActionSpace.gridheight = 3;
		gbcMultipleActionSpace.fill = GridBagConstraints.BOTH;
		multipleActionSpace.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(multipleActionSpace, gbcMultipleActionSpace);
		
		gbcSlideIn.gridx = 4;
		gbcSlideIn.gridy = 7;
		gbcSlideIn.gridwidth = 2;
		gbcSlideIn.fill = GridBagConstraints.BOTH;
		showPanelButton.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(showPanelButton, gbcSlideIn);
		
		gbcToPlayer1.gridx = 3;
		gbcToPlayer1.gridy = 0;
		gbcToPlayer1.gridheight = 2;
		gbcToPlayer1.gridwidth = 2;
		gbcToPlayer1.fill = GridBagConstraints.BOTH;
		toPlayer1.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(playerSelectors.get(0), gbcToPlayer1);
		
		gbcToPlayer2.gridx = 3;
		gbcToPlayer2.gridy = 2;
		gbcToPlayer2.gridwidth = 2;
		gbcToPlayer2.fill = GridBagConstraints.BOTH;
		toPlayer2.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(toPlayer2, gbcToPlayer2);
		
		gbcToPlayer3.gridx = 3;
		gbcToPlayer3.gridy = 3;
		gbcToPlayer3.gridheight = 2;
		gbcToPlayer3.gridwidth = 2;
		gbcToPlayer3.fill = GridBagConstraints.BOTH;
		toPlayer3.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(toPlayer3, gbcToPlayer3);
		
		gbcToPlayer4.gridx = 3;
		gbcToPlayer4.gridy = 5;
		gbcToPlayer4.gridwidth = 2;
		gbcToPlayer4.fill = GridBagConstraints.BOTH;
		toPlayer4.setPreferredSize(new Dimension(10, 10));
		councilPalacePanel.add(toPlayer4, gbcToPlayer4);

//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
		councilPalacePanel.repaint();
		}
	
	@Override
	public void print(){
		multipleActionSpace.print(councilPalace.getAllSpace());
		
		int i = 0;
		for (GraphicPaintedButton button : playerSelectors) {
			if(i < currentOrder.size())
			button.loadImage("BoardImages/Player color " + currentOrder.get(i).getColor().toString() + ".png");
			button.repaint();
			i++;
		}
	}
	
	public void attachSlideListener(ShowPanel showPanel){					//Bottone che fa entrare la parte nascosta della board
		showPanelButton.addActionListener(showPanel);
	}
	
	public void attachChangePlayer(EventListener<Player> changePlayer) {
		changePlayerEvent.attach(changePlayer);
	}

	public JPanel getComponent() {
		return councilPalacePanel;
	}
	
	private  transient ActionListener changePlayerListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			try {
				int i = new Integer(button.getName());
				if(i < currentOrder.size()){
					Player player = currentOrder.get(i);
					changePlayerEvent.invoke(player);
				}
			} catch (NumberFormatException exception) {
				exception.printStackTrace();
			}
		}
	};
	
	public class ChangePlayer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<currentOrder.size(); i++){
				if(e.getSource().equals(playerSelectors.get(i)))
					changePlayerEvent.invoke(currentOrder.get(i));
			}
		}
	}

	public class CouncilPalaceSelectedListener implements ActionListener{	//Se selezionato invoca l'evento "Palazzo del consiglio selezionato"

		@Override
		public void actionPerformed(ActionEvent e) {
			eventHandler.invoke(new CouncilSelectedEvent());
		}
	}
}
