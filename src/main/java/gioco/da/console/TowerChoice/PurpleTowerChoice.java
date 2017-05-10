package gioco.da.console.TowerChoice;

import java.util.InputMismatchException;
import java.util.Scanner;

import gioco.da.console.Board;
import gioco.da.console.Player;
import gioco.da.console.resources.FamilyMember;

public class PurpleTowerChoice extends TowerChoices {
		//non credo sia corretto usare solo il costruttore
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
					
					if(board.getPurpleTower().getCard(temp-1) == null)
						System.err.println("Carta già presa!");	
					
					else
					checkExc = false;
					
				} catch (InputMismatchException e) {
					System.err.println("errore nella selezione! riprova\n");
				}
			}//end of checkExc
			
			int shift = temp-1; //uso lo shift per non far inserire 0!
			boolean ritenta = true; //condizione per ciclare il check dei value dei posti azione. DA MODIFICARE! si useranno gli Spazi Azione
			
			switch (temp) { 
			
				case 1:
					
					while(ritenta){
						
						if(familyChoice.getValue() < board.getPurpleTower().getFirstPositionValue() ){ //non sono soddisfatto. come faccio questo controllo?
							checkPositionValue(familyChoice, board.getPurpleTower().getFirstPositionValue(), player);
							
							//retry = false; //testing per uscire dal ciclo
							//ATTENZIONE. se il giocatore ha 0 servitori diventa un DEADLOCK
						}
						else{
							ritenta = false; //non ritentare se il valore del familiare è uguale o superiore al posto Azione
							
							player.addCard(board.getPurpleTower().getCard(shift));
							
							player.changeResourceValue(board.getPurpleTower().getResourceActionSpace(shift),
									board.getPurpleTower().getResourceActionSpace(shift).getValue()); //se presenti, aggiungo le risorse di quell'action space al giocatore.
															//troppo lungo. definire metodi intermedi? p.s. funziona. per vedere usa lo shift
							
							System.out.println("Carta 1 Aggiunta al deck!");
							board.getPurpleTower().takeCard(shift,familyChoice); //la take card setta quel posto nella List a null! evitando così tutto lo shift
							retry = false;
						}
					}
					break;
					
				case 2:
					
					while(ritenta){
						
						if(familyChoice.getValue() < board.getPurpleTower().getSecondPositionValue()) //se il valore del familiare è < del valore dello spazio azione, fai un checkpositionvalue()
							checkPositionValue(familyChoice, board.getPurpleTower().getSecondPositionValue(), player);
						
						else{
							
							checkPositionValue(familyChoice, board.getPurpleTower().getSecondPositionValue(), player);
							
							player.addCard(board.getPurpleTower().getCard(shift));
							
							System.out.println("Carta 2 Aggiunta al deck!");
							
							board.getPurpleTower().takeCard(shift,familyChoice);
							
							retry = false;
							ritenta = false;
						}
					}
					break;
					
				case 3://da aggiornare
					checkPositionValue(familyChoice, board.getPurpleTower().getThirdPositionValue(), player);
					player.addCard(board.getPurpleTower().getCard(shift));
					System.out.println("Carta 3 Aggiunta al deck!");
					board.getPurpleTower().takeCard(shift,familyChoice);
					
					player.changeResourceValue(board.getPurpleTower().getResourceActionSpace(shift),
							board.getPurpleTower().getResourceActionSpace(shift).getValue());
					
					retry = false;
					break;
					
				case 4://da aggiornare
					checkPositionValue(familyChoice, board.getPurpleTower().getFourthPositionValue(), player);
					player.addCard(board.getPurpleTower().getCard(shift));
					System.out.println("Carta 4 Aggiunta al deck!");
					
					board.getPurpleTower().takeCard(shift,familyChoice);
					
					player.changeResourceValue(board.getPurpleTower().getResourceActionSpace(shift),
							board.getPurpleTower().getResourceActionSpace(shift).getValue());
					
					retry = false;
					break;
		
				default:
					System.out.println("Errore nella scelta! riprova\n");
					retry = true;
					break;
				}//end of switch
			
		}//end of retry
	
	}

}//end of Class
