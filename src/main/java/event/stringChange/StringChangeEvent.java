package event.stringChange;

import event.Event;

public class StringChangeEvent<SUBJECT_TYPE> extends Event<SUBJECT_TYPE>{

	protected String nuovoValore;
	public StringChangeEvent(SUBJECT_TYPE subject,String nV) {
		super(subject);
		nuovoValore = nV;
	}

	public String getNuovoValore(){
		return nuovoValore;
	}
	
	
}
