package it.polimi.ingsw.ps11.beta.server.gameServer;


import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.ps11.cranio.player.Colors;
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

public class PlayerFactory {

	private static final ArrayList<Resource> DEFAULT_RESOURCE = new ArrayList<>(Arrays.asList(new Wood(2),new Stone(2),new Servant(3),new Coin(5),new VictoryPoint(0),new FaithPoint(0),new MilitaryPoint(0)));	
	
	
	public PlayerFactory() {
		
	}
	
	
	public Player newPlayer(int position){
		Colors[] colors = Colors.values();
		
		Player player = new Player(DEFAULT_RESOURCE);
		player.setColor(colors[position]);
		
		//Incremento coin in base alla posizione
		ResourceList temp = new ResourceList();
		temp.setResource(new Coin(position));
		player.getResourceList().sum(temp);
		
		return player;
	}
}