package it.polimi.ingsw.ps11.controller.network.socket;

import java.io.IOException;
import java.net.Socket;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.events.EventListener;
/**
 * <h3> SocketConnection </h3>
 * <p> Estende la classe <b>Connection</b> e usa come canale di comunicazione una tecnologia basata sui <b>Socket</b>. <br>
 * Quando l'oggetto viene creato la connessione non è ancora presente. Per far partire la connessione bisogna utilizzare l'apposito
 * metodo <b> on() </b></p>
 * <h3> Components and behavior </h3>
 * <p> Per la ricezione dei messaggi si avvale della classe <b><i>MessageReceiver</i></b> che resta in ascolto di messaggi e che invoca
 * un evento appena ne arriva uno. La ricezione di messaggi avviene su un thread separato in modo che avvenga in modo asincrono.<br>
 * L'invio di messaggi avviene attraverso la classe <b><i>MessageSender</i></b></p> e anche in questo caso viene unsato un thread separato.
 * @see Connection
 * @see MessageSender
 * @see MessageReceiver
 */
public class SocketConnection extends Connection implements EventListener<Message>{

	private Socket socket;
	MessageReceiver receiver = new MessageReceiver();
	
	public SocketConnection() {
		
	}
	
	public SocketConnection(Socket socket){
		this.socket = socket;
		try {
			this.on();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SocketConnection(String serverAddress) {
		super(serverAddress);
	}
	
	public SocketConnection(int port) {
		super(port);
	}
	
	public SocketConnection(String serverAddress, int port) {
		super(serverAddress,port);
	}
	
	/**
	 * Una volta invocato fa partire il thread che si occuperà della ricezione dei messaggi.
	 * Fa automaticamente l'attach del listener all'oggetto MessageReceiver.
	 */
	@Override
	public void on() throws IOException {
		if(socket == null)
			socket = new Socket(getServerAddress(),getPort());
		receiver.setSocket(socket);
		receiver.attachMessageListener(this);
		new Thread(receiver).start();
	}
	
	@Override
	public void send(Message message) throws IOException{
		try {
			new MessageSender(socket, message).run();
		} catch (IOException e) {
			System.err.println("Soket MessageSender: The connection has been closed");
		}
		
	}

	/**
	 * Metodo invocato quando arriva un messaggio dal MessageReceiver. Questo metodo si occupa di inoltrarlo a sua volta
	 * ad eventuali listener attaccati alla Connection
	 */
	@Override
	public void handle(Message e) {
		invokeMessageEvent(e);
	}

}
