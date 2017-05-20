package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.YellowCard;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Harvest;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Production;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class Board {
	
	
	//Vorrei usare una map che ha come chiave un enum di colori...
	private ArrayList<Tower> towers = new ArrayList<>();
	
	private Harvest harvest = new Harvest();
	private Production production = new Production();
		
	private Market market = new Market();
	
// Start constructors
	
	public Board() {
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
	}
	
// End constructors
// Start setters
	
	public void addTower(Tower tower){
		towers.add(tower);
	}
	
// End setters
// Start getters

	public ArrayList<Tower> getTowers() {
		return towers;
	}
	
// End getters



}
