package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;

public class EmptyActionTest {
	
	@Test
	public void test(){
		EmptyAction action = new EmptyAction();
		assertFalse(action.isLegal());
		action.clone();
		
	}

}
