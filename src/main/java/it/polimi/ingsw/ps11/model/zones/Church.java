package it.polimi.ingsw.ps11.model.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.malus.Excommunication;

public class Church {
	
	private ArrayList<Excommunication> excommunications = new ArrayList<>();
	
	public Church() {
		
	}
	
	public ArrayList<Excommunication> getExcommunications() {
		return excommunications;
	}

}
