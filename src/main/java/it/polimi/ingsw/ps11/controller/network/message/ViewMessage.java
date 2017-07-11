package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
/**
 * <h3> Client </h3>
 * <p> Classe che rappresenta un messaggio contenente un evento lato view.</p>
 * @see Message
 */
public class ViewMessage implements Message {
	
	private Connection connection;
	private ViewEventInterface event;
	
	public ViewMessage(ViewEventInterface event) {
		this.event = event;
	}
	
	public ViewEventInterface getEvent() {
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

