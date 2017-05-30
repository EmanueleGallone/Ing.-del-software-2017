package it.polimi.ingsw.ps11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.Market;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.cranio.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.posTree.components.BoardView;
import it.polimi.ingsw.ps11.posTree.components.FloorView;
import it.polimi.ingsw.ps11.posTree.components.TowerView;

public class MainTest {
	
	
	
	public static void main(String[] args){
		
		BoardView boardView = new BoardView();
		
		TowerView towerView = new TowerView();
		
		//towerView.add(boardView); loop test
		boardView.add(towerView);

		boardView.add(new TowerView());
		boardView.add(new TowerView());
		
		towerView.add(new FloorView());
		towerView.add(new FloorView("target"));
		towerView.add(new FloorView());
		
		//System.out.println(boardView.searchById("target"));
		boardView.forEach((c)->{c.setId("bo");;});
		boardView.forEach((c)->{System.out.println(c.getId());});
		//System.out.println(boardView.searchAll((c)->{return c.getId() == "unknown";}));
		
		//inizializzatore();		
		/*String string = readFile("settings\\board");

		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		
		JsonAdapter jsonAdapter = new JsonAdapter(list);
		Board board = jsonAdapter.fromJson(string, Board.class);
		
		System.out.println(board.getTower(BlueTower.class).getFloors().get(3).getActionSpace().getResources());
		*/
	}
	
	
	
	
	
	
	
	public static void writeFile(String fileName, String testo){
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(testo);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
 public static String readFile(String fileName){
		
		BufferedReader reader = null;
		String testo = new String();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine())!= null) {
				testo = testo + line;
			}
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
	
 
 
	public static void inizializzatore(){
		
		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		//list.add(ResourceList.class);
		
		JsonAdapter gAdapter = new JsonAdapter(list);
		
// ___________ TUTTE LE TORRI ____________________________
		
		GreenTower greenTower = new GreenTower();
		greenTower.addFloor(new Floor(1));
		greenTower.addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		
		resource.setResource(new Wood(1));
		greenTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Wood(2));
		greenTower.addFloor(new Floor(7,resource.clone()));
		
		
		BlueTower blueTower = new BlueTower();
		resource = new ResourceList();
		
		blueTower.addFloor(new Floor(1));
		blueTower.addFloor(new Floor(3));
		
		resource.setResource(new Stone(1));
		blueTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Stone(2));
		blueTower.addFloor(new Floor(7,resource.clone()));
		
		
		YellowTower yellowTower = new YellowTower();
		resource = new ResourceList();
		
		yellowTower.addFloor(new Floor(1));
		yellowTower.addFloor(new Floor(3));
		
		resource.setResource(new MilitaryPoint(1));
		yellowTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new MilitaryPoint(2));
		yellowTower.addFloor(new Floor(7,resource.clone()));
		
	
		PurpleTower purpleTower = new PurpleTower();
		resource = new ResourceList();
		
		purpleTower.addFloor(new Floor(1));
		purpleTower.addFloor(new Floor(3));
		
		resource.setResource(new Coin(1));
		purpleTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Coin(2));
		purpleTower.addFloor(new Floor(7,resource.clone()));
		
		ArrayList<Tower> towers = new ArrayList<>();
		towers.add(greenTower);
		towers.add(blueTower);
		towers.add(yellowTower);
		towers.add(purpleTower);
		
 // ________ MARKET ________________________________________________
		
		
		ArrayList<ActionSpace> list2 = new ArrayList<>();
		
		resource = new ResourceList();
		resource.setResource(new Coin(5));
		list2.add(new ActionSpace(resource.clone()));
		
		resource = new ResourceList();
		resource.setResource(new Servant(5));
		list2.add(new ActionSpace(resource.clone()));
		
		resource = new ResourceList();
		resource.setResource(new Coin(2));
		resource.setResource(new MilitaryPoint(3));
		list2.add(new ActionSpace(resource.clone()));
		
		/*
		CouncilPrivilege councilPrivilege = new CouncilPrivilege();
		
		councilPrivilege.setResource(new Wood(1));
		councilPrivilege.setResource(new Stone(1));
		councilPrivilege.setResource(new Servant(2));
		councilPrivilege.setResource(new Coin(2));
		councilPrivilege.setResource(new MilitaryPoint(2));
		councilPrivilege.setResource(new FaithPoint(1));
		
		list2.add(new ActionSpace(councilPrivilege));
		*/
		
		Market market = new Market(list2);
		
  // ___________________________________________________
		
		
		
		Board board = new Board(towers,market,new MultipleActionSpace());
		
		writeFile("settings\\board", gAdapter.toJson(board));
		
	}
	
}






