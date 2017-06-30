package it.polimi.ingsw.ps11.model.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.bonus.ema.malus.Excommunication;
/**
 * <h3> Church </h3>
 * <p> Classe che rappresenta la zona della Chiesa del gioco con le carte scomunica associate</p>
 */
public class Church {
	
	private ArrayList<Excommunication> excommunications = new ArrayList<>();
	
	public Church() {
		
	}
	
	public ArrayList<Excommunication> getExcommunications() {
		return excommunications;
	}

}
