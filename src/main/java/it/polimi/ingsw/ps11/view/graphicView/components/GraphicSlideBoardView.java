package it.polimi.ingsw.ps11.view.graphicView.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;

public class GraphicSlideBoardView extends BoardView {

	protected JDialog slideBoard = new JDialog();
	protected JButton slideOutButton;
	
	public GraphicSlideBoardView() {
		slideOutButton = new JButton("SlideOut");
		slideOutButton.addActionListener(new CloseThis());
		slideBoard.add(slideOutButton);	
		}
	
	@Override
	public void print() {		
	}
	
	private class CloseThis implements ActionListener {			
		@Override
		public void actionPerformed(ActionEvent e) {
						
			try{
				slideBoard.setVisible(false);
				
			} catch (Exception err){
				System.err.println("Errore nello zoom");
			}
			}
		}
	
	public JDialog getComponent(){
		slideBoard.setUndecorated(true);
		slideBoard.pack();
		slideBoard.setVisible(true);
		return slideBoard;
	}

}
