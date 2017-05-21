package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.YellowCard;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Harvest;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Production;
import it.polimi.ingsw.ps11.cranio.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.cranio.zones.towers.YellowTower;

public class Board {
	
	private HashMap<Class<? extends Tower>, Tower> tempTowers = new HashMap<Class<? extends Tower>, Tower>();
	
	private Harvest harvest;
	private Production production;
		
	private Market market;
	
	//manca il palazzo del consiglio
	
// Start constructors
	
	/*public Board() {
		
		for(Integer i = 0; i < 4; i++){
			Tower tower = new Tower();
			tower.setType(YellowCard.class);
			for(Integer c = 0 ; c < 4 ; c++){
				Floor floor = new Floor();
				DevelopmentCard card = new YellowCard();
				card.setName(i.toString() + " " + c.toString());
				floor.setCard(card);
				tower.addFloor(floor);
			}
			towers.add(tower);
		}
	}*/
	
	public Board(){
		tempTowers.put(GreenTower.class, new GreenTower());
		tempTowers.put(PurpleTower.class, new PurpleTower());
		tempTowers.put(YellowTower.class, new YellowTower());
		tempTowers.put(BlueTower.class, new BlueTower());
		
		harvest = new Harvest();
		production = new Production();
		
		market = new Market();
		
	}
	
	public Board(int period){
		//crea le torri in base al periodo (così carico le carte giuste)
	}
	
// End constructors
// Start setters
	
	
// End setters
// Start getters

	public HashMap<Class<? extends Tower>, Tower> getTempTowers() {
		return tempTowers;
	}

	@Override
	public String toString() {
		return "Board [tempTowers=" + Arrays.asList(tempTowers) 
		+", harvest=" + harvest 
		+ ", production=" + production 
		+ ", market=" + market 
		+ "]";
	}
	
// End getters



}
