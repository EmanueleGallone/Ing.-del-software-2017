package it.polimi.ingsw.ps11.beta.server.socket.messages;

public class PrintMessage extends ServerMessage{

	private String message;
	
	public PrintMessage(String message) {
		this.message = message;
	}
	
	public String getContent() {
		return message;
	}

	@Override
	public void accept(ServerRecognizer serverRecognizer) {
		serverRecognizer.execute(this);
	}
}
