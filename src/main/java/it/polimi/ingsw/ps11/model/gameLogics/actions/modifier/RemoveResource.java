package it.polimi.ingsw.ps11.model.gameLogics.actions.modifier;

import java.util.Optional;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction.IncrementResource;

public class RemoveResource extends ActionDecorator<IncrementResource>{

	public RemoveResource(Class<IncrementResource> target) {
		super(target);
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLegal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Action enable(ActionManager aManager) {
		Optional<ActionDecorator<IncrementResource>> decorator = aManager.get(IncrementResource.class);
//		if(decorator.isPresent())
//			return decorator.decore(this);
		return null;
	}

	@Override
	public ActionDecorator<IncrementResource> decore(IncrementResource action) {
		this.action = action;
		return this;
	}

}
