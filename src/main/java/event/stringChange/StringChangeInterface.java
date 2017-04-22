package event.stringChange;

import event.EventHandler;

public interface StringChangeInterface<SUBJECT_TYPE> {
	
	public void changeString(String newString);
	public EventHandler<StringChangeEvent<SUBJECT_TYPE>> getStringChangeEvent();
	
}
