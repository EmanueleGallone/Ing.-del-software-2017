package it.polimi.ingsw.ps11.controller.client;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.MessageListener;
import it.polimi.ingsw.ps11.controller.network.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.network.message.ViewMessage;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.events.EventManager;
import it.polimi.ingsw.ps11.model.modelEvents.ChooseResourceEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.modelEvents.GameStartedEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelListener;
import it.polimi.ingsw.ps11.model.modelEvents.PlayerUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.modelEvents.UpdateFamilyMemberEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class Client implements MessageListener,ModelListener,Runnable {
	
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
			e.getMessage().accept(getThis());		
		}
	};
	
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
	
	public Client getThis(){
		return this;
	}
	
// Handling messages from server and events from model
	
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
	public void handle(GameStartedEvent gameStartedEvent) {
		view.update(gameStartedEvent.getGame());
		view.update(gameStartedEvent.getReceiver());
		//view.print();
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
}
