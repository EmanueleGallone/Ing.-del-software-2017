package event;

public interface Decrementable extends Observable {
	
	abstract void decrease(int value);
	abstract Event DecrementEvent();
}
