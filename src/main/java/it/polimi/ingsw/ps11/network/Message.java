package it.polimi.ingsw.ps11.network;

public class Message {
	String type, object;
	
	public Message(String type, String object) {
		this.type = type;
		this.object = object;
	}
}
