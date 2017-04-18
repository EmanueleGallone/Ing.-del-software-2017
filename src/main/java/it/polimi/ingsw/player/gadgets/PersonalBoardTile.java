package it.polimi.ingsw.player.gadgets;

import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.Wood;

//costruite così, le PersonalBoardTile possono aggiungere alla produzione solo legname e pietre. Non so se possano fare qualcos'altro
public class PersonalBoardTile {
	private Resource resource1;
	private Resource resource2;
	
	
	public PersonalBoardTile(){
		
		this.resource1 = new Wood();
		this.resource2 = new Stone();
	}
	
	//setters and getters
	public void setResource1(int value){
		this.resource1.setValue(value);
	}
	
	public void setResource2(int value){
		this.resource2.setValue(value);
	}
	
	public Resource getResource1(){
		return this.resource1;
	}
	
	public Resource getResource2(){
		return this.resource2;
	}
	//end of setters and getters

}
