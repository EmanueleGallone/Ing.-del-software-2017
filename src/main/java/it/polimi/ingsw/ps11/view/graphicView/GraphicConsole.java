package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
/**
 * <h3> GraphicConsole</h3>
 * <p> Classe per la visualizzazione della console. Simula un terminale, con possibilità di usare diversi colori per diversi
 * tipi di messaggio.</p>
 * @see Console
 */
public class GraphicConsole extends Console {
	
	private JPanel consolePanel = new JPanel();
	protected JTextPane outPut;
	private StyledDocument doc;
	private Style style;
	private JTextArea inPut;
	
	public GraphicConsole() {
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblConsolePanel = new GridBagLayout();
		gblConsolePanel.columnWidths = new int[]{0, 0};	
		gblConsolePanel.rowHeights = new int[]{0, 0, 0};
		gblConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblConsolePanel.rowWeights = new double[]{0.833333, 0.166666, Double.MIN_VALUE};
        consolePanel.setLayout(gblConsolePanel);
                
        GridBagConstraints gbcOut = new GridBagConstraints();
        GridBagConstraints gbcIn = new GridBagConstraints();
        
        gbcOut.gridx = 0;
        gbcOut.gridy = 0;
        gbcOut.fill = GridBagConstraints.BOTH;
		outPut = new JTextPane();
		doc = outPut.getStyledDocument();
		style = outPut.addStyle("Style", null);
		outPut.setEditable(false);
		outPut.setBackground(Color.WHITE);
        outPut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		consolePanel.add(outPut, gbcOut);

        gbcIn.gridx = 0;
        gbcIn.gridy = 1;
        gbcIn.fill = GridBagConstraints.BOTH;
		inPut = new JTextArea();
		inPut.setLineWrap(true);
		inPut.setWrapStyleWord(true);
		inPut.setBackground(Color.WHITE);
        inPut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		consolePanel.add(inPut, gbcIn);
		
//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
	@Override
	public void println(String message) {
	    StyleConstants.setForeground(style, Color.BLACK);
	    try {
			doc.insertString(doc.getLength(), message + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void print(String message) {
	    StyleConstants.setForeground(style, Color.BLACK);
	    try {
			doc.insertString(doc.getLength(), message, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String read() {
		String toSend = inPut.getText();
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
	    StyleConstants.setForeground(style, Color.RED);
	    try {
			doc.insertString(doc.getLength(), message, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}


	public JPanel getComponent(){
		return consolePanel;
	}
}
