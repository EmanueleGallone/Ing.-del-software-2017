package it.polimi.ingsw.ps11.mvc.model;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class Model {

	
	private Game game;
	
	public Model(Game game) {
		this.game = game;
	}
	
	public void doSomething(){
		
	}
	
	public Game getGame() {
		return game;
	}
	
	
	// Game logics
	
	public Floor getFloor(Class<Tower> tower, int i) {
		return game.getBoard().getTower(tower).getFloor(i);
	}
	
	public Tower getTower(Class<Tower> color){
		return game.getBoard().getTower(color);
	}
	
	
	public void familyInFloor(FamilyMember familyMember, Player player,Class<Tower> tower, int i){
		Floor floor = getFloor(tower, i);
		//Piazza familiare 
	}
	
	public void familyInMarket(FamilyMember familyMember, Player player, int index){
		//new PiazzaInMarket
	}
	
	public void finishRound(Player player){
		//Azione concludi il turno 
		// new ConcludiTurno(Player, RoundManager);
	}
	
	
}
