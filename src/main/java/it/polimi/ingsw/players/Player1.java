package it.polimi.ingsw.players;

import it.polimi.ingsw.player.gadgets.PersonalBoard;

public class Player1 extends Player {
	
	public Player1(){
		super();
		this.position = 1;
	}
	
	public PersonalBoard getPersonalBoard(){
		return this.personalboard;
	}

	@Override
	public String toString() {
		return "Player1 [position=" + position + ", personalboard=" + personalboard + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private int numberOfYellowCard;
	private int numberOfGreenCard;
	
	//constructor recall the superclass constructor to build new resources. Every Player set default values
	public Player1(){
		super();
		
		this.numberOfGreenCard = 0;
		this.numberOfYellowCard = 0;
		
		this.coin.setValue(5);
		this.wood.setValue(5); 
		this.servant.setValue(5);
		this.stone.setValue(5);
		
		this.position=1;
		
	}
	
	@Override
	public String toString() {
		return "Player1 Points: "+ militarypoint + faithpoint + victorypoint +"\n\nPlayer1 RESOURCES AVAILABLES: ["+ coin  + wood  + stone  + servant +
				"\n\nYellowCards AVAILABLES:"+ Arrays.toString(yellowcard) +"]";
	}
	
	
	//add a Development Card. Throw Exception if you already have 6 Yellow or Green cards
	@Override
	public void addDevelopmentCard(DevelopmentCard card) throws Exception{
		
		//distinguish between different type of cards
		
		
		if(card instanceof YellowCard) {
			
			if(numberOfYellowCard > DevelopmentCard.MAX_YELLOW_CARDS)
				throw new Exception("HAI RAGGIUNTO IL LIMITE DI CARTE PER IL COLORE GIALLO!");
			
			this.yellowcard[numberOfYellowCard]=new YellowCard();
			this.numberOfYellowCard++;
			
		}
		
		if(card instanceof BlueCard) {
			
			this.bluecard.add(new BlueCard());
		}
		
		if(card instanceof PurpleCard) {
			
			this.purplecard.add(new PurpleCard());
		}
		
		if(card instanceof GreenCard) {
			
			if(numberOfGreenCard > DevelopmentCard.MAX_GREEN_CARDS)
				throw new Exception("HAI RAGGIUNTO IL LIMITE DI CARTE PER IL COLORE VERDE!");
			
			this.greencard[numberOfGreenCard] = new GreenCard();
			numberOfGreenCard++;
		}
		
	}//end of addDevelopmentCard() */
	

}
