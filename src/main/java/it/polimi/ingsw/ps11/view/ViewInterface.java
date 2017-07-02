package it.polimi.ingsw.ps11.view;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public interface ViewInterface {
	
	public void print();
	public abstract void out(String message);

	void update(Game game);
	public void update(Board board);
	public void update(Player player);
	
	public void update(FamilyMemberManager familyMemberManager);
	public void chooseResource(ArrayList<ResourceList> options);
	
	public void confirm(ConfirmEvent confirm);
	
}
