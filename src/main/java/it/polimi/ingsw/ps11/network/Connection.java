package it.polimi.ingsw.ps11.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.network.messages.InputChangeEvent;
import it.polimi.ingsw.ps11.network.messages.Message;

public class Connection {

	private Socket socket;
	private final static int DEFAULT_PORT = 60000;
	private final static String DEFAULT_SERVER = "localhost";
	
	private int port;
	private String server;
	
	private MessageReceiver messageReceiver;
	private MessageSender messageSender;
	
	
	EventHandler<InputChangeEvent> inputChangeEvent = new EventHandler<>();
	EventHandler<Connection> clientDisconnectEvent = new EventHandler<>();
	
	
	public Connection() {
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public Connection(String server) {
		this(server, DEFAULT_PORT);
	}
	
	public Connection(Socket socket) {
		this.socket = socket;
	}
	
	public Connection(String server, int port ) {
		this.server = server;
		this.port = port;
	}
	
	public void on() throws UnknownHostException, IOException{
		if(socket == null)
			this.socket = new Socket(server, port);
		messageReceiver = new MessageReceiver(this.socket);
		messageSender = new MessageSender(this.socket);
		
		messageReceiver.start();
		messageSender.start();
	}
	
	public Connection getConnection(){
		return this;
	}
	
	public void inputChangeEvent(EventListener<InputChangeEvent> listener){
		inputChangeEvent.attach(listener);
	}
	
	public void clientDisconnectEvent(EventListener<Connection> listener){
		clientDisconnectEvent.attach(listener);
	}
	
	public class MessageReceiver extends Thread{
		
		private Socket socket;
		private BufferedReader reader;
		
		public MessageReceiver(Socket socket) throws IOException {
			this.socket = socket;
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		@Override
		public void run() {
			Gson gson = new Gson();
			try {
				while (true) {
	
					String input = reader.readLine();
					System.out.println("message received: " + input);
					
					Message message = gson.fromJson(input, Message.class);
					
					inputChangeEvent.invoke(new InputChangeEvent(getConnection(), message));	
				}
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.err.println("Client disconnesso");
				clientDisconnectEvent.invoke(getConnection());
			}
		}	
	}
	
	public void send(String message){
		messageSender.send(message);
	}
	
	
	public class MessageSender extends Thread{
		
		private Socket socket;
		private PrintStream writer;
		
		public MessageSender(Socket socket) throws IOException {
			this.socket = socket;
			writer = new PrintStream(socket.getOutputStream());
		}
		@Override
		public void run() {
			
		}	
		
		public void send(String message){
			writer.println(message);
		}
	}
}
