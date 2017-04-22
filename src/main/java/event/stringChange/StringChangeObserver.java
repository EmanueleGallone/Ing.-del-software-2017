package event.stringChange;

import event.Observers;
import it.polimi.ingsw.resources.Resource;

public class StringChangeObserver implements Observers<StringChangeEvent<Resource>> {

	@Override
	public void handle(StringChangeEvent<Resource> parameter) {
		System.out.println("Questa classe: " + parameter.getSubject() + " ha cambiato stringa in: " + parameter.getNuovoValore());
	}

}
