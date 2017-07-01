package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Color;
import java.awt.GridBagLayout;

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
		
		GridBagLayout gblConsolePanel = new GridBagLayout();
		gblConsolePanel.columnWidths = new int[]{0, 0};	
		gblConsolePanel.rowHeights = new int[]{0, 0, 0};
		gblConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblConsolePanel.rowWeights = new double[]{0.833333, 0.166666, Double.MIN_VALUE};
        consolePanel.setLayout(gblConsolePanel);
        
        
		 outPut = new JTextPane();
		 doc = outPut.getStyledDocument();
		 style = outPut.addStyle("Style", null);
		 outPut.setEditable(false);
		 outPut.setBackground(Color.LIGHT_GRAY);
		 inPut = new JTextArea();
		 inPut.setBackground(Color.WHITE);
		 consolePanel.add(outPut);
		 consolePanel.add(inPut);
	}
		
	@Override
	public void println(String message) {
	    StyleConstants.setForeground(style, Color.BLACK);
	    try {
			doc.insertString(doc.getLength(), message + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}	}

	@Override
	public void print(String message) {
	    StyleConstants.setForeground(style, Color.BLACK);
	    try {
			doc.insertString(doc.getLength(), message, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}	}

	@Override
	public void printError(String message) {
	    StyleConstants.setForeground(style, Color.RED);
	    try {
			doc.insertString(doc.getLength(), message, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String read() {
		inPut.setText("");
		return inPut.getText();
	}

	@Override
	public String read(String message) {
		return null;
	}
	
	public JPanel getComponent(){
		return consolePanel;
	}
}
