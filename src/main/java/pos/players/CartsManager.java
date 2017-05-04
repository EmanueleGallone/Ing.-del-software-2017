package pos.players;

import java.util.ArrayList;

import pos.cards.Card;

public class CartsManager {
	
	private static final int MAX_TERRITORIES = 6;
	private static final int MAX_BUILDING = 6;
	
	private ArrayList<Card> Territories = new ArrayList<>();  // green (verde)
	private ArrayList<Card> Buildings = new ArrayList<>();    //yellow (giallo)
	private ArrayList<Card> Characters = new ArrayList<>();   //blue (blu)
	private ArrayList<Card> Ventures = new ArrayList<>();     //Purple (viola)
	
	
	//setter che eseguono il controllo dei max territori
	public boolean addTerritory(Card territory) {
		if (Territories.size()<MAX_TERRITORIES){
			Territories.add(territory);
			return true;
		}
		return false;
	}
	public boolean addBuilding(Card building){
		if (Buildings.size()<MAX_BUILDING){
			Buildings.add(building);
			return true;
		}
		return false;
	}
	public boolean addCharacter(Card character){
		Buildings.add(character);
		return true;
	}
	public boolean addVenture(Card venture){
		Buildings.add(venture);
		return true;
	}

	
	// getter
	public ArrayList<Card> getTerritories() {
		return Territories;
	}
	public ArrayList<Card> getBuildings() {
		return Buildings;
	}
	public ArrayList<Card> getCharacters() {
		return Characters;
	}
	public ArrayList<Card> getVentures() {
		return Ventures;
	}
	
}
