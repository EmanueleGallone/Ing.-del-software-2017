package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;

public class ModelMessage implements Message {
	
	private Connection connection;
	private ModelEvent event;
	
	public ModelMessage(ModelEvent event) {
		this.event = event;
	}
	
	public ModelEvent getEvent() {
		return event;
	}

	@Override
	public void accept(MessageListener receiver) {
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
