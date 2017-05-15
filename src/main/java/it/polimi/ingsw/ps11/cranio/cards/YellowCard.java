package it.polimi.ingsw.ps11.cranio.cards;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO
	
	public YellowCard(){
		this.id = 2;
	}


	@Override
	protected void insertCard(CardManager cardManager) {
		cardManager.addYellowCard(this);
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
