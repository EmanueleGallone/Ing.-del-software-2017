package gioco.da.console.TowerChoice;

import java.util.Scanner;

import gioco.da.console.Player;
import it.polimi.ingsw.resources.FamilyMember;

public abstract class TowerChoices {
	//ATTENZIONE: LA TORRE VIOLA È QUELLA CHE VIENE AGGIORNATA. 
	//se i cambiamenti sono positivi, allora si aggiornano le altre torre.
	//PurpleTowerChoice
	
	protected void checkPositionValue(FamilyMember familyChoice, int value, Player player){
		Scanner in = new Scanner(System.in);
		String choice;
		boolean retry = true;
		
		while(retry){
			
			if(familyChoice.getValue() < value){
				System.out.println("Attenzione! il valore del familiare non è sufficiente! vuoi usare i servitori? (s/n) ");
				choice = in.next();
				
				if(choice.equalsIgnoreCase("n")){
					return; //devo annullare l'azione. spetterebbe al chiamante. come faccio?
				}
				
				if(choice.equalsIgnoreCase("s")){
					player.useServant(familyChoice);
					retry = false;
				}
				
				if(familyChoice.getValue() < value){ //per debug
					System.out.println("valore di family: " +  familyChoice.getValue() + "\n");
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
