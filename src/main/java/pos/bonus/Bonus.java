package pos.bonus;

public abstract class Bonus<SUBJECT_TYPE,PARAMETER> {
	
	protected SUBJECT_TYPE subjects;
	
//Start constructor
	
	public Bonus(SUBJECT_TYPE subject) {
		this.subjects = subject;
	}

//End constructor
	
	public abstract void behavior(PARAMETER paramenter);
}
