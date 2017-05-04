package event.observer.list;

import event.GenericObserver;
import event.list.Incrementable;

public class MalusDecrementaValue extends GenericObserver<Incrementable, Integer> {

	public MalusDecrementaValue(Incrementable subject) {
		super(subject);
	}

	@Override
	public void handle(Integer parameter) {
		if (parameter > 0)
			subject.increment(-1);
	}

	@Override
	public void attivati() {
		subject.getIncrementEvent().attach(this);
	}

	@Override
	public void disattivati() {
		subject.getIncrementEvent().detach(this);
	}

}
