package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
/** <h3> FamilyInSpaceAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare i un generico actionspace.</p>
 * @see Action
 */
public class FamilyInSpaceAction implements Action<FamilyInSpaceAction>{
	
	protected ActionManager aManager;
	protected FamilyMember familyMember;
	protected ActionSpace space;
	protected UseServantAction servantAction;
	
	public FamilyInSpaceAction() {
	
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember.clone();
		this.space = space;
		servantAction = aManager.newUseServant(new Servant(0), fMember);
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space, UseServantAction servantAction) {
		this(aManager,fMember,space);
		this.servantAction = servantAction;
	}
	
	@Override
	public boolean isLegal() {
		int mod = 0;
		boolean result = true;
		if(servantAction != null){
			result = servantAction.isLegal();
			mod = servantAction.getServant().getValue();
		}
		if(space.isFree() && result){
			result = space.getActionCost() <= (familyMember.getValue() + mod);
			return result;
		}
		return false;
	}

	@Override
	public void perform() {
		if(servantAction!= null)
			servantAction.perform();
		space.placeFamilyMember(familyMember, aManager.getSubject());
		if(space.getResources()!=null){
			IncrementAction increment = aManager.newIncrementAction(space.getResources());
			increment.perform();
		}
	}
	
	public ActionSpace getSpace() {
		return space;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
	public UseServantAction getServantAction() {
		return servantAction;
	}


	// _________________________ Method for action system ________________________
	
	
	@Override
	public void attach(ActionManager aManager) {
		FamilyInSpaceAction act = aManager.get(target());
		if(act == null){
			act = this;
		}
		aManager.add(act.decore(this));
	}

	@Override
	public Class<FamilyInSpaceAction> target() {
		return FamilyInSpaceAction.class;
	}
	
	@Override
	public FamilyInSpaceAction decore(FamilyInSpaceAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
// ____________________________________________
	
	@Override
	public FamilyInSpaceAction clone() {
		FamilyInSpaceAction copy = new FamilyInSpaceAction(aManager, familyMember.clone(), space.clone());
		return copy;
	}

}
