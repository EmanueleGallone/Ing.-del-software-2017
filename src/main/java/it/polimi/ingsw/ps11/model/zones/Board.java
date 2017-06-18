package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.zones.harvestAndProduction.Production;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class Board implements Serializable{
	
	private HashMap<String, Tower> towers = new HashMap<>();
	private DiceManager diceManager = new DiceManager();
	private CardManager cards;
	
	private Production harvest = new Production();
	private Production production = new Production();
	private Market market;
	private CouncilPalace councilPalace;
	
	
	public Board(){
	
	}
	
	public Board(ArrayList<Tower> towers, Market market, CouncilPalace councilPalace){
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
	
	public Tower getTower(String tower){
		return this.towers.get(tower);
	}
	
	public CouncilPalace getCouncilPalace() {
		return councilPalace;
	}
	
	public Market getMarket() {
		return market;
	}
	
	public Production getProduction() {
		return production;
	}
	
	public Production getHarvest() {
		return harvest;
	}
	
	public DiceManager getDices() {
		return diceManager;
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
