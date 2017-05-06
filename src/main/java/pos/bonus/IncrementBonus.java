package pos.bonus;

import pos.interfaceList.Incrementable;

public class IncrementBonus extends Bonus<Incrementable> {

	private int value;
	
	public IncrementBonus(Incrementable subject,int value) {
		super(subject);
		this.value = value;
	}
	
	@Override
	public void behavior() {
		subjects.increment(value);
	}
	
}
