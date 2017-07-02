package it.polimi.ingsw.ps11.model.excommunications;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.FamilyInFloorBonus;
/**
 * Classe che rappresenta le prime 4 scomuniche contenute nel regolamento del gioco. Il giocatore che ha questa scomunica
 * dovrà pagare 4 servitori in più per prendere la carta dello stesso colore della scomunica
 */
public class TakeCardMinus4Excommunication extends Excommunication {
	
	private String cardType;
	
	public TakeCardMinus4Excommunication(Class<? extends DevelopmentCard> cardType) {
		this.cardType = cardType.toString();
		this.effect = new FamilyInFloorBonus(cardType, -4);
		this.period = 2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TakeCardMinus4Excommunication clone() {
		Class<? extends DevelopmentCard> klass = null;
		String name = this.cardType.replace("class ", "");
		
		try {
			klass = (Class<? extends DevelopmentCard>) Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		TakeCardMinus4Excommunication clone = new TakeCardMinus4Excommunication(klass);
		
		clone.effect = this.effect;
		clone.period = this.period;
		
		return clone;
	}

}
