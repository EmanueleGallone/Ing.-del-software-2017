package gioco.da.console;

import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.OrangeDice;
import it.polimi.ingsw.dices.WhiteDice;
import it.polimi.ingsw.zones.BlueTower;
import it.polimi.ingsw.zones.CouncilPalace;
import it.polimi.ingsw.zones.GreenTower;
import it.polimi.ingsw.zones.HarvestZone1;
import it.polimi.ingsw.zones.Market;
import it.polimi.ingsw.zones.ProductionZone1;
import it.polimi.ingsw.zones.PurpleTower;
import it.polimi.ingsw.zones.YellowTower;

public class Board {
	//rispetta il pattern Facade, o no?
	
	private YellowTower yellowTower;
	private BlueTower blueTower;
	private PurpleTower purpleTower;
	private GreenTower greenTower;
	
	private HarvestZone1 harvest;
	private ProductionZone1 production;
	private CouncilPalace cambiaPosizioni;
	
	private Market market;
	
	private BlackDice blackDice;
	private OrangeDice orangeDice;
	private WhiteDice whiteDice;
	
	private int period;
	
	public Board(){
		yellowTower = new YellowTower();
		purpleTower = new PurpleTower();
		greenTower = new GreenTower();
		blueTower = new BlueTower();
		
		harvest = new HarvestZone1();
		production = new ProductionZone1();
		cambiaPosizioni = new CouncilPalace();
		
		market = new Market();
		
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
	}
	
	public Board(int period){
		this.period = period;
		
		yellowTower = new YellowTower(period);
		blueTower = new BlueTower(period);
		greenTower = new GreenTower(period);
		purpleTower = new PurpleTower(period);
		
		harvest = new HarvestZone1();
		production = new ProductionZone1();
		cambiaPosizioni = new CouncilPalace();
		
		market = new Market();
		
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
	}
	
	@Override
	public String toString() {
		return "Board [yellowTower=" + yellowTower + ", blueTower=" + blueTower + ", purpleTower=" + purpleTower
				+ ", greenTower=" + greenTower + ", harvest=" + harvest + ", production=" + production
				+ ", cambiaPosizioni=" + cambiaPosizioni + ", blackDice=" + blackDice + ", orangeDice=" + orangeDice
				+ ", whiteDice=" + whiteDice + ", period=" + period + "]";
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
		
	public void cambiaPosizioni(Player player){
		cambiaPosizioni.activate(player);
	}
	
	public void activateHarvest(Player player){
		harvest.active(player);
	}
	
	public void activateProduction(Player player){
		production.active(player);
	}
	
	public void activateCoinGen(Player player){
		market.getCoinGen().activate(player);
	}
	
	public void activateServantGen(Player player){
		market.getSerGen().activate(player);
	}
	
	private void printTower(){
		//mancano le altre torri. credo si possa anche eliminare questo metodo
		for(int i = 0; i<4;i++)
			System.out.println("TorreGialla"+ yellowTower.toString());
	}
	
	public YellowTower getYellowTower(){
		return this.yellowTower;
	}
	
	public BlueTower getBlueTower(){
		return this.blueTower;
	}
	
	public PurpleTower getPurpleTower(){
		return this.purpleTower;
	}
	
	public GreenTower getGreenTower(){
		return this.greenTower;
	}
	
	public boolean hasHarvestZoneOccupied(){
		return harvest.isOccupied();
	}

	public boolean hasProductionZoneOccupied(){
		return production.isOccupied();
	}
	
	public boolean hasCoinGeneratorOccupied(){
		return market.getCoinGen().isOccupied();
	}
	
	public boolean hasServantGeneratorOccupied(){
		return market.getSerGen().isOccupied();
	}
	
}
