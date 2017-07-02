package it.polimi.ingsw.ps11.controller.server.gameServer;


import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class PlayerFactory {

	private static final ArrayList<Resource> DEFAULT_RESOURCE = new ArrayList<>(Arrays.asList(new Wood(2),new Stone(2),new Servant(3),new Coin(5),new VictoryPoint(0),new FaithPoint(0),new MilitaryPoint(0)));	
	
	
	public PlayerFactory() {
		
	}
	
	public FamilyMemberManager familyMemberManager(){
		ArrayList<FamilyMember> family = new ArrayList<>();
		family.add(new BlackFamilyMember("Black"));
		family.add(new WhiteFamilyMember("White"));
		family.add(new OrangeFamilyMember("Orange"));
		family.add(new NeutralFamilyMember("Neutral"));
		
		return new FamilyMemberManager(family);
	}
	
	
	public Player newPlayer(int position){
		Colors[] colors = Colors.values();
		
		Player player = new Player(DEFAULT_RESOURCE);
		player.setColor(colors[position]);
		
		//Incremento coin in base alla posizione
		ResourceList temp = new ResourceList();
		temp.setResource(new Coin(position));
		player.getResourceList().sum(temp);
		player.setFamilyManager(familyMemberManager());
		
		return player;
	}
}