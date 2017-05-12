package it.polimi.ingsw.ps11.cranio.resources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.list.*;

public class ResourceList implements Iterable<Resource> {
	
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
		
		resources.put(Stone.getID(), stone);
		resources.put(Wood.getID(), wood);
		resources.put(Coin.getID(), coin);
		resources.put(Servant.getID(), servant);
		resources.put(MilitaryPoint.getID(), militaryPoint);
		resources.put(FaithPoint.getID(), faithPoint);
		resources.put(VictoryPoint.getID(), victoryPoint);
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
	 * Fa la somma tra questa resource list e la resource list del giocatore che gli viene passato.
	 * Il risultato lo assegna al giocatore.
	 */
	public void sum(Player player){
		ResourceList playerResources = player.getResources();
		for (Resource resource : playerResources){
			this.getResourceById(resource.getID()).increment(resource.getValue());
			//E' meglio passare per il getter o accedere direttamente facendo resources.get(resource.getID)??
		}
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

	public void setStone(Stone stone) {
		this.stone = stone;
	}

	public void setWood(Wood wood) {
		this.wood = wood;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	public void setServant(Servant servant) {
		this.servant = servant;
	}

	public void setVictoryPoint(VictoryPoint victoryPoint) {
		this.victoryPoint = victoryPoint;
	}

	public void setMilitaryPoint(MilitaryPoint militaryPoint) {
		this.militaryPoint = militaryPoint;
	}

	public void setFaithPoint(FaithPoint faithPoint) {
		this.faithPoint = faithPoint;
	}
//End setters
	
}
