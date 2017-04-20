package event;

/*
 * Define an object that can be activated
 */

public interface Activable extends Observable{

	abstract void active();
	abstract Event ActiveEvent();
}
