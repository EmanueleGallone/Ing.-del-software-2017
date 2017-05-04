package event;

public interface Observers<PARAMETER> {
	
	public void handle(PARAMETER event);
}
