package event.list.increment;


public class IncrementEvent {
	
	private int value;
	
	public IncrementEvent(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
