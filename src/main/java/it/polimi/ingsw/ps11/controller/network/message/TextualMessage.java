package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
/**
 * <h3> TextualMessage </h3>
 * <p> Classe che rappresenta un messaggio contenente solo una stringa di testo.</p>
 * @see Message
 */
public class TextualMessage implements Message {

	private Connection connection;
	private String message;
	
	public TextualMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public void accept(MessageListener recognizer) {
		recognizer.receive(this);
	}
	
	@Override
	public String toString() {
		return message;
	}

	@Override
	public void setSource(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Connection getSource() {
		return connection;
	}
}
