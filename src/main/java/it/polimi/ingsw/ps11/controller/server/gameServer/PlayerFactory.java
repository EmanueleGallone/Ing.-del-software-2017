package it.polimi.ingsw.ps11.controller.server.gameServer;


import java.io.FileNotFoundException;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class PlayerFactory {

	//private static final ArrayList<Resource> DEFAULT_RESOURCE = new ArrayList<>(Arrays.asList(new Wood(2),new Stone(2),new Servant(3),new Coin(5),new VictoryPoint(0),new FaithPoint(0),new MilitaryPoint(0)));	
	Player defaultPlayer;
	
	public PlayerFactory() {
		try {
			defaultPlayer = new Loader(FileRegistry.player).load(Player.class);
		} catch (FileNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
	}
	
//	public FamilyMemberManager familyMemberManager(){
//		ArrayList<FamilyMember> family = new ArrayList<>();
//		family.add(new BlackFamilyMember("Black"));
//		family.add(new WhiteFamilyMember("White"));
//		family.add(new OrangeFamilyMember("Orange"));
//		family.add(new NeutralFamilyMember("Neutral"));
//		
//		return new FamilyMemberManager(family);
//	}
	
	
	public Player newPlayer(int position){
		Colors[] colors = Colors.values();
		
		//Player player = new Player(DEFAULT_RESOURCE);
		Player newPlayer = defaultPlayer.clone();
		newPlayer.setColor(colors[position]);
		
		//Incremento coin in base alla posizione
		ResourceList temp = new ResourceList();
		temp.setResource(new Coin(position));
		newPlayer.getResourceList().sum(temp);
//		player.setFamilyManager(familyMemberManager());
		
		return newPlayer;
	}
}