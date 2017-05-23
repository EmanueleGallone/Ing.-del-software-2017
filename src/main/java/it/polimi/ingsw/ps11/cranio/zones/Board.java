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
	
	private HashMap<String, Tower> towers = new HashMap<>();
	
	private Harvest harvest;
	private Production production;
	private Market market;
	private CardManager cards;
	private MultipleActionSpace councilPalace;
	
	public Board(){
		
		// Andranno caricate da file 
		towers.put(GreenTower.class.toString(), new GreenTower());
		towers.put(PurpleTower.class.toString(), new PurpleTower());
		towers.put(YellowTower.class.toString(), new YellowTower());
		towers.put(BlueTower.class.toString(), new BlueTower());
		
		harvest = new Harvest();
		production = new Production();
		
		market = new Market();
		
		councilPalace = new MultipleActionSpace();
		
		CardsLoader cardsLoader = new CardsLoader();
		
		try {
			cards = new CardManager(cardsLoader.load());
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Errore con il card manager, il file no c'e' ancora \n");
		}	
	}
	
	public Board(int period){
		//crea le torri in base al periodo (così carico le carte giuste)
	}
	
// End constructors
// Start setters
	
	
// End setters
// Start getters

	public ArrayList<Tower> getTowers() {
		
		ArrayList<Tower> t = new ArrayList<>(this.towers.values());
		return t;
	}
	
	public <T extends Tower> T getTower(Class<T> tower){
		return (T) this.towers.get(tower);
	}
	
	@Override
	public String toString() {
		return "Board [tempTowers=" + Arrays.asList(towers) 
		+", harvest=" + harvest 
		+ ", production=" + production 
		+ ", market=" + market 
		+ "]";
	}
	
// End getters
}
