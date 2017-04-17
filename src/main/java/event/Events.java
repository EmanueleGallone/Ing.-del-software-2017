package event;

public interface Events extends Observable {
	
	abstract void attach(Observers observer);
	abstract void detach(Observers observer);
	abstract void preEventNotify();
	abstract void postEventNotify();
	abstract Observable getSubject();
}
