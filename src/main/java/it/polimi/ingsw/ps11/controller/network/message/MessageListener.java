package it.polimi.ingsw.ps11.controller.network.message;

/**
 * <h3> MessageListener </h3>
 * <p> Interfaccia che riceve e gestisce un messaggio ricevuto. Il messaggio può essere di tipo: textual, model, view, login.</p>
 */
public interface MessageListener {

	public void receive(TextualMessage message);
	public void receive(ModelMessage modelMessage);
	public void receive(ViewMessage viewMessage);
	public void receive(LogInMessage logInMessage);

}
