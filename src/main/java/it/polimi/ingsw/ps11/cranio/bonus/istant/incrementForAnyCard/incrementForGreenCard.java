package it.polimi.ingsw.ps11.cranio.bonus.istant.incrementForAnyCard;

public class incrementForGreenCard extends IncrementForAnyCard{

	public incrementForGreenCard(int cardType, int value) {
		super(cardType, value);
	}
	
	
	//Va fatta una classe per ogni colore delle carte e per ogni risorsa...
	//Probabilmente meglio applicare il pattern decorator

	@Override
	public void behavior() {
		int cardNumber = this.player.getCardManager().getGreenDeck().size();
		this.player.incrementCoin(cardNumber * this.value);
	}

}
