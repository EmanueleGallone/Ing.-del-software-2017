package it.polimi.ingsw.ps11.cranio.game.FileMakers;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class PlayerResourceFileMaker {
	
	private static final String DEFAULT_PATH = "resource.txt";
	private ResourceList resourceList;
	
	public PlayerResourceFileMaker() {
		//default values per i giocatori
		resourceList = new ResourceList();
		resourceList.setAllToZeroValue();
		
		resourceList.setResource(new Stone(2));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Servant(3));
		resourceList.setResource(new Coin(5));
		resourceList.setResource(new MilitaryPoint(0));
		resourceList.setResource(new FaithPoint(0));
		resourceList.setResource(new VictoryPoint(0));		
		
	}
	
	public static void main (String[] args){
		PlayerResourceFileMaker p = new PlayerResourceFileMaker();
		Gson gson = new Gson();
		
		
		
		try {
			FileWriter writer = new FileWriter(DEFAULT_PATH);
			writer.write(gson.toJson(p));
			writer.flush();
			System.out.println("File scritto!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	

}
