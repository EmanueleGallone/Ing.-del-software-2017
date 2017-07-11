package it.polimi.ingsw.ps11.controller.network.socket;

/**
 * <h3> DisconnectEvent </h3>
 * <p> Evento invocato alla disconnessione. Può conetenere un messaggio</p>
 */
public class DisconnectEvent {

	private String message = "";
	
	public DisconnectEvent() {
		
	}
	
	public DisconnectEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
