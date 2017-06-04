package it.polimi.ingsw.ps11.posNetwork.messages;

public interface GenericRecogniser {
	public void execute(ClientMessage<?> clientMessage);
	public void execute(ServerMessage<?> serverMessage);
	public void execute(TextualMessage message);
	
}
