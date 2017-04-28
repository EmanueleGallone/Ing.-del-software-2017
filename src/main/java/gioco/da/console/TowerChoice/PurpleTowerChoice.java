package gioco.da.console.TowerChoice;

import java.util.InputMismatchException;
import java.util.Scanner;

import gioco.da.console.Board;
import gioco.da.console.Player;
import it.polimi.ingsw.resources.FamilyMember;

public class PurpleTowerChoice extends TowerChoices {
	
	public PurpleTowerChoice(Player player,FamilyMember familyChoice,Board board){
		Scanner in;
		int temp=1;
		boolean checkExc = true;
		boolean retry = true;
		
		while(retry){
			checkExc=true;
		
			while(checkExc){
				
				System.out.println("Inserisci quale carta prendere: ");
				
				try {
					
					in = new Scanner(System.in);
					temp = in.nextInt();
					if(board.getPurpleTower().getCard(temp-1) == null){
						System.err.println("Carta già in possesso di qualcun'altro!");
					}
					else
					checkExc = false;
					
				} catch (InputMismatchException e) {
					System.err.println("errore nella selezione! riprova\n");
				}
			}//end of checkExc
			
			int shift = temp-1;
			
			switch (temp) { 
				case 1:
					if(familyChoice.getValue() < board.getPurpleTower().getFirstPositionValue() ){ //ATTENZIONE. da cambiare
						checkPositionValue(familyChoice, board.getPurpleTower().getFirstPositionValue(), player);
						retry = false; //testing per uscire dal ciclo
					}
					else{
						player.addCard(board.getPurpleTower().getCard(shift));
						System.out.println("Carta 1 Aggiunta al deck!");
						board.getPurpleTower().removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
						retry = false;
					}
					break;
					
				case 2:
					checkPositionValue(familyChoice, board.getPurpleTower().getSecondPositionValue(), player);
					player.addCard(board.getPurpleTower().getCard(shift));
					System.out.println("Carta 2 Aggiunta al deck!");
					board.getPurpleTower().removeCard(shift);
					retry = false;
					break;
					
				case 3:
					player.addCard(board.getPurpleTower().getCard(shift));
					System.out.println("Carta 3 Aggiunta al deck!");
					board.getPurpleTower().removeCard(shift);
					retry = false;
					break;
					
				case 4:
					player.addCard(board.getPurpleTower().getCard(shift));
					System.out.println("Carta 4 Aggiunta al deck!");
					board.getPurpleTower().removeCard(shift);
					retry = false;
					break;
		
				default:
					System.out.println("Errore nella scelta! riprova\n");
					retry = true;
					break;
				}//end of switch
			
		}//end of retry
		
	}

}
