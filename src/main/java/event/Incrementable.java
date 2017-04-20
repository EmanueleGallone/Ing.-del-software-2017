package event;

public interface Incrementable extends Observable{
	
	abstract void increment(int value);
	abstract Event IncrementEvent();
}
