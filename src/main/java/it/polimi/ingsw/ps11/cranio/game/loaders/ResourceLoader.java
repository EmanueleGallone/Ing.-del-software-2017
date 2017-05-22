package it.polimi.ingsw.ps11.cranio.game.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ResourceLoader extends Loader {
	
	private static final String DEFAULT_FILE_PATH = "settings//defaultResourceList";
	private static ResourceList resourceList;
	
	
	public ResourceLoader() {
		super(DEFAULT_FILE_PATH);
	}
	
	public ResourceLoader(String filePath) {
		super(filePath);
	}
	
	@Override
	public ResourceList load() throws IOException{
		
		if (this.resourceList != null){
			return this.resourceList;
		}
		
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader(getFilePath()));
			this.resourceList = deserializeResource(reader.readLine());
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
		
		return resourceList;
	}
	
	public ResourceList deserializeResource(String line){
		Gson gson = new Gson();
		return gson.fromJson(line, ResourceList.class);
	}
}
