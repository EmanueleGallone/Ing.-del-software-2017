package it.polimi.ingsw.ps11.cranio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public class MainTest {
	
	public static void main(String[] args){
		
		ActionSpace actionSpace = new ActionSpace();
		ResourceList resourceList = new ResourceList();
		
		resourceList.setValueOf(Stone.class, 5);
		resourceList.setResource(new Wood(9));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String string = gson.toJson(resourceList);
		
		System.out.println(string);
		
		ResourceList resourceList2 = gson.fromJson(string, ResourceList.class);
		resourceList2.setValueOf(Servant.class,9999);
		System.out.println(resourceList2.toString());
		
	}
}
