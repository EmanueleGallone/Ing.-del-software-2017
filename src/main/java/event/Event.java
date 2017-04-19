package event;

import java.util.ArrayList;

public class Event implements Events{

	protected ArrayList<Observers> observersList = new ArrayList<>();
	protected Observable subject; //Oggetto osservabile al quale è attaccato l'evento in questione
	
	public Event(){
		subject = null;
	}
	
	public Event(Observable subject){
		this.subject = subject;		
	}
	
	public void setSubject(Observable subject){
		this.subject = subject;		
	}
	
	@Override
	public void attach(Observers observer) {
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

	@Override
	public Observable getSubject() {
		return this.subject;
	}

}
