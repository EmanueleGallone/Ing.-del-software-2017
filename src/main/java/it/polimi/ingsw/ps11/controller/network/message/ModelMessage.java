package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
/**
 * <h3> Client </h3>
 * <p> Classe che un rappresenta un messaggio contenente un evento lato model .</p>
 * @see Message
 */
public class ModelMessage implements Message {
	
	private Connection connection;
	private ModelEventInterface event;
	
	public ModelMessage(ModelEventInterface event) {
		this.event = event;
	}
	
	public ModelEventInterface getEvent() {
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
