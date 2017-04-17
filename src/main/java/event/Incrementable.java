package event;

public interface Incrementable extends Observable{
	
	abstract void increment(int vale);
	abstract void observIncrementEvent(Observers observer);
	abstract void deobservIncrementEvent(Observers observer);
}
