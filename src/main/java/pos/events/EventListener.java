package pos.events;

public interface EventListener<EVENT> {
	
	public abstract void handle(EVENT event);
}
