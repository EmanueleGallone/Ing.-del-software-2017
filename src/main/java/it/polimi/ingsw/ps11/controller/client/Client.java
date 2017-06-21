package it.polimi.ingsw.ps11.controller.client;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.message.MessageReceiver;
import it.polimi.ingsw.ps11.controller.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.message.ViewMessage;
import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.events.EventManager;
import it.polimi.ingsw.ps11.model.modelEvents.GameStartedEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelListener;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class Client implements MessageReceiver,ModelListener,Runnable {
	
	private View view;
	protected Connection connection;
	
	EventManager manager = new EventManager();
	
	public Client(View view, Connection connection) {
		this.view = view;
		this.connection = connection;
		view.attach(viewListener);
	}

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
	
	private transient EventListener<MessageEvent> serverListener = new EventListener<MessageEvent>() {

		@Override
		public void handle(MessageEvent e) {
			e.getMessage().accept(getThis());;		
		}
	};
	
	private transient EventListener<ViewEvent> viewListener = new EventListener<ViewEvent>() {

		@Override
		public void handle(ViewEvent e) {
			try {
				connection.send(new ViewMessage(e));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	public Client getThis(){
		return this;
	}
	
// Handling messages from server and events from model
	
	@Override
	public void receive(TextualMessage message) {
		view.out(message.getMessage());
		try {
			connection.send("Grazie");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void receive(ModelMessage mEvent) {
		mEvent.getEvent().accept(this);
	}

	@Override
	public void receive(ViewMessage viewMessage) {}

	@Override
	public void handle(GameStartedEvent gameStartedEvent) {
		view.update(gameStartedEvent.getBoard());
		view.update(gameStartedEvent.getPlayer());
		view.print();
	}
}
