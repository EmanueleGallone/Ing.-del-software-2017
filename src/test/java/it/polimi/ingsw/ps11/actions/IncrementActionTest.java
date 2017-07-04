package it.polimi.ingsw.ps11.actions;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class IncrementActionTest {
	

	@Test
	public void baseTest(){
		
		ResourceList resourceList_1 = new ResourceList();
		
		resourceList_1.setResource(new Coin(5));
		resourceList_1.setResource(new Stone(2));
		resourceList_1.setResource(new Wood(2));
		
			//Resource list inizializzata 
		
		//Creo l'azione che incrementa la resourceList_1 di 2 coin e 3 wood
		
		//Prima di tutto bisogna definire la resourceList che andrà sommata a resourceList_1
		ResourceList resourceToAdd = new ResourceList();
		
		resourceToAdd.setResource(new Coin(2));
		resourceToAdd.setResource(new Wood(3));
	}
	
	

}
