package it.polimi.ingsw.resources;

public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember(){
		super();
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	//the neutral family member always has 0 value
	public void setValue(int value) {
		this.value = 0;
		
	}

	@Override
	public String toString() {
		return "NeutralFamilyMember [value=" + value + "]";
	}

}
