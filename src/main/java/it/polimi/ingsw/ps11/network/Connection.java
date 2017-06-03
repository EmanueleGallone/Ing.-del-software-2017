package it.polimi.ingsw.ps11.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.network.messages.Message;

public class Connection {

	private Socket socket;
	private final static int DEFAULT_PORT = 60000;
	private final static String DEFAULT_SERVER = "localhost";
	
	private int port;
	private String server;
	
	private MessageReceiver messageReceiver;
	private MessageSender messageSender;
	
	
	EventHandler<Message> inputChangeEvent = new EventHandler<>();
	
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
		socket = new Socket(server, port);
		messageReceiver = new MessageReceiver(socket);
		messageSender = new MessageSender(socket);
		
		messageReceiver.start();
		messageSender.start();
	}
	
	public Connection getConnection(){
		return this;
	}
	
	public void inputChangeEvent(EventListener<Message> listener){
		inputChangeEvent.attach(listener);
	}
	
	class MessageReceiver extends Thread{
		
		private Socket socket;
		private BufferedReader reader;
		
		public MessageReceiver(Socket socket) throws IOException {
			this.socket = socket;
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		@Override
		public void run() {
			Gson gson = new Gson();
			while (true) {
				try {
					String input = reader.readLine();
					Message message = gson.fromJson(input, Message.class);
					message.setConnection(getConnection());
					inputChangeEvent.invoke(message);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}	
	}
	
	public void send(String message){
		messageSender.send(message);
	}
	
	
	class MessageSender extends Thread{
		
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
