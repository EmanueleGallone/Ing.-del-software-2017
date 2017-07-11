package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
/**
 * <h3> GraphicConsole</h3>
 * <p> Classe per la visualizzazione della console. Simula un terminale con pannello a scorrimento.</p>
 * @see Console
 */
public class GraphicConsole extends Console {
		
	private JPanel consolePanel = new JPanel();
	private JTextArea outPut;
	private JTextField inPut;
	private Calendar rightNow;
	
	public GraphicConsole() {
	
		outPut = new JTextArea();
		outPut.setEditable(false);
		outPut.setBackground(Color.WHITE);
		DefaultCaret caret = (DefaultCaret)outPut.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        outPut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
		inPut = new JTextField();
		inPut.setBackground(Color.WHITE);
        inPut.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    JScrollPane scroll = new JScrollPane(outPut);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblConsolePanel = new GridBagLayout();
		gblConsolePanel.columnWidths = new int[]{0, 0};	
		gblConsolePanel.rowHeights = new int[]{0, 0, 0};
		gblConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblConsolePanel.rowWeights = new double[]{0.9, 0.1, Double.MIN_VALUE};
        consolePanel.setLayout(gblConsolePanel);
                
        GridBagConstraints gbcOut = new GridBagConstraints();
        GridBagConstraints gbcIn = new GridBagConstraints();
        
        gbcOut.gridx = 0;
        gbcOut.gridy = 0;
        gbcOut.fill = GridBagConstraints.BOTH;		
	    consolePanel.add(scroll, gbcOut);

        gbcIn.gridx = 0;
        gbcIn.gridy = 1;
        gbcIn.fill = GridBagConstraints.BOTH;
		consolePanel.add(inPut, gbcIn);
	
//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
		consolePanel.repaint();		
	}

	@Override
	public void println(String message) {
		if(message == null || message.equals(""))
			return;
		
		new TextualConsole().println(message);
		outPut.setText(outPut.getText() + rightNow() + message + "\n");
	}

	@Override
	public void print(String message) {
		if(message == null || message.equals(""))
			return;
		new TextualConsole().print(message);
		outPut.setText(outPut.getText() + rightNow() + message );
		}
	
	@Override
	public String read() {
		String toSend = inPut.getText();
		if(toSend.equals("help")){
			println("Welcome to \"Lorenzo il Magnifico\", a game by Cranio Creations.\nTo play select a family member from the"
					+ " buttons below and select an action space where you want to place it. Review your move and decide wheter"
					+ " you want to confirm and proceed, or cancel tha action and rethink your plan. If you confirm get"
					+ " sure to press the \"End Turn\" button to terminate your turn");
		}
		inPut.setText("");
		return toSend;
	}

	@Override
	public String read(String message) {
		println(message);
		String toSend = inPut.getText();
		inPut.setText("");
		return toSend;
	}

	@Override
	public void printError(String message) {
		
		outPut.setText(outPut.getText() + rightNow() + "<ERRORE> : " + message);
	}
	
	private String rightNow(){
		rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY),
			minute = rightNow.get(Calendar.MINUTE);
		return "    [" + hour + ":" + minute + "] ";
	}


	public JPanel getComponent(){
		return consolePanel;
	}

	public void attach(GraphicView graphicView) {
		consolePanel.registerKeyboardAction(e -> {
			String toSend = read();
			graphicView.send(toSend);
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

}
