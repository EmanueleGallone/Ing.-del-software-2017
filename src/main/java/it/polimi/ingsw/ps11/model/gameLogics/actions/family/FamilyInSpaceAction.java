package it.polimi.ingsw.ps11.model.gameLogics.actions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
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
	private int servant, modifier;
	private boolean alreadyDone;
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember;
		this.space = space;
		this.servant = 0;
		this.alreadyDone = aManager.state().isDone();
	}
	
	private DecrementAction makeServantAction (){
		DecrementAction servantAction = new DecrementAction(aManager, new ResourceList(new Servant(servant)));
		return aManager.affect(servantAction);
	}
	
	@Override
	public boolean isLegal() {

		if(alreadyDone){
			aManager.state().invoke("This action can be done only once per Turn.");
			return false;
		}
		if(space.isFree() && makeServantAction().isLegal()){
			return checkActionCost();
		}
		return false;
	}

	public void addModifier(int modifier){
		this.modifier = this.modifier + modifier;
	}
	
	public boolean checkActionCost(){
		if(space.getActionCost() > (getFamilyValue())){
			aManager.state().invoke("The value of the selected family member is not high enough.");
			return false;
		}
		return true;
	}
	
	@Override
	public void perform() {
		if(servant>0)
			makeServantAction().perform();
		
		if(familyMember!=null){
			space.placeFamilyMember(familyMember, aManager.state().getPlayer());
			familyMember.setUsed(true);
		}
		if(space.getResources()!=null){
			IncrementAction increment = new IncrementAction(aManager,space.getResources());
			increment = aManager.affect(increment);
			increment.perform();
		}
		aManager.state().setActionDone(true);
		aManager.state().invoke(new GameUpdateEvent(aManager.state().getGame()));

	}
	
	public void setAlreadyDone(boolean alreadyDone) {
		this.alreadyDone = alreadyDone;
	}
	
	public void incrementServant(int servant) {
		this.servant = this.servant + servant;
	}
	
	public ActionSpace getSpace() {
		return space;
	}
	
	public int getFamilyValue() {
		int familyValue = 0;
		if(familyMember != null)
			familyValue = familyMember.getValue();
		return modifier + servant + familyValue;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	@Override
	public boolean notifyConfirm(ConfirmViewEvent confirm) {
		this.incrementServant(confirm.getServant());
		if(isLegal()){
			perform();
			return true;
		}
		return false;
	}

	@Override
	public ConfirmEvent getConfirm() {
		return new ConfirmEvent(space);
	}
	
//	@Override
//	public FamilyInSpaceAction clone() {
//		return new FamilyInSpaceAction(aManager, familyMember, space, servant);
//	}

}
