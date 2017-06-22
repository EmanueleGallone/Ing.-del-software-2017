package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.zones.harvestAndProduction.Production;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
/**
 * <h3>Board</h3>
 * <p> Classe che rappresenta il tabellone. e' composto da vari oggetti quali: <ul>
 * <code><b>DiceManager:</b></code> Classe contenente i dadi.
 * <br><code><b>Production:</b></code> Classe rappresentante la zona produzione.
 * <br><code><b>Harvest:</b></code> Classe rappresentante la zona raccolta.
 * <br><code><b>market:</b></code> Classe rappresentante la zona mercato.
 * </p></ul>
 * 
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.dices.DiceManager DiceManager
 *
 */
public class Board implements Serializable{
	
	//private HashMap<String, Tower> towers = new HashMap<>();
	ArrayList<Tower> towers = new ArrayList<>();
	private DiceManager diceManager = new DiceManager();
	
	private Production harvest = new Production();
	private Production production = new Production();
	private Market market;
	private CouncilPalace councilPalace;
	//manca la church
	
	
	public Board(){
	
	}
	
	public Board(ArrayList<Tower> towers, Market market, CouncilPalace councilPalace){
		this.market = market;
		this.councilPalace = councilPalace;
		
		this.towers = towers;
		/*for(Tower t : towers){
			//this.towers.put(t.getClass().toString(), t);
			
		}
		*/
	}
	
// End constructors
// Start setters
	
	
// End setters
// Start getters
	
	public ArrayList<Tower> getTowers() {
		
		//ArrayList<Tower> t = new ArrayList<>(this.towers.values());
		return towers;
	}
	
	/*
	public <T extends Tower> T getTower(Class<T> tower){
		return (T) this.towers.get(tower.toString());
	}
	*/
	
	public Tower getTower(int tower){
		return this.towers.get(tower);
	}
	
	public CouncilPalace getCouncilPalace() {
		return this.councilPalace;
	}
	
	public Market getMarket() {
		return this.market;
	}
	
	public Production getProduction() {
		return this.production;
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
