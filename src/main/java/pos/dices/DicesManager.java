package pos.dices;

import java.util.HashMap;
import java.util.Map;

import pos.familyMembers.Colors;

public class DicesManager {

	private Map<Colors, Dice> dices = new HashMap<>();
	
	public DicesManager() {
		for(Colors color: Colors.values()){
			dices.put(color, new Dice(color));
		}
	}
	
	public Dice getDice(Colors color){
		return dices.get(color);
	}
	
}