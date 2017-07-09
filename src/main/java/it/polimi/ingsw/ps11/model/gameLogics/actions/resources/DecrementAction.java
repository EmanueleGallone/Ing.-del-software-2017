package it.polimi.ingsw.ps11.model.gameLogics.actions.resources;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

/** <h3> DecrementAction </h3>
 * <p> Classe che rappresenta l'azione di decremento di risorse in una ResourceList.</p>
 * @see Action
 */
public class DecrementAction extends IncrementAction{

	public DecrementAction(ActionManager aManager, ResourceList resources) {
		super(aManager, resources);
	}
	
	@Override
	public boolean isLegal() {
		Player player = aManager.state().getPlayer();
		boolean result = super.isLegal() &&  player.getResourceList().canSubtract(getResources());

		if(!result && getResources() != null)
			aManager.state().invoke("You do not have enough resources; You should have: " + getResources().toString() );
		
		return result;
	}
	
	@Override
	public void perform() {
		aManager.state().getPlayer().getResourceList().subtract(getResources());
		GameUpdateEvent event = new GameUpdateEvent(aManager.state().getGame());
		aManager.state().getGameLogic().notifyAllClients(event);
	}
	
	@Override
	public DecrementAction clone() {
		ResourceList resourceList = resources;
		if(resources != null)
			resourceList = resources.clone();
		return new DecrementAction(aManager, resourceList);
	}
}
