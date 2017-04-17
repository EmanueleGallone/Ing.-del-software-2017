package event;

/*
 * Define an object that can be activated
 */

public interface Activable extends Observable{

	abstract void active();
	abstract void observActiveEvent(Observers observer);
	abstract void deobservActiveEvent(Observers observer);
}
