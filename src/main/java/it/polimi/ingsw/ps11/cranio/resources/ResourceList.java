package it.polimi.ingsw.ps11.cranio.resources;

import java.util.HashMap;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.list.*;

public class ResourceList implements Iterable<Resource>,Cloneable {
	
	private static final int DEFAULT_COST = 0;
	
	private Stone stone;
	private Wood wood;
	private Coin coin;
	private Servant servant;
	
	private VictoryPoint victoryPoint;
	private MilitaryPoint militaryPoint;
	private FaithPoint faithPoint;
	
	private HashMap<Integer,Resource> resources = new HashMap<Integer,Resource>();
	
// start constructor
	
	public ResourceList(){
		
		stone = new Stone(DEFAULT_COST);
		wood = new Wood(DEFAULT_COST);
		coin = new Coin(DEFAULT_COST);
		servant = new Servant(DEFAULT_COST);
		
		victoryPoint = new VictoryPoint(DEFAULT_COST);
		militaryPoint = new MilitaryPoint(DEFAULT_COST);
		faithPoint = new FaithPoint(DEFAULT_COST);
		
		resources.put(stone.getID(), stone);
		resources.put(wood.getID(), wood);
		resources.put(coin.getID(), coin);
		resources.put(servant.getID(), servant);
		resources.put(militaryPoint.getID(), militaryPoint);
		resources.put(faithPoint.getID(), faithPoint);
		resources.put(victoryPoint.getID(), victoryPoint);
	}
	
	
// end constructor
// start logic
	
	/**
	 * Ritorna "False" se almeno un campo di otherList è maggiore di quello della lista su cui viene
	 * chiamata la funzione greater
	 */
	public boolean greater (ResourceList otherList){
		for(Integer key : resources.keySet()){
			if(resources.get(key).getValue() <  otherList.getResourceById(key).getValue()){
				return false;
			}
		}
		return true;			
	}
	
	/**
	 * Fa la somma tra questa resource list e la resource list del giocatore che gli viene passata.
	 * Il risultato lo assegna alla resourceList che gli viene passata
	 */
	public void sum(ResourceList resources){
		for (Resource resource : resources){
			resource.increment(getResourceById(resource.getID()).getValue());
			//E' meglio passare per il getter o accedere direttamente facendo resources.get(resource.getID)??
		}
	}
	
	public ResourceList clone(){
		return (ResourceList)this.clone();
	}
	
// end logic
// Start Iterator

	@Override
	public Iterator<Resource> iterator() {
		return  resources.values().iterator();
	}
	
// End iterator
// Start getters
	
	public Resource getResourceById(int i){
		return this.resources.get(i);
	}
	
	public int getStoneValue() {
		return stone.getValue();
	}

	public int getWoodValue() {
		return wood.getValue();
	}

	public int getCoinValue() {
		return coin.getValue();
	}

	public int getServantValue() {
		return servant.getValue();
	}
	public int getMilitaryPointsValue(){
		return this.militaryPoint.getValue();
	}
		
	public int getFaithPointsValue(){
		return this.faithPoint.getValue();
	}
		
	public int getVictoryPointsValue(){
		return this.victoryPoint.getValue();
	}

	
	
	

	public Stone getStone() {
		return stone;
	}

	public Wood getWood() {
		return wood;
	}

	public Coin getCoin() {
		return coin;
	}

	public Servant getServant() {
		return servant;
	}

	public VictoryPoint getVictoryPoint() {
		return victoryPoint;
	}

	public MilitaryPoint getMilitaryPoint() {
		return militaryPoint;
	}

	public FaithPoint getFaithPoint() {
		return faithPoint;
	}
	
//End getters
	
// Start setters

	public void setStone(int stone) {
		this.stone.setValue(stone);
	}

	public void setWood(int wood) {
		this.wood.setValue(wood);
	}

	public void setCoin(int coin) {
		this.coin.setValue(coin);
	}

	public void setServant(int servant) {
		this.servant.setValue(servant);
	}

	public void setVictoryPoint(int victoryPoint) {
		this.victoryPoint.setValue(victoryPoint);
	}

	public void setMilitaryPoint(int militaryPoint) {
		this.militaryPoint.setValue(militaryPoint);
	}

	public void setFaithPoint(int faithPoint) {
		this.faithPoint.setValue(faithPoint);
	}
//End setters
	
}
