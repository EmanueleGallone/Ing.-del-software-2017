package it.polimi.ingsw.ps11.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.loaders.CustomFileReaderWriter;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;

public class Registration {
	//da modificare
	
	private TextualConsole console = new TextualConsole();
	private String nickname;
	private String password;
	
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private Type type = new TypeToken<Map<String,String>>(){}.getType();
	private final String path = "settings\\playersRegistrated";
	private CustomFileReaderWriter file = new CustomFileReaderWriter(path);
	
	private Map<String,String> database;
	
	@SuppressWarnings("unchecked")
	public Registration() {
		database = (Map<String,String>) gson.fromJson(file.readFile(), type);
	}
	
	public void emulateEventsfromConnection(){
		//da eliminare, usata per emulare gli eventi (InsertedRegistrationEvent(String,String))
		console.print("insert nickname : "); //nickname e password potranno essere presi dall'evento o dall'eventuale messaggio della connection
		nickname = console.read();
		console.print("insert password : ");
		password = console.read();
	}
	
	public void registration(){		
				
		if (database == null) 
			database = new HashMap<>(); //una volta creato il file si può togliere
		
	
		if (search(nickname)) {
			
//			console.print("Nickname already in database!\n");
//			console.print("Do you want to retry? (y/n)");
			
			//connection.send("nickname already in database!"); immagino una cosa così
			
		}
		else if (nickname != null && password != null){
			database.put(nickname,password);
			file.writeFile(gson.toJson(database,type));
		}
		
	}
			
			
	private boolean search(String nickname){
		if (database != null && database.containsKey(nickname)) {
			return true;
		}
		return false;
	}
		
	

}
