package event;

public interface Mutable {
	abstract void observChangeEvent(Observers observer);
	abstract void deobservChangeEvent(Observers observer);
}
