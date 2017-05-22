package it.polimi.ingsw.ps11.startSetup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.experimental.theories.Theories;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.loaders.ResourceLoader;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class StartSetup {
	
	public static void scriviFile(String path,ArrayList<String> testo){
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(path));
			for (String line : testo ){
			  writer.write(line);
			  writer.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void scriviFile(String path , String riga){
		ArrayList<String> testo = new ArrayList<>();
		testo.add(riga);
		StartSetup.scriviFile(path, testo);
	}
	
	public static ArrayList<String> leggiFile(String path){
		
		BufferedReader reader = null;
		ArrayList<String> testo = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine())!= null){
				testo.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return testo;
	}
	
	
	public static void initializeResourceList(){
		Gson gson = new Gson();
		
		Wood wood = new Wood();
		Stone stone = new Stone();
		Coin coin = new Coin();
		Servant servant = new Servant();
		
		MilitaryPoint militaryPoint = new MilitaryPoint();
		FaithPoint faithPoint = new FaithPoint();
		VictoryPoint victoryPoint = new VictoryPoint();
		
		ResourceList resourceList = new ResourceList();
		
		resourceList.setResource(wood);
		resourceList.setValueOf(Wood.class,5);
		resourceList.setResource(stone);
		resourceList.setResource(coin);
		resourceList.setResource(servant);
		resourceList.setResource(militaryPoint);
		resourceList.setResource(faithPoint);
		resourceList.setResource(victoryPoint);
		
		//HashMap<Class<? extends Resource>, Resource> map = resourceList.getResources();
		
		//StartSetup.scriviFile("settings//defaultResourceList", gson.toJson(map));
	}
	
	public static void main (String[] args){
		//initializeResourceList();
	}
	
}
