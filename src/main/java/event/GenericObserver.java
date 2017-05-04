package event;

public abstract class GenericObserver<SUBJECT_TYPE,PARAMETER_TYPE> implements Observer<PARAMETER_TYPE> {
	
	protected SUBJECT_TYPE subject;
	
	Observer<PARAMETER_TYPE> osservatore = new Observer<PARAMETER_TYPE>() {
		@Override
		public void handle(PARAMETER_TYPE parameter) {
			handle(parameter);
		}
	};
	
	public abstract void attivati();
	public abstract void disattivati();
	
	public GenericObserver(SUBJECT_TYPE subject){
		this.subject = subject;
	}
	
}
