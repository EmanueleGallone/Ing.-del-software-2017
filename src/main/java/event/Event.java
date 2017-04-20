package event;

import java.util.ArrayList;
import java.util.Set;

public class Event<E> implements Events{

	protected ArrayList<Observers> observersList = new ArrayList<>();
	protected E subject; //Oggetto osservabile al quale è attaccato l'evento in questione
	
	public Event(E subject){
		this.subject = subject;		
	}
	
	public void setSubject(E subject){
		this.subject = subject;		
	}
	
	@Override
	public synchronized E getSubject() {
		return this.subject;
	}
	
	@Override
	public synchronized void attach(Observers observer) {
		observersList.add(observer);
	}

	@Override
	public void detach(Observers observer) {
		observersList.remove(observer);
	}

	@Override
	public void preEventNotify() {
		for(Observers observer: observersList ){
			observer.preEventUpdate(this);
		}
	}

	@Override
	public void postEventNotify() {
		for(Observers observer: observersList ){
			observer.postEventUpdate(this);
		}
	}
}
