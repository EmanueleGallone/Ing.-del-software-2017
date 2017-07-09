package it.polimi.ingsw.ps11.controller.server.gameServer;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class PlayerFactory {

	private Player defaultPlayer;
	private final int MAX_PLAYER = 4;
	
	public PlayerFactory() {
		try {
			defaultPlayer = new Loader(FileRegistry.player).load(Player.class);
		} catch (FileNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Player> takeAll(){
		return take(MAX_PLAYER);
	}
	
	public ArrayList<Player> take(int number){
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < number; i++){
			players.add(newPlayer(i));
		}
		return players;
	}
	
	public Player newPlayer(String name,int position){
		Player player = newPlayer(position);
		player.setName(name);
		return player;
	}
	
	public Player newPlayer(int position){
		Colors[] colors = Colors.values();
		
		Player newPlayer = defaultPlayer.clone();
		newPlayer.setColor(colors[position]);
		
		ResourceList temp = new ResourceList(new Coin(position));   		//Incremento coin in base alla posizione
		newPlayer.getResourceList().sum(temp);
		
		return newPlayer;
	}
	
	
	
	
//	
//	public static void main(String[] args) {
//		
//		ArrayList<Resource> DEFAULT_RESOURCE = new ArrayList<>(Arrays.asList(new Wood(2),new Stone(2),new Servant(3),new Coin(5),new VictoryPoint(0),new FaithPoint(0),new MilitaryPoint(0)));	
//
//		FamilyMemberManager familyMemberManager = new FamilyMemberManager();
//		familyMemberManager.setFamilyMember(new BlackFamilyMember());
//		familyMemberManager.setFamilyMember(new OrangeFamilyMember());
//		familyMemberManager.setFamilyMember(new NeutralFamilyMember());
//		familyMemberManager.setFamilyMember(new WhiteFamilyMember());
//		
//		Player player = new Player(DEFAULT_RESOURCE, familyMemberManager);
//		
//		Loader loader = new Loader(FileRegistry.player);
//		loader.write(player);
//		
//	}
	
}