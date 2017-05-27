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
