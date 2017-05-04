package pos.Resources;

public class Resource {
	
	private static final int DEFAULT_VALUE = 0;
	private static final int MINIMUM_VALUE = 0;
	protected int value;
	
	public Resource(){
		this.value=DEFAULT_VALUE;
	}
	
	public Resource(int value){
		this.value = value;
	}
	
	public  int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		if (this.value < MINIMUM_VALUE)
			this.value = MINIMUM_VALUE;
		else 
		    this.value = value;
	}
	
	@Override
	public String toString() {
		return "Resource [value=" + value + "]";
	}

	public void increment(int value) {
		setValue(this.value + value);
	}
}
