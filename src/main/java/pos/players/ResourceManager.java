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
	
	// Costruttore che inizializza a determinati valori
	public ResourceManager(int coin,int wood, int stone, int servant) {
		this.coin = new Resource(coin);
		this.wood = new Resource(wood);
		this.stone = new Resource(stone);
		this.servant = new Resource(servant);
	}
	
	//Costruttore che inizializza ad un valore uguale per tutte le risorse
	public ResourceManager(int value) {
		this(value,value,value,value);
	}
	
	//Costruttore che inizializza le risorse al valore di default
	public ResourceManager() {
		this(DEFAULT_VALUE);
	}
	
	public Resource getCoin() {
		return coin;
	}
	public Resource getWood() {
		return wood;
	}
	public Resource getStone() {
		return stone;
	}
	public Resource getServant() {
		return servant;
	}
	public Resource getVictoryPoint() {
		return victoryPoint;
	}
	public Resource getMilitaryPoint() {
		return militaryPoint;
	}
	public Resource getFaithPoint() {
		return faithPoint;
	}

}
