package it.polimi.ingsw.ps11.cranio.loaders;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ResourceLoader extends Loader {

	private static final String DEFAULT_FILE_PATH = "settings//defaultResourceList";
	private static ResourceList resourceList;
	
	public ResourceLoader() {
		super(DEFAULT_FILE_PATH);
	}

	@Override
	public ResourceList load() throws IOException {
		if (resourceList == null){
			ArrayList<String> testo = this.read();
			ResourceList rList = ResourceList.fromJson(testo.get(0)); //Da rivedere
			resourceList = rList;
		}
		return resourceList.clone();
	}
}
