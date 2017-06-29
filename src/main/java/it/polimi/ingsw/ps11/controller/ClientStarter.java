package it.polimi.ingsw.ps11.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Random;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.MainTest;
import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.TextualView;

public class ClientStarter {
	
	private TextualConsole console = new TextualConsole();
	
	@SuppressWarnings("unchecked")
	public void registration(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<ArrayList<String>>(){}.getType();
		String path = "settings\\playersRegistrated";
		ArrayList<String> registrated;
		ArrayList<String> temp =(ArrayList<String>) gson.fromJson(MainTest.readFile(path), type);
		boolean condition = true;
		
		while(condition){
			
			console.print("Do you want to registrate? (y/n)"); // se tolto, non gira correttamente
		
			if (console.read().equalsIgnoreCase("y")) {
				console.print("Insert your nickname: ");
				String nickname = console.read();

				if (temp.contains(nickname)) {
					
					console.print("Nickname already in database!\n");
					console.print("Do you want to retry? (y/n)");
					
					if (console.read().equalsIgnoreCase("y")) {
						condition = true;
					}
				}
				else {
					registrated = (ArrayList<String>) gson.fromJson(MainTest.readFile(path), type);
					registrated.add(nickname);
					MainTest.writeFile(path, gson.toJson(registrated,type));
					break;
				}
			}
			else 
				break;
			
		}
		
	}
	
	
	public static void main(String[] args) throws ExportException {
		boolean condition = true;
		TextualConsole console = new TextualConsole();
		//NB: ricorda di cambiare localhost con l'IP (da capire quale) in caso non funzionasse.
		
		//ClientStarter starter = new ClientStarter();
		//starter.registration();
		
		
		while (condition) {
			
			console.print("Do you want to play with socket or rmi? (s/r) : ");
			String network = console.read();
			console.print("\nDo you want to play with CLI or GUI? (c/g) : ");
			String view = console.read();
			
			if (network.equalsIgnoreCase("s") && view.equalsIgnoreCase("c")) {
				//lancio socket con CLI
				new Client(new TextualView(), new SocketConnection()).run();
				condition = false;
			}
			
			if (network.equalsIgnoreCase("r") && view.equalsIgnoreCase("c")) {
				//lancio RMI con CLI
				Random gen = new Random();
				new Client(new TextualView(), new RMIConnection(gen.nextInt(62000)+1024)).run();
				condition = false;
			}
			
			if (network.equalsIgnoreCase("s") && view.equalsIgnoreCase("g")) {
				//lancio socket con GUI
				new Client(new GraphicView(), new SocketConnection()).run();
				condition = false;
			}
			
			if (network.equalsIgnoreCase("r") && view.equalsIgnoreCase("g")) {
				//lancio RMI con GUI
				//non funziona la gui. bisogna mettere le due funzioni nel main di graphicView all'interno del costruttore oppure in Client
				Random gen = new Random();
				new Client(new GraphicView(), new RMIConnection(gen.nextInt(62000)+1024)).run();
				condition = false;
			}
			
			else {
				System.out.println("Command not accepted. Retry");
			}
		}
		
			
		
	}

}
