package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;
import java.util.Random;
/**
 * <h3>Dice</h3>
 * <p> Classe che rappresenta l'oggetto dado del gioco. Contiene un int per il value del dado, compreso tra 1 e 6, casuale per ogni
 * nuovo turno, una string identificativa per il nome del dado.</p>
 */
public class Dice implements Serializable{
	
	protected final int MAX_FACES = 6;
	private final int DEFAULT_VALUE = 0;
	protected int value;
	private transient Random gen = new Random();
	private String name = "undefined";
	
	public Dice(){
		this.value = DEFAULT_VALUE;
	}	
	
	public Dice(String name){
		this();
		this.name = name;
	}
	
	
	/**<h3> void rollDice() </h3>
	 * <p>Permette di emulare il lancio del dado. Viene assegnato alla variabile <code>value</code> un valore random compreso tra 1 e 6.</p>
	 */
	public void rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public  Dice clone(){
		Dice copy = new Dice();
		copy.value = value;
		return copy;
	}
	
	/**<h3> String toString() </h3>
	 * <p> TIPODADO [value= ]</p>
	 */
	public String toString(){
		return this.name + "[value=" + value + "]";
	};

}
