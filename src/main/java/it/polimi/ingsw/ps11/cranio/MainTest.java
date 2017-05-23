package it.polimi.ingsw.ps11.cranio;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;

public class MainTest {
	
	public static void main(String[] args){
		ResourceList resourceList = new ResourceList();
		Gson gson = new Gson();
		
		String string = gson.toJson(resourceList);
		ResourceList resourceList2 = gson.fromJson(string,ResourceList.class);
		System.out.println(resourceList2.toString());
	}
}
