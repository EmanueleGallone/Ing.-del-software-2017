package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Color;

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
	
	protected JTextPane outPut;
	private StyledDocument doc;
	private Style style;
	
	public GraphicConsole() {
		 outPut = new JTextPane();
		 doc = outPut.getStyledDocument();
		 style = outPut.addStyle("Style", null);
		 outPut.setBackground(Color.BLACK);
		 outPut.setEditable(false);
		 outPut.setVisible(true);
	}
		
	@Override
	public void println(String message) {
	    StyleConstants.setForeground(style, Color.white);
	    try {
			doc.insertString(doc.getLength(), message + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}	}

	@Override
	public void print(String message) {
	    StyleConstants.setForeground(style, Color.white);
	    try {
			doc.insertString(doc.getLength(), message, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}	}

	@Override
	public void printError(String message) {
	    StyleConstants.setForeground(style, Color.red);
	    try {
			doc.insertString(doc.getLength(), message, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String read() {
		return "No Use";
	}

	@Override
	public String read(String message) {
		return null;
	}
	
	public JTextPane getComponent(){
		return outPut;
	}
}
