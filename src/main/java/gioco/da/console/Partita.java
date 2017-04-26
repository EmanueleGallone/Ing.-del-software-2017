package gioco.da.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			p.setOrangeFamilyMemberValue(board.getOrangeDiceValue());
			p.setWhiteFamilyMemberValue(board.getWhiteDiceValue());
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
							board.activateProduction(giocatori.get(i));
							retry = !giocatori.get(i).allFamilyisUsed();
							break;
						case 2:
							board.activateHarvest(giocatori.get(i));
							retry = !giocatori.get(i).allFamilyisUsed();
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
	
	//in questo metodo aggiungo la carta scelta al mazzo del giocatore e rimuovo la carta dalla board. Mancano i check sui requisiti
	private void sceltaCartaGiocatore(Player player){
		
		FamilyMember familyChoice; //inizializzo perchè il compilatore altrimenti mi dà problemi
		
			familyChoice = player.familiarChoice();
			
			cardChoice(familyChoice,player);
			
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
	
	}//end menuChoice
	
	private void cardChoice(FamilyMember familyChoice,Player player){
		boolean checkExc = true;
		boolean retry = true;
		Scanner in;
		int temp=1; //inizializzo altrimenti il compilatore mi dà problemi
		
			while(retry){
				checkExc = true; //bisogna inserirlo qui altrimenti in caso di scelta della carta diversa tra 1 e 4 non entra nel while(checkExc)
				
				while(checkExc){
					
					System.out.println("Inserisci quale carta prendere: ");
					
					try {
						
						in = new Scanner(System.in);
						temp = in.nextInt();
						checkExc = false;
						
					} catch (InputMismatchException e) {
						System.err.println("errore nella selezione! riprova\n");
					}
				}
				
				//uso lo shift perchè così non faccio inserire la posizione 0 da console. Brutto cominciare a contare da 0 per il giocatore!
				int shift = temp-1;
				
				switch (temp) { //per il momento uso solo la YellowTower! poi va ovviamente esteso.
					case 1:
						if(familyChoice.getValue() < board.getYellowTower().getFirstPosition() ){
							System.out.println("ATTENZIONE: il valore del familiare non supera quello della casella scelta\n vuoi usare i servitori?");
							//AACHTUNG: implementare l'uso dei servitori per aumentare il valore del familiare.
							retry = false; //testing
						}
						else{
							player.addCard(board.getCard(shift));
							System.out.println("Carta 1 Aggiunta al deck!");
							board.removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
							retry = false;
						}
						break;
						
					case 2:
						player.addCard(board.getCard(shift));
						System.out.println("Carta 2 Aggiunta al deck!");
						board.removeCard(shift);
						retry = false;
						break;
						
					case 3:
						player.addCard(board.getCard(shift));
						System.out.println("Carta 3 Aggiunta al deck!");
						board.removeCard(shift);
						retry = false;
						break;
						
					case 4:
						player.addCard(board.getCard(shift));
						System.out.println("Carta 4 Aggiunta al deck!");
						board.removeCard(shift);
						retry = false;
						break;
			
					default:
						System.out.println("Errore nella scelta! riprova\n");
						retry = true;
						break;
					}//end of switch
				
			}//end of while(retry)
			
	}//end of cardChoice()	
	
	
	

}//end of Class


