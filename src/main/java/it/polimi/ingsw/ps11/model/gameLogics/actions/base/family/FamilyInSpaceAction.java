package it.polimi.ingsw.ps11.model.gameLogics.actions.base.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.UseServantAction;
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
	protected UseServantAction useServantAction;
	
	public FamilyInSpaceAction() {
	
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember;
		this.space = space;
		useServantAction = aManager.newUseServant(new Servant(0), fMember);
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space, UseServantAction servantAction) {
		this(aManager,fMember,space);
		this.useServantAction = servantAction;
	}
	
	@Override
	public boolean isLegal() {
		int servant = 0;
		if(useServantAction != null && useServantAction.isLegal()){
			servant = useServantAction.getServant().getValue();
		}
		if(space.isFree()){
			return checkActionCost(servant);
		}
		return false;
	}

	public boolean checkActionCost(int modifier){
		if(space.getActionCost() > (familyMember.getValue() + modifier)){
			aManager.send("Il familiare non ha un valore sufficiente");
			return false;
		}
		return true;
	}
	
	@Override
	public void perform() {
		if(useServantAction!= null)
			useServantAction.perform();
		space.placeFamilyMember(familyMember, aManager.getSubject());
		familyMember.setUsed(true);
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
	
	public UseServantAction getUseServantAction() {
		return useServantAction;
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
		FamilyInSpaceAction copy = new FamilyInSpaceAction(aManager, familyMember, space);
		return copy;
	}

}
