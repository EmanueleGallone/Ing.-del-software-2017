package it.polimi.ingsw.ps11.cranio.zones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.game.RoundManager;
import it.polimi.ingsw.ps11.cranio.loaders.CardsLoader;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Harvest;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Production;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;
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
	private CardManager cards;
	private MultipleActionSpace councilPalace;
	
	public Board(){
		
		tempTowers.put(GreenTower.class, new GreenTower());
		tempTowers.put(PurpleTower.class, new PurpleTower());
		tempTowers.put(YellowTower.class, new YellowTower());
		tempTowers.put(BlueTower.class, new BlueTower());
		
		harvest = new Harvest();
		production = new Production();
		
		market = new Market();
		
		CardsLoader cardsLoader = new CardsLoader();
		try {
			cards = new CardManager(cardsLoader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}	
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
	
	public <T extends Tower> T getTower(Class<T> tower){
		return (T) this.tempTowers.get(tower);
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
