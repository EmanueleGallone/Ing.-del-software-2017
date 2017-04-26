package gioco.da.console;

import it.polimi.cards.DevelopmentCard;
import it.polimi.ingsw.dices.*;
import it.polimi.ingsw.zones.*;

public class Board {
	
	private YellowTower yellowTower;
	
	private HarvestZone1 harvest;
	private ProductionZone1 production;
	private CambiaPosizioni cambiaPosizioni;
	
	private BlackDice blackDice;
	private OrangeDice orangeDice;
	private WhiteDice whiteDice;
	
	private int period;
	
	public Board(){
		yellowTower = new YellowTower();
		
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
		
		harvest = new HarvestZone1();
		production = new ProductionZone1();
		cambiaPosizioni = new CambiaPosizioni();
	}
	
	public Board(int period){
		this.period = period;
		yellowTower = new YellowTower();
		blackDice = new BlackDice();
		harvest = new HarvestZone1();
		production = new ProductionZone1();
		cambiaPosizioni = new CambiaPosizioni();
		
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
	}

	@Override
	public String toString() {
		return "Board [yellowTower=" + yellowTower + "\n\nBlackDice="+ blackDice + "]";
	}
	
	//start of Dice getters
	public int getBlackDiceValue(){
		return blackDice.getValue();
	}
	
	public int getWhiteDiceValue(){
		return whiteDice.getValue();
	}
	
	public int getOrangeDiceValue(){
		return orangeDice.getValue();
	}//end of Dice getters
	
	public void rollDices(){
		blackDice.rollDice();
		whiteDice.rollDice();
		orangeDice.rollDice();
	}
	
	public DevelopmentCard getCard(int number){
		return yellowTower.getCard(number);
	}
	
	public void removeCard(int position){
		yellowTower.removeCard(position);		
	}
	
	public void cambiaPosizioni(Player player){
		cambiaPosizioni.activate(player);
	}
	
	public void activateHarvest(Player player){
		harvest.active(player);
	}
	
	public void activateProduction(Player player){
		production.active(player);
	}
	
	public void printTower(){
		//mancano le altre torri
		for(int i = 0; i<4;i++)
			System.out.println("TorreGialla"+ yellowTower.toString());
	}
	
	public YellowTower getYellowTower(){
		return this.yellowTower;
	}

	
}
