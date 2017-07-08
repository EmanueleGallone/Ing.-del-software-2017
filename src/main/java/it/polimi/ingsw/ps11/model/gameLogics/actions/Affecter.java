package it.polimi.ingsw.ps11.model.gameLogics.actions;

/**
 * <h3> Affecter </h3>
 * <p> Interfaccia che rappreseta i bonus permanenti, modificano le <code>Action</code> a cui sono collegate.</p>
 * @see Action
 */
public interface Affecter<T extends Action> {
	
	public String target();
	public T affect(T action);
	
}
