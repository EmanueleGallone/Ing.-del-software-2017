package it.polimi.ingsw.ps11.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.MainTest;
import it.polimi.ingsw.ps11.model.loaders.CustomFileReaderWriter;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;

public class Registration {
	
	TextualConsole console = new TextualConsole();
	
	@SuppressWarnings("unchecked")
	public void registration(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<ArrayList<String>>(){}.getType();
		String path = "settings\\playersRegistrated";
		CustomFileReaderWriter file = new CustomFileReaderWriter(path);
		ArrayList<String> registrated = (ArrayList<String>) gson.fromJson(file.readFile(), type); 
		
		while(true){
			
			console.print("Do you want to registrate? (y/n)"); // se tolto, non gira correttamente
		
			if (console.read().equalsIgnoreCase("y")) {
				console.print("Insert your nickname: ");
				String nickname = console.read();
				
				if (registrated == null) 
					registrated = new ArrayList<>();
				

				if (registrated.contains(nickname)) {
					
					console.print("Nickname already in database!\n");
					console.print("Do you want to retry? (y/n)");
					
					if (console.read().equalsIgnoreCase("n")) {
						break;
					}
				}
				else {
					registrated.add(nickname);
					file.writeFile(gson.toJson(registrated,type));
					break;
				}
			}
			else 
				break;
			
		}
		
	}

}
