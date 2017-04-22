package prove;

import java.util.ArrayList;

public class ResourceTemp {
	
	private int value = 0;
	private ArrayList<BonusTemp> bonusList = new ArrayList<>();
	
	public void setValue(int val){
		
		int temp = value;
		for(BonusTemp bonus : bonusList){
			temp += bonus.modifier; 
		}
		value = val;
	}
	
}
