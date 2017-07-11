package it.polimi.ingsw.ps11.controller.network.message;

import java.io.Serializable;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.modelEvents.ModelListener;
/**
 * <h3> Message </h3>
 * <p> Interfaccia generica che modula un messaggio inviato tramite networking, contiene il messaggio e la connessione che l'ha inviato.</p>
 * @see MessageListener
 * @see ModelListener
 */
public interface Message extends Serializable {

	public void setSource(Connection connection);
	public Connection getSource();
	public void accept(MessageListener recognizer);
}
