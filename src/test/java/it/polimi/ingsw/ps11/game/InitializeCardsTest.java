package it.polimi.ingsw.ps11.game;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.loaders.InitializeCards;

public class InitializeCardsTest {

	@Test
	public void test() {
		InitializeCards.inizializzaCarte();
		InitializeCards.initializeExcommunication();
		InitializeCards.LeaderCardsInitializer();
	}

}
