package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Harvest;
import it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction.Production;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class Board {
	
	private HashMap<String, Tower> towers = new HashMap<>();
	
	private Harvest harvest = new Harvest();
	private Production production = new Production();
	private Market market;
	private CardManager cards;
	private MultipleActionSpace councilPalace;
	
	public Board(){
		
		// Andranno caricate da file 
	/*	towers.put(GreenTower.class.toString(), new GreenTower());
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
		}*/	
	}
	
	public Board(ArrayList<Tower> towers, Market market, MultipleActionSpace councilPalace){
		this.market = market;
		this.councilPalace = councilPalace;
		
		for(Tower t : towers){
			this.towers.put(t.getClass().toString(), t);
		}
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
		return (T) this.towers.get(tower.toString());
	}
	
	@Override
	public String toString() {
		return "Board [tempTowers=" + Arrays.asList(towers) + '\n'
		+", harvest=" + harvest + '\n'
		+ ", production=" + production +'\n'
		+ ", market=" + market 
		+ "]";
	}
	
// End getters
}
