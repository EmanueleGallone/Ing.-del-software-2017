package it.polimi.ingsw.ps11.model.gameLogics.newTry.actions;

import it.polimi.ingsw.ps11.model.gameLogics.newTry.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.Affecter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAction implements Action, Affecter<IncrementAction> {

	private Player player;
	private ResourceList resource;
	
	public IncrementAction(){
		
	}
	
	public IncrementAction(Player player, ResourceList resource) {
		this.player = player;
		this.resource = resource;
	}

	public ResourceList getResource() {
		return resource;
	}
	
	public void setResource(ResourceList resource) {
		this.resource = resource;
	}	

	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		System.out.println("Sono Increment Resource");
	}

	@Override
	public IncrementAction decore(IncrementAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}

	@Override
	public void perform(boolean execute) {
		if(execute){
			perform();
		}
	}
	
	@Override
	public void attach(ActionManager actionManager){
		IncrementAction increment = actionManager.get(IncrementAction.class);
		if(increment == null){
			increment = this;
		}
		actionManager.add(increment.decore(this));
	}

	@Override
	public Class<IncrementAction> target() {
		return IncrementAction.class;
	}
}
