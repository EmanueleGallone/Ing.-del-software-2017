package event.list;

import event.Event;
import event.observer.list.MalusDecrementaValue;

public class Esempio implements Incrementable {
	public int value = 0;
	private Event<Integer> incrementEvent = new Event<>();
	
	
	@Override
	public void increment(Integer v){
		incrementEvent.invoke(v);
		value += v;
	}
	
	@Override
	public Event<Integer> getIncrementEvent() {
		return this.incrementEvent;
	}
	
	public static void main (String[] args){
		
		Esempio es = new Esempio();
		
		MalusDecrementaValue m = new MalusDecrementaValue(es);
		m.attivati();
		
		es.increment(5);
		System.out.println(es.value);
	}


}
