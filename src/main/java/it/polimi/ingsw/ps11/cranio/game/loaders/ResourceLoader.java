package it.polimi.ingsw.ps11.cranio.game.loaders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ResourceLoader extends Loader {
	
	private static final String DEFAULT_PATH = "resource.txt";
	
	private ResourceList resourceList;
	
	private Gson gson = new Gson();
	
	private FileReader reader;
	
	
	public ResourceLoader() {
		super(DEFAULT_PATH);
	}
	
	public ResourceLoader(String filePath) {
		super(filePath);
	}
	
	public ResourceList load(){
		
		try {
			reader = new FileReader(DEFAULT_PATH);
			
			resourceList = gson.fromJson(reader, ResourceList.class);			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return resourceList;
		
				
		
	}
	
	
}
