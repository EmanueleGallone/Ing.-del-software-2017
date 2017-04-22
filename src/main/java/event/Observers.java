package event;

public interface Observers<EVENTO_INVOCATO> {
	
	public void handle(EVENTO_INVOCATO event);
}
