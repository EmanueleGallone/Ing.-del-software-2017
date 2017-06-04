package it.polimi.ingsw.ps11.network.messages;

import it.polimi.ingsw.ps11.network.newClient.messages.ClientMessage;
import it.polimi.ingsw.ps11.network.newServer.messages.Default;
import it.polimi.ingsw.ps11.network.newServer.messages.ServerMessageVisitor;

public class Message {
	
	private String type;
	private String clientObject;
	private String serverObject;
	
	public Message(Class<? extends ServerMessageVisitor> type, String object) {
		this.type = type.toString();
		this.clientObject = object;
	}
	
	public Class<? extends ServerMessageVisitor> getType() {
		try {
			return (Class<? extends ServerMessageVisitor>) Class.forName(type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Default.class;
	}
	
	public String getObject() {
		return clientObject;
	}
	
	
	
	
	
}
