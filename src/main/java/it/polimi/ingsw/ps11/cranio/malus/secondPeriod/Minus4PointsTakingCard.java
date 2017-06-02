package it.polimi.ingsw.ps11.cranio.malus.secondPeriod;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class Minus4PointsTakingCard<T extends DevelopmentCard> extends Excommunication {
	
	private Class<T> cardType;
	
	public Minus4PointsTakingCard(Class<T> cardType,Player player) {
		this.cardType = cardType;
		this.owner = player;
	}

	@Override
	public void behaviour() {
		//imposta modificatore per quella torre per quel determinato giocatore.
		//oppure imposta modificatore all'interno del giocatore, per ogni familiare
		//quando prendi quella determinata carta fai un check dei malus? boh
		
	}
	
	public Class<T> getCardType() {
		return cardType;
	}

}
