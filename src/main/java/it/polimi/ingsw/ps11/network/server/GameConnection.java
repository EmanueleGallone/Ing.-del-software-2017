package it.polimi.ingsw.ps11.network.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class GameConnection extends Thread {
	
	  private String playerName = "default";
	  private BufferedReader in = null;
	  private PrintStream out = null;
	  private Socket socket = null;
	  private Match match;
	  
	  /*Funge da tramite tra client e server, quando il server fa lo start(), il thread legge l'input da socket
	   * e chiama la funzione activate
	   * 
	   */

	  public GameConnection(Socket clientSocket) {
	    this.socket = clientSocket;
	    setup();
	  }

	  public void run() {
		  String read;
		  Object object;
		  while(true){
				try {
					read = in.readLine();
					System.out.println(read);
					object = deserialize(in.readLine());
					if(object.getClass().equals(String.class)) System.out.println(read);
					else match.activate(object);
				} catch (IOException e) {
					System.err.println("Errore nella lettura");;
				}
			}
	  }

	public synchronized void setup(){
		  
			try {			
			  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));      
			  out = new PrintStream(socket.getOutputStream());    
			  playerName = in.readLine();
			  out.println("Ciao " + playerName + "! Benvenuto nel server de \"Lorenzo il Magnifico\"");
		  } catch (IOException e) {
			  System.err.println("Errore nella connessione");
		  }
	  }
	  
	  public String getPlayerName(){
		 return playerName;
	  }
	  
	  public void send(Object object){
		  if(!object.getClass().equals(String.class)) serialize(object);
		  out.println(object);
	  }
	  
	 private Object deserialize(String string) {
		return null;
	} 
	  
	private String serialize(Object object) {
		return null;
	}

	public void startMatch(Match match) {
		this.match = match;
	}
	}