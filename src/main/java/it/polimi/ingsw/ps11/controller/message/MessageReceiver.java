package it.polimi.ingsw.ps11.controller.message;

public interface MessageReceiver {

	public void receive(TextualMessage message);
	public void receive(ModelMessage mEvent);
	public void receive(ViewMessage viewMessage);

}
