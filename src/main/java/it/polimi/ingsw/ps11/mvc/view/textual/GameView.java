package it.polimi.ingsw.ps11.mvc.view.textual;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class GameView {

	private Game game;
	
	public void update(Game game){
		this.game = game;
	}
	
	public void printTowers(){
		
		ArrayList<Tower> towers = game.getBoard().getTowers();
		ArrayList<DevelopmentCard> cards = new ArrayList<>();
		String output = "";
		for (Tower tower : towers){
			output = output + tower.getType().toString() + " :\n ";
			for (Floor floor : tower.getFloors()){
				output = output + floor.getCard().getName() + " ";
			}
			output = output + "\n\n";
		}
		
		System.out.println(output);
	}
	
	public void printPlayer(){
	  Player player = game.getRoundManager().getPlayerAttuale();
	  System.out.println(player.getPlayerName());
	}
	
	public Floor getFloor(int tower, int floor){
		ArrayList<Tower> torri = game.getBoard().getTowers();
		return torri.get(tower).getFloors().get(floor);
	}
	public FamilyMember getFamilyMember(int i){
		Player player = game.getRoundManager().getPlayerAttuale();
		FamilyMember familyMember = player.getFamilyManager().getBlackFamilyMember();
		return familyMember;
	}
}
