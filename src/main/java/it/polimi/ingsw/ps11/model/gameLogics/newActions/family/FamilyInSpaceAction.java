package it.polimi.ingsw.ps11.model.gameLogics.newActions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/** <h3> FamilyInSpaceAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare i un generico actionspace.</p>
 * @see Action
 */
public class FamilyInSpaceAction implements Action, NeedConfirm{

	
	private ActionManager aManager;
	private FamilyMember familyMember;
	private ActionSpace space;
	private int servant;
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember;
		this.space = space;
		this.servant = 0;
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space, int servant) {
		this(aManager,fMember,space);
		this.servant = servant;
	}
	
	private DecrementAction makeServantAction (){
		DecrementAction servantAction = new DecrementAction(aManager, new ResourceList(new Servant(servant)));
		return aManager.affect(servantAction);
	}
	
	@Override
	public boolean isLegal() {
		
		
		if(space.isFree() && makeServantAction().isLegal()){
			return checkActionCost(servant);
		}
		return false;
	}

	public boolean checkActionCost(int modifier){
		if(space.getActionCost() > (familyMember.getValue() + modifier)){
			aManager.state().invoke("Il familiare non ha un valore sufficiente");
			return false;
		}
		return true;
	}
	
	@Override
	public void perform() {
		if(servant>0)
			makeServantAction().perform();
		
		space.placeFamilyMember(familyMember, aManager.state().getPlayer());
		familyMember.setUsed(true);
		if(space.getResources()!=null){
			IncrementAction increment = new IncrementAction(aManager,space.getResources());
			increment = aManager.affect(increment);
			increment.perform();
		}
	}
	
	public void setServant(int servant) {
		this.servant = servant;
	}
	
	public ActionSpace getSpace() {
		return space;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	@Override
	public void notifyConfirm(ConfirmViewEvent confirm) {
		this.setServant(confirm.getServant());
		if(isLegal())
			perform();
	}

	@Override
	public ConfirmEvent getConfirm() {
		return new ConfirmEvent(space);
	}
	
	@Override
	public FamilyInSpaceAction clone() {
		ActionSpace s = space;
		FamilyMember fMember = familyMember;
		if(space!= null)
			s = space.clone();
		if(familyMember != null)
			fMember = familyMember.clone();
			
		return new FamilyInSpaceAction(aManager, fMember, s, servant);
	}

}
