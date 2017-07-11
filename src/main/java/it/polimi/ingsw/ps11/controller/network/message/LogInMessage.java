package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.modelEvents.ModelListener;
/**
 * <h3> LogInMessage </h3>
 * <p> Messaggio di log In, richiede l'inserimento di un nome utente e una password che poi invia al server..</p>
 * @see MessageListener
 * @see ModelListener
 */
public class LogInMessage implements Message{

	private Connection connection;
	private String id;
	private String pw;
	
	public LogInMessage(String id , String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	@Override
	public void setSource(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Connection getSource() {
		return connection;
	}

	@Override
	public void accept(MessageListener recognizer) {
		recognizer.receive(this);
	}

}
