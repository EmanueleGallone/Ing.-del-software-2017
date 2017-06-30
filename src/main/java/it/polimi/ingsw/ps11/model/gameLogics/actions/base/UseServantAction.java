package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
/** <h3> UseServantAction </h3>
 * <p> Classe che rappresenta l'azione di aggiunta di servitori all'attivazione di un'altra azione, allo scopo di 
 * raggiungere il costo predefinito.</p>
 * @see Action
 */
public class UseServantAction implements Action<UseServantAction>{

	protected ActionManager aManager;
	protected Servant servant;
	protected FamilyMember familyMember;
	
	public UseServantAction(ActionManager aManager,Servant servant, FamilyMember fMember) {
		this.aManager = aManager;
		this.servant = servant;
		this.familyMember = fMember;
	}

	@Override
	public boolean isLegal() {
		DecrementAction decrement = aManager.newDecrementAction(new ResourceList(servant));
		return decrement.isLegal();
	}

	@Override
	public void perform() {
		DecrementAction decrement = aManager.newDecrementAction(new ResourceList(servant));
		decrement.perform();
		familyMember.setModifier(servant.getValue());
	}
	
	public Servant getServant() {
		return servant;
	}
	
	public void setServant(int servant) {
		this.servant.setValue(servant);
	}
	
	// _________________________ Method for action system ________________________
	

	@Override
	public void attach(ActionManager aManager) {
		UseServantAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}

	@Override
	public Class<UseServantAction> target() {
		return UseServantAction.class;
	}
	

	@Override
	public UseServantAction decore(UseServantAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public UseServantAction clone() {
		UseServantAction copy = new UseServantAction(aManager, servant.clone(), familyMember.clone());
		return copy;
	}

}
