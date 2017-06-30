package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
/** <h3> PlaceFamilyYieldAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare di un giocatore in un actionspace appartenente
 * ad una zona di Raccolta o Produzione.</p>
 * @see Action
 */
public class PlaceFamilyYieldAction implements Action<PlaceFamilyYieldAction> {

	protected ActionManager aManager;
	private Yield yield;
	private FamilyMember familyMember;
	
	public PlaceFamilyYieldAction() {
	
	}
	
	public PlaceFamilyYieldAction(ActionManager aManager, Yield yield, FamilyMember familyMember) {
		this.aManager = aManager;
		this.yield = yield;
		this.familyMember = familyMember;
	}
	
	@Override
	public boolean isLegal() {
		FamilyInSpaceAction s = aManager.newFamilyInSpace(familyMember, yield.getFreeSpace());
		return s.isLegal();
	}

	@Override
	public void perform() {
		FamilyInSpaceAction s = aManager.newFamilyInSpace(familyMember, yield.getFreeSpace());
		s.perform();
		ActiveYieldAction activeYield = aManager.newActiveYield(yield.getActiveCard(), familyMember.getValue());
		activeYield.perform();
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
// _________________________ Method for action system ________________________


	@Override
	public PlaceFamilyYieldAction decore(PlaceFamilyYieldAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		PlaceFamilyYieldAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<PlaceFamilyYieldAction> target() {
		return PlaceFamilyYieldAction.class;
	}
	
// ___________________________________________________
	
	@Override
	public PlaceFamilyYieldAction clone(){
		PlaceFamilyYieldAction copy = new PlaceFamilyYieldAction(aManager, yield.clone(), familyMember.clone());
		return copy;
	}

}
