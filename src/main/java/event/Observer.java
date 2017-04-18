package event;

public class Observer implements Observers {

	@Override
	public void preEventUpdate(Events event) {
		System.out.println("sono l'observer!");
		
	}

	@Override
	public void postEventUpdate(Events event) {
		System.out.println("sempre io, observer!");
		
	}

}
