package it.polimi.ingsw.ps11.model.events;

import java.io.Serializable;
import java.util.ArrayList;
/** <h3> EventHandler<PARAMETER_TYPE> </h3>
 * <p> Classe per l'organizzazione degli eventi, con una lista dei listener. Modifica dell'Observable nel relativo pattern.</p>
 */
public class EventHandler<PARAMETER_TYPE> implements Serializable {
	
	protected ArrayList<EventListener<PARAMETER_TYPE>> eventListeners = new ArrayList<>();

	public synchronized void attach(EventListener<PARAMETER_TYPE> eventListener) {
		eventListeners.add(eventListener);
	}

	public synchronized void detach(EventListener<PARAMETER_TYPE> eventListener) {
		eventListeners.remove(eventListener);
	}

	public synchronized void invoke(PARAMETER_TYPE parameter) {		
		for(int i = 0; i < eventListeners.size(); i++){
			eventListeners.get(i).handle(parameter);
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		EventHandler<PARAMETER_TYPE> clone = new EventHandler<>();
		clone.eventListeners = (ArrayList<EventListener<PARAMETER_TYPE>>) this.eventListeners.clone();
		return clone;
	}
}