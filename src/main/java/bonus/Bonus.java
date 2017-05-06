package bonus;

public abstract class Bonus<TARGET_TYPE> {
	protected TARGET_TYPE target;
	
	public Bonus(TARGET_TYPE target) {
		this.target = target;
	}
	
	public abstract void behavior();
}
