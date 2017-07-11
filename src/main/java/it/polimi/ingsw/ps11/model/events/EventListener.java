package it.polimi.ingsw.ps11.model.events;
/** <h3> EventListener<EVENT> </h3>
 * <p> Classe per la gestione degli eventi. Modifica dell'Observer nel relativo pattern. </p>
 */
public interface EventListener<EVENT> {
	
	public abstract void handle(EVENT e);
}
