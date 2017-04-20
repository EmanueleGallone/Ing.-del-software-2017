package it.polimi.ingsw.resources;

import event.Decrementable;
import event.Event;
import event.Events;
import event.Incrementable;
import event.Observable;
import event.Observer;
import event.Observers;

public class TestBonus implements Observers {
	private int value;
	private String whatDoes = "incrementa le tue pietr di 5 ogni qualvolta ne ricevi";
	
	public TestBonus(){
		this.value = 5;
	}

	@Override
	public void preEventUpdate(Events event) {
		System.out.println("dovrei aumentarti il valore delle pietre ma ancora non so come fare!");

	}

	@Override
	public void postEventUpdate(Events event) {
		System.out.println("dovrei aver finito di aumentare il tuo valore di pietre!");
		
		Observable o = event.getSubject();
		
		if(o instanceof Stone){
			((Stone) o).setValue(10);
			System.out.println("Aumentato il valore delle pietre!");
		}

	}

}
