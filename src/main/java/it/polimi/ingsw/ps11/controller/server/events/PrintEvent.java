package it.polimi.ingsw.ps11.controller.server.events;

public class PrintEvent {

	private String message;
	
	public PrintEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}