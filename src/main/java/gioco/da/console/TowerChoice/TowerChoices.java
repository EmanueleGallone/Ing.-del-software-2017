package gioco.da.console.TowerChoice;

import java.util.Scanner;

import gioco.da.console.Player;
import it.polimi.ingsw.resources.FamilyMember;

public abstract class TowerChoices {
	
	protected void checkPositionValue(FamilyMember familyChoice, int value, Player player){
		Scanner in = new Scanner(System.in);
		String choice;
		boolean retry = true;
		
		while(retry){
			
			if(familyChoice.getValue() < value){
				System.out.println("Attenzione! il valore del familiare non è sufficiente! vuoi usare i servitori? (s/n) ");
				choice = in.next();
				
				if(choice.equalsIgnoreCase("n")){
					return;
				}
				
				if(choice.equalsIgnoreCase("s")){
					player.useServant(familyChoice);
					retry = false;
				}
				
				if(familyChoice.getValue() < value){
					System.out.println("valore di family: " +  familyChoice.getValue());
					retry = true;
				}
							
			}
			else{
				retry = false;
			}
		}
		
		return;
		
	}

}
