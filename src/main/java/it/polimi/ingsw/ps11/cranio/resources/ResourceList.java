package it.polimi.ingsw.ps11.cranio.resources;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class ResourceList {
	
	private static final int DEFAULT_COST = 0;
	
	private Stone stone;
	private Wood wood;
	private Coin coin;
	private Servant servant;
	
	private VictoryPoint victoryPoint;
	private MilitaryPoint militaryPoint;
	private FaithPoint faithPoint;
	
	private HashMap<Integer,Resource> resources = new HashMap<Integer,Resource>();
	
	
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
		resources.put(VictoryPoint.getID(), victoryPoint);
		resources.put(MilitaryPoint.getID(), militaryPoint);
		resources.put(FaithPoint.getID(), faithPoint);
		
	
	}
	
	
	
	public boolean greater (ResourceList otherList){
		for(Integer key : resources.keySet()){
			if(resources.get(key).getValue() <  otherList.getResourceById(key).getValue()){
				return false;
			}
		}
		
		return true;			
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
	
	public Resource getResourceById(int i){
		return this.resources.get(i);
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
	
	
	
}
