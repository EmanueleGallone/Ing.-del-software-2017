package it.polimi.ingsw.ps11.controller.message;

import java.io.Serializable;

import it.polimi.ingsw.ps11.controller.network.Connection;

public interface Message extends Serializable {

	public void setSource(Connection connection);
	public Connection getSource();
	public void accept(MessageReceiver recognizer);
}
