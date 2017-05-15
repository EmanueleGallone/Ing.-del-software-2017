package it.polimi.ingsw.ps11.cranio.cards;


public class BlueCard extends DevelopmentCard {
	//carte PERSONAGGI

	public BlueCard(){
		this.id = 3;
	}

	@Override
	protected void insertCard(CardManager cardManager) {
		cardManager.addBlueCard(this);
	}

	@Override
	public void activePermanentEffect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activeIstantEffect() {
		// TODO Auto-generated method stub
		
	}

}
