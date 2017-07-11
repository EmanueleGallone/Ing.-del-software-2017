package it.polimi.ingsw.ps11.controller.network;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.model.events.EventListener;
/**
 * <h3> ConnectionInterface </h3>
 * <p> Interfaccia generica che definisce i metodi per l'invio dei messaggi, l'avvio della connessione e metodi per aggiungere/rimuovere
 * listener </p>
 * @see Connection
 */
public interface ConnectionInterface {

	/**
	 * Da usare quando si vuole avviare la connessione. Questo metodo <i> è bloccante </i>, e ritorna un void se la connessione va a buon fine
	 * altrimenti lancia una IOException 
	 * @throws IOException 
	 */
	public void on() throws IOException;
	/**
	 * Permette l'invio di messaggio attraverso il canale di comunicazione.<br> Questo metodo ritorna subito (<b>è non bloccante</b>) o con un void o lanciato un'eccezione
	 * nel caso la connessione non sia valida.
	 * 
	 * @param message Oggetto di tipo Message che verrà inviato attraverso il canale di comunicazione
	 * @throws IOException
	 */
	public void send(Message message) throws IOException;
	
	/**
	 * Aggiunge un listener tra quelli da notificare all'arrivo di un messaggio.
	 * 
	 * @param listener è il listener che dovrà essere aggiunto tra quelli da notificare quando arriva un messaggio
	 */
	public void attachListener(EventListener<MessageEvent> listener);
	
	/**
	 * Rimuove il listener dalla lista dei listener da notificare.
	 * @param listener che dovrà essere rimosso da quelli da notificare quando arriva un messaggio
	 */
	public void detachListener(EventListener<MessageEvent> listener);
	
}
