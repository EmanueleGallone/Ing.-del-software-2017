package it.polimi.ingsw.ps11.controller.client;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.MessageListener;
import it.polimi.ingsw.ps11.controller.network.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.network.message.ViewMessage;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.modelEvents.ChooseResourceEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelListener;
import it.polimi.ingsw.ps11.model.modelEvents.PlayerUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.modelEvents.UpdateFamilyMemberEvent;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.TextualView;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**
 * <h3> Client </h3>
 * <p> Classe che gestisce la connessione lato client e recapita alla view i messaggi provenienti dal server.
 * E' un observer per gli eventi generati dalla view e quando questi si verificano li incapsula in un "Message"
 * che verrà inoltrato al server tramite la "Connection"<p>
 * @see MessageListener
 * @see ModelListener
 * @see Connection
 * @see View
 */
public class Client implements MessageListener,ModelListener,Runnable {
	
	private View view;
	protected Connection connection;
	
	public Client(View view, Connection connection) {
		this.view = view;
		this.connection = connection;
		view.attach(viewListener);
		view.attachMessageListener(viewMessageListener);
	}

	
	/**
	 * Metodo che avvia la connessione e l'interfaccia chiamando il metodo on() sulla Connection e creando un thread
	 * su cui verrà runnata la View
	 * @see Connection
	 * @see View
	 */
	@Override
	public void run() {
		try {
			connection.attachListener(serverListener);
			connection.on();
			new Thread(view).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Componente che si occupa di intercettare i messaggi dal server e attraverso il pattern Visitor fa si che il client
	 * gestisca un determinato messaggio
	 */
	private transient EventListener<MessageEvent> serverListener = new EventListener<MessageEvent>() {

		@Override
		public void handle(MessageEvent e) {
			e.getMessage().accept(getThis());		
		}
	};
	
	/**
	 * Listener che intercetta eventi da parte della View e successivamente li invia al server tramite la Connection
	 */
	private transient EventListener<ViewEventInterface> viewListener = new EventListener<ViewEventInterface>() {

		@Override
		public void handle(ViewEventInterface e) {
			try {
				connection.send(new ViewMessage(e));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	/** 
	 * Componente che si occupa di inoltrare al server gli oggetti di tipo Message generati dalla view
	 */
	private transient EventListener<Message> viewMessageListener = new EventListener<Message>() {
      // Utilizzato in fase di login, dopodichè la view genererà solo eventi e non più oggetti Message
		
		@Override
		public void handle(Message e) {
			try {
				connection.send(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	public Client getThis(){
		return this;
	}
	
// Handling messages from server and events from model
	
	/*
	 * Applicazione del pattern visitor
	 */
	
	@Override
	public void receive(TextualMessage message) {
		view.out(message.getMessage());
	}

	@Override
	public void receive(ModelMessage mEvent) {
		mEvent.getEvent().accept(this);
	}

	@Override
	public void receive(ViewMessage viewMessage) {}
	
	@Override
	public void receive(LogInMessage logInMessage) {}

	@Override
	public void handle(GameUpdateEvent gameStartedEvent) {
		view.update(gameStartedEvent.getGame());
		view.update(gameStartedEvent.getReceiver());
		view.print();
		view.out(gameStartedEvent.getMessage());
	}

	@Override
	public void handle(TextualEvent textualEvent) {
		view.out(textualEvent.getMessage());
	}
	
	@Override
	public void handle(PlayerUpdateEvent playerUpdateEvent) {
		view.update(playerUpdateEvent.getReceiver());
		view.print();
		view.out(playerUpdateEvent.getMessage());
	}

	@Override
	public void handle(ConfirmEvent confirm) {
		view.confirm(confirm);
	}

	@Override
	public void handle(ChooseResourceEvent options) {
		view.chooseResource(options.getOptions());
	}
	
	@Override
	public void handle(UpdateFamilyMemberEvent updateFamilyMemberEvent) {
		view.update(updateFamilyMemberEvent.getManager());
	}

	
	
	
// _________________________ Starter per il client ________________________________________ 
	
	public static void main(String[] args) {
		TextualConsole console = new TextualConsole();
		View view = null;
		Connection connection = null;
		
		console.println("Choose a connection mode\n• Type \"s\" to choose Socket, \"r\" to choose RMI");
		console.println("Choose a view mode\n• Type \"g\" to choose Graphic, \"t\" to choose Textual");
		
		boolean viewSel = true, connectionSel = true;
		
		while (viewSel || connectionSel) {
			switch (console.read("Insert your choiche here: ")) {
			case "s": connection = new SocketConnection(); connectionSel = false ;break;
			case "r": connection = new RMIConnection().randomGen(); connectionSel = false; break;
			case "g": view = new GraphicView(); viewSel = false ;break;
			case "t": view = new TextualView(); viewSel = false;break;
			default: console.println("Invalid input."); break;
			}
		}
		Client client = new Client(view, connection);
		client.run();
	}
	
}
