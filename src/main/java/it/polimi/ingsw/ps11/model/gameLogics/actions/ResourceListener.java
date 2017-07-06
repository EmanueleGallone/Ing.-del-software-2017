package it.polimi.ingsw.ps11.model.gameLogics.actions;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> ResourceListener </h3>
 * <p> Interfaccia che ascolta le modifiche e aggiorna una resourceList.</p>
 * @see Action
 */
public interface ResourceListener {

	public void update(ResourceList resource);
}
