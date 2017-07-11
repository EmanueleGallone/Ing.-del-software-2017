package it.polimi.ingsw.ps11.model.game;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.zones.Church;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
/**
 * <h3>Board</h3>
 * <p> Classe che rappresenta il tabellone. e' composto da vari oggetti quali: <ul>
 * <br><code><b>Tower:</b></code> Classe contenente le 4 torri.
 * <br><code><b>DiceManager:</b></code> Classe contenente i dadi.
 * <br><code><b>Yield:</b></code> Classe rappresentante le zone raccolta e produzione.
 * <br><code><b>Market:</b></code> Classe rappresentante la zona mercato.
 * <br><code><b>CouncilPalace:</b></code> Classe rappresentante il palazzo del consiglio.
 * </p></ul>
 * @version 1.0
 * @see Tower
 * @see DiceManager
 * @see Yield
 * @see Market
 * @see CouncilPalace
 */
@SuppressWarnings("serial")
public class Board implements Serializable{
		
	private HashMap<String, Tower> towers = new HashMap<>();
	private DiceManager diceManager;
	
	private Yield harvest;
	private Yield production;
	private Market market;
	private CouncilPalace councilPalace;
	private Church church;
	
	ArrayList<DevelopmentCard> alreadyUsed = new ArrayList<>();
	
	public Board(){
		
	}
	
	public Board(ArrayList<Tower> towers, Market market, DiceManager diceManager ,CouncilPalace councilPalace) throws IOException{
		this.market = market;
		this.diceManager = diceManager;
		this.councilPalace = councilPalace;
		
		for(Tower t : towers){
			this.towers.put(t.getName(), t);
		}
	}
	
	public void setChurch(Church church) {
		this.church = church;
	}
	
	public void setCard(CardManager cards){
		for(Tower tower : towers.values()){
			ArrayList<DevelopmentCard> c = cards.getCardList(tower.getCardType());
			c.removeAll(alreadyUsed);
			alreadyUsed.addAll(tower.setCard(c));
			
		}
	}
	
	
	public void resetFamilyMember(){
		for(Tower tower : towers.values()){
			tower.resetFloors();
		}
		councilPalace.clean();
		production.resetFamilyMember();
		harvest.resetFamilyMember();
		market.clean();
	}


	
	public ArrayList<Tower> getTowers() {
		return new ArrayList<Tower>(towers.values());
	}	
	
	public Tower getTower(String tower){
		return this.towers.get(tower);
	}
	
	public CouncilPalace getCouncilPalace() {
		return this.councilPalace;
	}
	
	public void setCouncilPalace(CouncilPalace councilPalace) {
		this.councilPalace = councilPalace;
	}
	
	public Market getMarket() {
		return this.market;
	}
	
	public Church getChurch() {
		return church;
	}
	
	public Yield getProduction() {
		return this.production;
	}
	
	public Yield getHarvest() {
		return harvest;
	}
	
	public DiceManager getDices() {
		return diceManager;
	}
	
	public void setHarvest(Yield harvest) {
		this.harvest = harvest;
	}
	public void setProduction(Yield production) {
		this.production = production;
	}
	
	/**<h3> String toString() </h3>
	 * <p>Board [tempTowers= </p>
		, harvest= </p>
		, production= </p>
		, market= </p>
		];</p>
	 */
	@Override
	public String toString() {
		return "Board [tempTowers=" + Arrays.asList(towers) + '\n'
		+", harvest=" + harvest + '\n'
		+ ", production=" + production +'\n'
		+ ", market=" + market 
		+ "]";
	}
	
}
