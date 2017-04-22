package event;

import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Stone;

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
