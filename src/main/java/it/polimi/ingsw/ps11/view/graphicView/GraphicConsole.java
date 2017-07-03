package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.omg.CORBA.PRIVATE_MEMBER;

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
	//private StyledDocument doc;
	//private Style style;
	private JTextField inPut;
	
	public GraphicConsole() {
		
//<-------------------------------INIZIO ALLINEAMENTO------------------------------->
		
		GridBagLayout gblConsolePanel = new GridBagLayout();
		gblConsolePanel.columnWidths = new int[]{0, 0};	
		gblConsolePanel.rowHeights = new int[]{0, 0, 0};
		gblConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gblConsolePanel.rowWeights = new double[]{0.82, 0.18, Double.MIN_VALUE};
        consolePanel.setLayout(gblConsolePanel);
                
        GridBagConstraints gbcOut = new GridBagConstraints();
        GridBagConstraints gbcIn = new GridBagConstraints();
        
        gbcOut.gridx = 0;
        gbcOut.gridy = 0;
        gbcOut.fill = GridBagConstraints.BOTH;		
		JPanel outPutPanel = new JPanel();
		outPutPanel.setLayout(new BoxLayout(outPutPanel, BoxLayout.LINE_AXIS));
		consolePanel.add(new JScrollPane(outPut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), gbcOut);
		
		outPut = new JTextPane();
//		doc = outPut.getStyledDocument();
//		style = outPut.addStyle("Style", null);
		outPut.setEditable(false);
		outPut.setBackground(Color.WHITE);
        outPut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		outPutPanel.add(outPut);

        gbcIn.gridx = 0;
        gbcIn.gridy = 1;
        gbcIn.fill = GridBagConstraints.BOTH;
		inPut = new JTextField();
		inPut.setBackground(Color.WHITE);
        inPut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		consolePanel.add(inPut, gbcIn);
	
//<-------------------------------FINE ALLINEAMENTO------------------------------->
		
	}
	
//	private class ScrollTextPane extends JPanel{
//		
//		public ScrollTextPane() {
//		      holderPanel = new JPanel();
//			  holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
//		      holderPanel.add(Box.createGlue(), BorderLayout.CENTER);
//
//		      setLayout(new BorderLayout());
//		      add(new JScrollPane(holderPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
//		      JTextArea fields = new JTextArea();
//		      holderPanel.add(fields);		}
//	}
	
	@Override
	public void println(String message) {
		outPut.setText(message);
//
//	    StyleConstants.setForeground(style, Color.BLACK);
//	    try {
//			doc.insertString(doc.getLength(), message + "\n", style);
//		} catch (BadLocationException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void print(String message) {
		outPut.setText(message);
//	    StyleConstants.setForeground(style, Color.BLACK);
//	    try {
//			doc.insertString(doc.getLength(), message, style);
//		} catch (BadLocationException e) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	public String read() {
		String toSend = inPut.getText();
		println(toSend);
		inPut.setText("");
		return toSend;
	}

	@Override
	public String read(String message) {
		println(message);
		String toSend = inPut.getText();
		println(toSend);
		inPut.setText("");
		return toSend;
	}

	@Override
	public void printError(String message) {
		outPut.setText(message);

//	    StyleConstants.setForeground(style, Color.RED);
//	    try {
//			doc.insertString(doc.getLength(), message, style);
//		} catch (BadLocationException e) {
//			e.printStackTrace();
//		}
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
