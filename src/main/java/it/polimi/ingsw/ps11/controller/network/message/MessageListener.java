package it.polimi.ingsw.ps11.controller.network.message;

public interface MessageListener {

	public void receive(TextualMessage message);
	public void receive(ModelMessage modelMessage);
	public void receive(ViewMessage viewMessage);
	public void receive(LogInMessage logInMessage);

}
