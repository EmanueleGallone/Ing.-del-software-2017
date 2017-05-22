package it.polimi.ingsw.ps11.cranio.game.loaders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.game.FileMakers.ResourceListSerializer;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ResourceLoader extends Loader {
	
	private static final String DEFAULT_PATH = "resource.txt";
	
	private ResourceList resourceList;
	
	private Gson gson = new Gson();
	
	private FileReader reader;
	
	
	/*public ResourceLoader() {
		super(DEFAULT_PATH);
	}
	
	public ResourceLoader(String filePath) {
		super(filePath);
	}*/
	
	public ResourceList load(){
		
		//resourceList = new ResourceList();
		//resourceList.setAllToZeroValue();
		
		ResourceList temp = new ResourceList();
		
		try {
			reader = new FileReader(DEFAULT_PATH);
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resourceList;
		
				
		
	}
	
	
}
