package event;

public interface Observers {
	
	/*
	 * All'observer viene passato come parametro l'oggetto "event" che è stato invocato
	 * nel qualche è contenuto l'oggetto "subject" al quale era attaccato, recuperabile
	 * tramite la funzione "getSubject"
	 */
	
	abstract void preEventUpdate(Observable event);
	abstract void postEventUpdate(Observable event);
}
