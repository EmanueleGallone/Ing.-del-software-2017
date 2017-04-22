package event.increment;

import event.Observers;
import it.polimi.ingsw.resources.Resource;

public class IncrementObserver implements Observers<IncrementEvent<Resource>> {

	@Override
	public void handle(IncrementEvent<Resource> event) {
	 System.out.println("Classe: " + event.getSubject().getClass() + " mi ha passato: " + event.getValue());
	}

}
