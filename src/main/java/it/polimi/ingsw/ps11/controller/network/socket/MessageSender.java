package it.polimi.ingsw.ps11.controller.network.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 * <h3> MessageSender. </h3>
 * <p> Classe che gestisce la preparazione e succesivo invio di un messaggio tramite socket.
 * Utilizza un <i>ObjectOutputStream</i> per iniare oggetti attraverso il canale di comunicazione. Di per se l'invio non avviene
 * in maniera asincrona ma questa classe estende la classe Thread in modo che sia possibile inviare un messaggio in maniera asincrona.
 * </p>
 */
public class MessageSender extends Thread{
	
	private Socket socket;
	private Object message;
	private ObjectOutputStream writer;
	
	/**
	 * 
	 * @param socket canale su cui va inviato il messaggio
	 * @param message oggetto di tipo Message che rappresenta il messaggio da inviare
	 * @throws IOException
	 */
	public MessageSender(Socket socket,Object message) throws IOException {
		this.socket = socket;
		this.message = message;
		writer = new ObjectOutputStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		this.send(message);
	}
	
	public void send(Object message){
		try {
			writer.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}