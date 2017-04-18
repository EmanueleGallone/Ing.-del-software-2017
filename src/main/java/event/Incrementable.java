package event;

public interface Incrementable extends Observable{
	
	abstract void increment(int value);
	abstract void observIncrementEvent(Observers observer);
	abstract void deobservIncrementEvent(Observers observer);
}
