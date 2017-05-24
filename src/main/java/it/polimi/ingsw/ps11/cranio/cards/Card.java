package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public abstract class Card{
	
	private String name; //Va visto come un identificatore unico
	
	public Card() {
		//E i vari parametri, periodo,colore, ecc..
	}
	
//Start setters
	
	public void setName(String name) {
		this.name = name;
	}
	
//End setters
//Start getters
	public String getName() {
		return name;
	}
	
	
//End getters
	
}