package event;

public interface Decrementable extends Observable {
	
	abstract void decrease(int value);
	abstract void observDecreaseEvent(Observers observer);
	abstract void deobservDecreaseEvent(Observers observer);
}
