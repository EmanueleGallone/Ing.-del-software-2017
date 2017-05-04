package event;

public interface Observer<PARAMETER_TYPE> {
	
	public void handle(PARAMETER_TYPE parameter);
}
