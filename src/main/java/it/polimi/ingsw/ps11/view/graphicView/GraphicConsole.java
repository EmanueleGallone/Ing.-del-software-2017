package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;

public class GraphicConsole extends Console {
	
	protected JPanel console = new JPanel();
	protected JTextArea out = new JTextArea();
	protected JTextArea in = new JTextArea();
	
	@Override
	public void println(String message) {
		out.append(message + "\n");
	}

	@Override
	public void print(String message) {
		out.append(message);
	}

	@Override
	public void printError(String message) {
		out.append("ERROR: " + message + ".\n");
	}

	@Override
	public String read() {
		return in.getText();
	}

	@Override
	public String read(String message) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JPanel getComponent(){
		console.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return console;
	}

}
