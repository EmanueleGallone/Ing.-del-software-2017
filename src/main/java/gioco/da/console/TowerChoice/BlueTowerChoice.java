package gioco.da.console.TowerChoice;

import java.util.InputMismatchException;
import java.util.Scanner;

import gioco.da.console.Board;
import gioco.da.console.Player;
import gioco.da.console.resources.FamilyMember;


public class BlueTowerChoice extends TowerChoices {
	
	public BlueTowerChoice(Player player,FamilyMember familyChoice,Board board){
		//uso queste classi per spezzare la classe Partita! troppe righe di codice
		
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
					
					if(board.getBlueTower().getCard(temp-1) == null){
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
					if(familyChoice.getValue() < board.getBlueTower().getFirstPositionValue() ){ //ATTENZIONE. da cambiare
						System.out.println("ATTENZIONE: il valore del familiare non supera quello della casella scelta\n vuoi usare i servitori?");
						//AACHTUNG: implementare l'uso dei servitori per aumentare il valore del familiare.
						retry = false; //testing
					}
					else{
						player.addCard(board.getBlueTower().getCard(shift));
						System.out.println("Carta 1 Aggiunta al deck!");
						board.getBlueTower().takeCard(shift,familyChoice); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
						retry = false;
					}
					break;
					
				case 2:
					player.addCard(board.getBlueTower().getCard(shift));
					System.out.println("Carta 2 Aggiunta al deck!");
					board.getBlueTower().takeCard(shift,familyChoice);
					retry = false;
					break;
					
				case 3:
					player.addCard(board.getBlueTower().getCard(shift));
					System.out.println("Carta 3 Aggiunta al deck!");
					board.getBlueTower().takeCard(shift,familyChoice);
					retry = false;
					break;
					
				case 4:
					player.addCard(board.getBlueTower().getCard(shift));
					System.out.println("Carta 4 Aggiunta al deck!");
					board.getBlueTower().takeCard(shift,familyChoice);
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
