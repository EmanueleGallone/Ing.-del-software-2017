package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;

public class ViewMessage implements Message {
	
	private Connection connection;
	private ViewEvent event;
	
	public ViewMessage(ViewEvent event) {
		this.event = event;
	}
	
	public ViewEvent getEvent() {
		return event;
	}

	@Override
	public void accept(MessageReceiver receiver) {
		receiver.receive(this);
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

