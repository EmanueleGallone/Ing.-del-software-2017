package gioco.da.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import it.polimi.ingsw.resources.BlackFamilyMember;
import it.polimi.ingsw.resources.FamilyMember;

public class Partita {
	
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
							sceltaCartaGiocatore(giocatori.get(i));
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
			
		}//end period for	
		
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
	
	//in questo metodo aggiungo la carta scelta al mazzo del giocatore e rimuovo la carta dalla board. Mancano i check sui requisiti
	private void sceltaCartaGiocatore(Player player){
		int choice;
		FamilyMember familyChoice = new BlackFamilyMember(); //inizializzo perchè il compilatore altrimenti mi dà problemi
		
		choice = TowerChoice();
		//procedo solo con la torre gialla per testing. poi estendo
		switch(choice){
			case 1:		
				familyChoice = player.familiarChoice();			
				YellowTowerChoice(player,familyChoice);
				break;
			
			case 2:
				familyChoice = player.familiarChoice();
				BlueTowerChoice(player,familyChoice);
				break;
			
			default:
				System.err.println("sono nella selezione della torre. qualcosa è andato storto!");
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
	
	private void YellowTowerChoice(Player player,FamilyMember familyChoice){
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
					
					
					if(familyChoice.getValue() < board.getYellowTower().getFirstPositionValue() ){
						System.out.println("ATTENZIONE: il valore del familiare non supera quello della casella scelta\n vuoi usare i servitori?");
						//AACHTUNG: implementare l'uso dei servitori per aumentare il valore del familiare.
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
					System.out.println("Errore nella scelta! riprova\n");
					retry = true;
					break;
				}//end of switch
			
		}//end of retry
		
	} 
	
	private void BlueTowerChoice(Player player,FamilyMember familyChoice){
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
						board.getBlueTower().removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
						retry = false;
					}
					break;
					
				case 2:
					player.addCard(board.getBlueTower().getCard(shift));
					System.out.println("Carta 2 Aggiunta al deck!");
					board.getBlueTower().removeCard(shift);
					retry = false;
					break;
					
				case 3:
					player.addCard(board.getBlueTower().getCard(shift));
					System.out.println("Carta 3 Aggiunta al deck!");
					board.getBlueTower().removeCard(shift);
					retry = false;
					break;
					
				case 4:
					player.addCard(board.getBlueTower().getCard(shift));
					System.out.println("Carta 4 Aggiunta al deck!");
					board.getBlueTower().removeCard(shift);
					retry = false;
					break;
		
				default:
					System.out.println("Errore nella scelta! riprova\n");
					retry = true;
					break;
				}//end of switch
			
		}//end of retry
		
	}
	
	private void PurpleTowerChoice(Player player,FamilyMember familyChoice){
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
					
					checkExc = false;
					
				} catch (InputMismatchException e) {
					System.err.println("errore nella selezione! riprova\n");
				}
			}//end of checkExc
			
			int shift = temp-1;
			
			switch (temp) { 
				case 1:
					if(familyChoice.getValue() < board.getPurpleTower().getFirstPositionValue() ){ //ATTENZIONE. da cambiare
						System.out.println("ATTENZIONE: il valore del familiare non supera quello della casella scelta\n vuoi usare i servitori?");
						//AACHTUNG: implementare l'uso dei servitori per aumentare il valore del familiare.
						retry = false; //testing
					}
					else{
						player.addCard(board.getPurpleTower().getCard(shift));
						System.out.println("Carta 1 Aggiunta al deck!");
						board.getPurpleTower().removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
						retry = false;
					}
					break;
					
				case 2:
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
	
	private void GreenTowerChoice(Player player,FamilyMember familyChoice){
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
					
					checkExc = false;
					
				} catch (InputMismatchException e) {
					System.err.println("errore nella selezione! riprova\n");
				}
			}//end of checkExc
			
			int shift = temp-1;
			
			switch (temp) { 
				case 1:
					if(familyChoice.getValue() < board.getGreenTower().getFirstPositionValue() ){ //ATTENZIONE. da cambiare
						System.out.println("ATTENZIONE: il valore del familiare non supera quello della casella scelta\n vuoi usare i servitori?");
						//AACHTUNG: implementare l'uso dei servitori per aumentare il valore del familiare.
						retry = false; //testing
					}
					else{
						player.addCard(board.getGreenTower().getCard(shift));
						System.out.println("Carta 1 Aggiunta al deck!");
						board.getGreenTower().removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
						retry = false;
					}
					break;
					
				case 2:
					player.addCard(board.getGreenTower().getCard(shift));
					System.out.println("Carta 2 Aggiunta al deck!");
					board.getGreenTower().removeCard(shift);
					retry = false;
					break;
					
				case 3:
					player.addCard(board.getGreenTower().getCard(shift));
					System.out.println("Carta 3 Aggiunta al deck!");
					board.getGreenTower().removeCard(shift);
					retry = false;
					break;
					
				case 4:
					player.addCard(board.getGreenTower().getCard(shift));
					System.out.println("Carta 4 Aggiunta al deck!");
					board.getGreenTower().removeCard(shift);
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


