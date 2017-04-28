package gioco.da.console.TowerChoice;

import java.util.InputMismatchException;
import java.util.Scanner;

import gioco.da.console.Board;
import gioco.da.console.Player;
import it.polimi.ingsw.resources.FamilyMember;

public class YellowTowerChoice extends TowerChoices {
	//uso queste classi per spezzare la classe Partita! troppe righe di codice
	//inizialmente erano metodi della classe Partita (e.g. : private void YellowTowerChoice(Player player, FamilyMember familyChoice)
	
	public YellowTowerChoice(Player player,FamilyMember familyChoice,Board board){
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
					
					if(board.getYellowTower().getCard(temp-1) == null){
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
					//provo ad applicare i nuovi cambiamenti solo sulla prima casella
					if(familyChoice.getValue() < board.getYellowTower().getFirstPositionValue() ){
						checkPositionValue(familyChoice, board.getYellowTower().getFirstPositionValue(), player);
						
						retry = false; //testing
					}
					else{
						player.addCard(board.getYellowTower().getCard(shift));
						System.out.println("Carta 1 Aggiunta al deck!");
						board.getYellowTower().removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
						retry = false;
					}
					break;
					
				case 2:
					player.addCard(board.getYellowTower().getCard(shift));
					System.out.println("Carta 2 Aggiunta al deck!");
					board.getYellowTower().removeCard(shift);
					retry = false;
					break;
					
				case 3:
					player.addCard(board.getYellowTower().getCard(shift));
					System.out.println("Carta 3 Aggiunta al deck!");
					board.getYellowTower().removeCard(shift);
					retry = false;
					break;
					
				case 4:
					player.addCard(board.getYellowTower().getCard(shift));
					System.out.println("Carta 4 Aggiunta al deck!");
					board.getYellowTower().removeCard(shift);
					retry = false;
					break;
		
				default:
					System.out.println("Errore nella scelta della carta! riprova\n");
					retry = true;
					break;
				}//end of switch
			
		}//end of retry
		
	} 

}
