package pos.players;

import pos.Resources.Resource;

public class ResourceManager {
	
	private static final int DEFAULT_VALUE = 0;
	
	private Resource coin;
	private Resource wood;
	private Resource stone;
	private Resource servant;
	
	private Resource victoryPoint;
	private Resource militaryPoint;
	private Resource faithPoint;
	
	//Secondo me il tipo Resource non è necessario, può essere sostituito con Int
	
//Start Constructors
	
	//Costruttore che inizializza le risorse al valore di default
	public ResourceManager() {
		this(DEFAULT_VALUE);
	}	
	
	//Costruttore che inizializza ad un valore uguale per tutte le risorse
	public ResourceManager(int value) {
		this(value,value,value,value);
	}
	
	// Costruttore che inizializza a determinati valori
	public ResourceManager(int coin,int wood, int stone, int servant) {
		this.coin = new Resource(coin);
		this.wood = new Resource(wood);
		this.stone = new Resource(stone);
		this.servant = new Resource(servant);
	}
	
//End Constructors
//Start Logics
	
	public boolean greater(ResourceManager others){
		if(coin.getValue()>others.getCoin() && wood.getValue() > others.getWood() && stone.getValue() > others.getStone()){
			if (militaryPoint.getValue() > others.getMilitaryPoint() && faithPoint.getValue() > others.getFaithPoint()){
				return true;
			}
		}
		return false;
	}
	
//End logics
//Start getters
	
	public int getCoin() {
		return coin.getValue();
	}
	public int getWood() {
		return wood.getValue();
	}
	public int getStone() {
		return stone.getValue();
	}
	public int getServant() {
		return servant.getValue();
	}
	public int getVictoryPoint() {
		return victoryPoint.getValue();
	}
	public int getMilitaryPoint() {
		return militaryPoint.getValue();
	}
	public int getFaithPoint() {
		return faithPoint.getValue();
	}
//End getters
//Start setters
	public void setCoin(int coin) {
		this.coin.setValue(coin);
	}
	public void setWood(int wood) {
		this.wood.setValue(wood);
	}
	public void setStone(int stone) {
		this.stone.setValue(stone);
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

}
