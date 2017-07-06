package it.polimi.ingsw.ps11.model.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;

/**
 * <h3> Church </h3>
 * <p> Classe che rappresenta la zona della Chiesa del gioco con le carte scomunica associate</p>
 */
public class Church {
	
	private ArrayList<Excommunication> excomunications;
	
	public Church(ArrayList<Excommunication> excomunications) {
		this.excomunications = excomunications;
	}
	
	
	public Excommunication getExcomunications(int period) throws IllegalArgumentException {
		for(Excommunication e : excomunications){
			if(e.getPeriod() == period)
				return e;
		}
		throw new IllegalArgumentException();
	}

}
