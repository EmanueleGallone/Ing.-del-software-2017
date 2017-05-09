package pos.bonus;

import pos.events.EventListener;
import pos.interfaceList.Incrementable;

public class IncrementBonus extends Bonus<Incrementable,Void> implements EventListener<Void> {

	private int value;
	
	public IncrementBonus(Incrementable subject,int value) {
		super(subject);
		this.value = value;
	}
	
	@Override
	public void behavior(Void parameter) {
		subjects.increment(value,false);
		System.out.println("Ho incrementato di " + this.value);
	}

	@Override
	public void handle(Void event) {
		behavior(event);
	}
	
}
