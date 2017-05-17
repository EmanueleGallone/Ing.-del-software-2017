package it.polimi.ingsw.ps11.cranio.game.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class ResourceLoader extends Loader {
	
	private static final String DEFAULT_PATH = "";
	private ArrayList<Resource> resources;
	
	
	public ResourceLoader() {
		super(DEFAULT_PATH);
	}
	
	public ResourceLoader(String filePath) {
		super(filePath);
	}
	
	@Override
	public ArrayList<Resource> load() throws IOException{
		
		if (this.resources != null){
			return this.resources;
		}
		
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader(getFilePath()));
			String line;
			
			while((line = reader.readLine()) != null){
				  resources.add(deserializeResource(line));
			}
		}
		finally {
			if (reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resources;
	}
	
	public Resource deserializeResource(String line){
		return null;
	}
}
