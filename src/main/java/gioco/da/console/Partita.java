package gioco.da.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import gioco.da.console.TowerChoice.BlueTowerChoice;
import gioco.da.console.TowerChoice.GreenTowerChoice;
import gioco.da.console.TowerChoice.PurpleTowerChoice;
import gioco.da.console.TowerChoice.YellowTowerChoice;
import it.polimi.ingsw.resources.BlackFamilyMember;
import it.polimi.ingsw.resources.FamilyMember;

public class Partita {
	
	/*
	 * cose da fare: fare un check del familiare posizionato sulla casella; per ogni torre ovviamente.
	 */
	
	private final int MAX_TURN = 2;
	private final int MAX_PERIOD = 3;
	
	private Board board;
	
	private ArrayList<Player> giocatori;
	
	private int turn;
	private int period;
	
	
	public Partita(ArrayList<Player> listaGiocatori) {
		giocatori = listaGiocatori;
		board = new Board();
		this.turn = 1;
		this.period = 1;
	}

	@Override
	public String toString() {
		return "Partita [board=" + board + "\nGiocatori= "+giocatori.toString() + "]";
	}
	
	private void nuovoTurno(){
		board.rollDices();
		
		//update dei familyMember for each of the players
		for(Player p : giocatori){
			p.setBlackFamilyMemberValue(board.getBlackDiceValue());
			p.getBlackFamilyMember().setIsUsed(false);
			
			p.setOrangeFamilyMemberValue(board.getOrangeDiceValue());
			p.getOrangeFamilyMember().setIsUsed(false);
			
			p.setWhiteFamilyMemberValue(board.getWhiteDiceValue());
			p.getWhiteFamilyMember().setIsUsed(false);
			
			p.getNeutralFamilyMember().setIsUsed(false);
		}//end update values of family members
		
	}
	
	//MAIN FUNCTION
	public void Turno(){
		int choice=1;
		
		//troppo annidamento. c'è un modo per risolvere?
		
		
		for(period = 1; period<=MAX_PERIOD; period++){
			for(turn = 1; turn<=MAX_TURN; turn++){
				
				System.out.println("Periodo: " + period + "\t\t\tTURNO " + turn + " \n");
				nuovoTurno();
				
				Collections.sort(giocatori); //sorting in base alla posizione!
				
				for(int i = 0; i<giocatori.size();i++){ 
					boolean retry = true;
					
					while(retry){
					
						System.out.println("\n-Giocatore "+(i+1));
						choice = menuChoice();
										
						switch (choice) {
						
						case 1:
							if(!board.hasProductionZoneOccupied()){
								board.activateProduction(giocatori.get(i));
								retry = !giocatori.get(i).allFamilyisUsed(); //se ho usato tutti i familiari, esco dal ciclo while
							}
							else
								System.out.println("la zona di raccolta è già occupata!");
							
							break;
							
						case 2:
							if(!board.hasHarvestZoneOccupied()){
								board.activateHarvest(giocatori.get(i));
								retry = !giocatori.get(i).allFamilyisUsed();
							}
							else
								System.out.println("la zona produzione è già occupata!");
							
							break;
							
						case 3: 
							sceltaTorre(giocatori.get(i));
							retry = !giocatori.get(i).allFamilyisUsed();
							break;
								
						case 4: //palazzo del consiglio
							board.cambiaPosizioni(giocatori.get(i));
							retry = !giocatori.get(i).allFamilyisUsed();
							break;
						
						case 5: 
							System.out.println(giocatori.get(i).toString());
							break;
						
						case 6:
							System.out.println("Hai passato il tuo turno \n");
							retry = false;
							break;
		
						default:
							System.out.println("qualcosa è andato storto!");
							retry = false;
							break;
						}//end of switch
					
					}//end while(retry)
				
				}//end for each player
				
			}// end for(turn)
			
			//finito il periodo si cambiano le carta sulla board. ne creo una nuova
			
			this.board = new Board(period);
			
		}//end for(period)	
		
	}
	
	private int TowerChoice(){
		Scanner in;
		int temp = 0;
		boolean retry = true;
		
		while(retry){
			try {
				in = new Scanner(System.in);
				
				System.out.println("Quale torre scegli");
				System.out.println("1. Torre Gialla");
				System.out.println("2. Torre Blu");
				System.out.println("3. Torre Verde");
				System.out.println("4. Torre Viola");
				temp = in.nextInt();
				
				if(temp >= 1 && temp <=4)
					retry = false;
				else
					System.err.println("Inserisci un valore ammissibile\n");
				
			} catch (InputMismatchException e) {
				System.err.println("errore nella scelta");
			}
		}
		
		return temp;
		
		
	}
	
	//in questo metodo faccio scegliere la torre
	private void sceltaTorre(Player player){
		int choice;
		FamilyMember familyChoice = new BlackFamilyMember(); //inizializzo perchè il compilatore altrimenti mi dà problemi. poi testo se posso toglierlo
		
		choice = TowerChoice();
		
		switch(choice){
			case 1:		
				familyChoice = player.familiarChoice();			
				new YellowTowerChoice(player,familyChoice,this.board);
				break;
			
			case 2:
				familyChoice = player.familiarChoice();
				new BlueTowerChoice(player,familyChoice,this.board);
				break;
				
			case 3:
				familyChoice = player.familiarChoice();
				new GreenTowerChoice(player,familyChoice,this.board);
				break;
				
			case 4:
				familyChoice = player.familiarChoice();
				new PurpleTowerChoice(player,familyChoice,this.board);
				break;
			
			default:
				System.err.println("qualcosa è andato storto nella selezione della torre!");
				break;
		}
		
			
	}
	
	public int menuChoice(){
		final int MAX_CHOICES = 6;
		Scanner input;
		int choice = 1;
		boolean retry = true;
		boolean checkExc = true;
		
		while(retry){
			
			while(checkExc){
				try {
					input = new Scanner(System.in);
					
					System.out.println("Cose che puoi fare: \n");
					System.out.println("1. Zona Produzione");
					System.out.println("2. Zona raccolta");
					System.out.println("3. prendi una carta");
					System.out.println("4 Palazzo del Consiglio");
					System.out.println("5 Stampa il tuo status");
					System.out.println("6 Passa il tuo turno");
					
					choice = input.nextInt();
					
					checkExc = false;
				
				} catch (InputMismatchException e) {
					System.err.println("errore nella scelta! riprova\n");
				}
			}
			
			//checking if the value is correct
			if( (choice <=MAX_CHOICES) && (choice >=1) ){
				retry = false;
				System.out.println("perfetto");
			}
			
		}//end of while(retry)
		
		return choice;
	
	}
		
	private void checkPositionValue(FamilyMember familyChoice, int value, Player player){
		// spostato su TowerChoices
		Scanner in = new Scanner(System.in);
		String choice = "n";
		
		if(familyChoice.getValue() < value){
			System.out.println("Attenzione! il valore del familiare non è sufficiente! vuoi usare i servitori? (s/n) ");
			in.next();
			
			if(choice.equalsIgnoreCase("s")){
				player.useServant(familyChoice);
			}
			
			else if(choice.equalsIgnoreCase("n"))
				return;
			
			else
				return;
			
		}
		
		else
			return;
		
		
		
	}

}//end of Class


