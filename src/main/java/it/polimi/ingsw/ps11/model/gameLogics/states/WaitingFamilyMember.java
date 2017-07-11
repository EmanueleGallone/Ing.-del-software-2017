package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.modelEvents.UpdateFamilyMemberEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.SpaceSelectedEvent;
/**
 * <h3> WaitingFamilyMember </h3>
 * <p> Classe che rappresenta lo stato di attesa del familaiare da posizionare da parte del giocatore. </p>
 * @see 
 */
public class WaitingFamilyMember extends PlayState{

	private SpaceSelectedEvent event;
	
	public WaitingFamilyMember(SpaceSelectedEvent event) {
		this.event = event;
	}
	
	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		event.setFamilySelectedEvent(familySelectedEvent);
		stateHandler().nextState(new PlayState());
		event.accept(stateHandler().currentState());
	}
	
	@Override
	public void notifyToClient() {
		Player player = stateHandler().getPlayer();
		stateHandler().invoke(new UpdateFamilyMemberEvent(player.getFamilyManager()));
	}
}
