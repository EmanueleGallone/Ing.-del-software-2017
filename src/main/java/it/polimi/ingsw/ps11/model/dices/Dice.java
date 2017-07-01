package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;
import java.util.Random;
/**
 * <h3>Dice</h3>
 * <p> Classe astratta che rappresenta l'oggetto dado del gioco. Contiene il valore del dado, compreso tra 1 e 6. 
 * Per ogni dado è stata implementata una classe concreta apposita, figlia di Dice.</p>
 * @version 1.0
 * @see BlackDice
 * @see OrangeDice
 * @see WhiteDice
 */
@SuppressWarnings("serial")
public abstract class Dice implements Serializable{
	protected static final int MAX_FACES = 6;
	protected int value;
	private transient Random gen = new Random();
	
	public Dice(){
		this.value = 0;
	}	
	/**<h3> void rollDice() </h3>
	/** <p>Permette di emulare il lancio del dado. Viene assegnato alla variabile <code>value</code> un valore random compreso tra 1 e 6.</p>
	 */
	public void rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
	}
	
	public int getValue(){
		return this.value;
	}
	
	
	@Override
	public abstract Dice clone();
	
	/**<h3> String toString() </h3>
	 * <p> TIPODADO [value= ]</p>
	 */
	public String toString(){
		return this.getClass().getSimpleName() + "[value=" + value + "]";
	};

}
