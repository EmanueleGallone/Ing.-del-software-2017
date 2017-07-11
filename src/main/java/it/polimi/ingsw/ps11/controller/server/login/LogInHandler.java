package it.polimi.ingsw.ps11.controller.server.login;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.MessageListener;
import it.polimi.ingsw.ps11.controller.network.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.network.message.ViewMessage;
import it.polimi.ingsw.ps11.controller.server.ConnectionHandler;
import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.loaders.Loader;
/**
 * <h3> LogInHandler. </h3>
 * <p> Classe che gestisce il Log In di un giocatore, se un username non è ancora stato usato procede con la registrazione,cse invece è
 * già stato usato controlla che la password corrispondi a quella salvata su file: se è corretta ricerca un'eventuale partita a cui il
 * giocatore stava partecipando e nel caso lo riconnette ad essa, se invece è errata notifica il giocatore e chiude la connessione.</p>
 * @see MessageListener
 */
public class LogInHandler implements MessageListener, EventListener<MessageEvent> {

	private ArrayList<Connection> waitingClient = new ArrayList<>();
	private ConnectionHandler connectionHandler = new ConnectionHandler();
	
	
	private Register register;
	
	public LogInHandler() {
		try {
			register = new Loader(FileRegistry.login_registry).load(Register.class);
		} catch (FileNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
	}
	
	
	public void handle(Connection connection){
		connection.attachListener(this);
	}


	@Override
	public void receive(TextualMessage message) {}
	
	@Override
	public void receive(ModelMessage modelMessage) {}
	
	@Override
	public void receive(ViewMessage viewMessage) {}

	
	@Override
	public void receive(LogInMessage logInMessage) {		
		if(logInMessage.getId() != null && logInMessage.getPw() != null){
			User user = new User(logInMessage.getId(), logInMessage.getPw());
			Connection connection = logInMessage.getSource();
			connection.setId(logInMessage.getId());
			
			if(register.search(user)){
				waitingClient.remove(connection);
				connection.detachListener(this);
				connectionHandler.handle(connection);
				return;
			}else {
				connection.send("\nInvalid datas for the Log in. Signing up...\n");
			}
			if(register.addNew(user)){
				waitingClient.remove(connection);
				connection.detachListener(this);
				connectionHandler.addToLobby(connection);
				connection.send("Succesful sign In, your username is: " + user.getId());
				return;
			}
			else {
				connection.send("Sign in error: username already used.");
			}
			

		}
	}
	
	@Override
	public void handle(MessageEvent e) {
		e.getMessage().setSource(e.getSource());
		e.getMessage().accept(this);
	}	
}
