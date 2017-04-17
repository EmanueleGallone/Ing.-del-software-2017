package event;

public interface Increasable extends Observable{
	
	abstract void increase(int vale);
	abstract void observIncreaseEvent(Observers observer);
	abstract void deobservIncreaseEvent(Observers observer);
}
