package it.polimi.ingsw.ps11.model.modelEvents;
/** <h3> ModelListener </h3>
 * <p> Classe che ascolta i cambiamenti nel model</p>
 */
public interface ModelListener {

	public void handle(GameUpdateEvent gameStartedEvent);
	public void handle(TextualEvent textualEvent);
	public void handle(PlayerUpdateEvent playerUpdateEvent);
	public void handle(ConfirmEvent conferma);
	public void handle(ChooseResourceEvent chooseCost);
	public void handle(UpdateFamilyMemberEvent updateFamilyMemberEvent);
}
