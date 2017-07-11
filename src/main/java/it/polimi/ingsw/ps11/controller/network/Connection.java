package it.polimi.ingsw.ps11.controller.network;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
/**
 * <h3> Connection </h3>
 * <p> Classe astratta che rappresenta la connessione tra Client e il server, contiene una stringa per il server address e un int
 * per la porta a cui connettersi. Se non specificati questi due parametri assumono i valori di default <i>localhost e 4099 </i>.<br>
 * Questa classe è indipendente dal tipo di tecnologia utilizzata per il networking (soket o rmi) e fornisce i metodi base per 
 * l'invio e la ricezione di messaggi. <p>
 * <h3> Message handling </h3>
 * L'invio di messaggi avviene in maniera <i><b>asincrona</b></i> (ovvero non bloccante) avvalendosi di un thread apposito
 * mentre la ricezione dei messaggi si manifesta tramite l'invocazione di un evento <b>MessageEvent</b> perciò per ricevere messaggi bisogna
 * attaccare alla Connection un <b>EventListener</b> di MessageEvent
 * </p>
 * @see MessageEvent
 */
public abstract class Connection implements ConnectionInterface {

	private String serverAddress = "localhost";
	private int port = 4099;
	private String id;
	
	private EventHandler<MessageEvent> messageListener = new EventHandler<>();

	public Connection() {
		
	}
	
	public Connection(String id) {
		this.id = id;
	}
	
	public Connection(int port) {
		this.port = port;
	}
	
	
	public Connection(String serverAddress, int port) {
		this.serverAddress = serverAddress;
		this.port = port;
	}
	
	
	/**
	 * Metodo che permette di inviare attraverso un canale di comunicazione <i>(socket o rmi)<i> un messaggio di tipo testuale.
	 * E' utile solo per semplificare l'invio di messaggi testuali senza passare attraverso la creazione
	 * di un relativo oggetto <b>TextualMessage</b>
	 * @param message stringa di testo che dovrà essere inviata
	 */
	public void send(String message) {
		try {
			send(new TextualMessage(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getServerAddress() {
		return serverAddress;
	}
	
	public int getPort() {
		return port;
	}
	
	public String getId() {
		return id;
	}
	/**
	 * Metodo usato per notificare eventuali listener dell'arrivo di un nuovo messaggio
	 * @param message il messaggio che dovrà essere inoltrato ad eventuali listener
	 */
	protected void invokeMessageEvent(Message message){
		messageListener.invoke(new MessageEvent(message,this));
	}
	

	@Override
	public void attachListener(EventListener<MessageEvent> listener) {
		messageListener.attach(listener);
	}
	
	@Override
	public void detachListener(EventListener<MessageEvent> listener) {
		messageListener.detach(listener);
	}
}
