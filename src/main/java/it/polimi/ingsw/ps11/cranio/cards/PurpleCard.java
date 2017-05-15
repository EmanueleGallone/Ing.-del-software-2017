package it.polimi.ingsw.ps11.cranio.cards;

public class PurpleCard extends DevelopmentCard {
	//carte IMPRESE
	public PurpleCard(){
		this.id = 4;
	}

	@Override
	protected void insertCard(CardManager cardManager) {
		cardManager.addPurpleCard(this);
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
