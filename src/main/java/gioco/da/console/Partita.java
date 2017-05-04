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
	 * solo su PurpleTowerChoice. poi se funziona tutto, si estende alle altre torri.
	 */
	
	private final int MAX_TURN = 2;
	private final int MAX_PERIOD = 3;
	
	private Board board;
	
	//private final Duration actionTimeout = Duration.ofSeconds(2); //devo impostare il timeout per azione da file. creerò un metodo
	
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
		//funziona perfettamente. NON TOCCARE
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
				
				Collections.sort(giocatori); //sorting in base alla posizione! usa il Compare dell'interfaccia Comparator usato su Player
				
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
							torreScelta(giocatori.get(i));
							retry = !giocatori.get(i).allFamilyisUsed();
							break;
								
						case 4: //palazzo del consiglio
							board.cambiaPosizioni(giocatori.get(i));
							retry = !giocatori.get(i).allFamilyisUsed();
							break;
							
						case 5:
							if(!board.hasCoinGeneratorOccupied()){
								board.activateCoinGen(giocatori.get(i));
								retry = !giocatori.get(i).allFamilyisUsed();
							}
							else
								System.out.println("Lo spazio monete del mercato è occupato!");
							break;
							
						case 6:
							if(!board.hasServantGeneratorOccupied()){
								board.activateServantGen(giocatori.get(i));
								retry = !giocatori.get(i).allFamilyisUsed();
							}
							else
								System.out.println("lo spazio servitori del mercato è occupato!");
							break;
						
						case 7: 
							System.out.println(giocatori.get(i).toString());
							break;
						
						case 8:
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
			
			//churchTurn(period); alla fine del for siamo al turno 2. si verificano i punti fede
			
			this.board = new Board(period); //finito il periodo si cambiano le carta sulla board. ne creo una nuova
			
		}//end for(period)	
		
		//endGame()
		
	}
	
	private int TowerChoice(){
		//funziona alla perfezione. NON TOCCARE
		Scanner in;
		int choice = 0;
		boolean retry = true;
		
		while(retry){
			try {
				in = new Scanner(System.in);
				
				System.out.println("Quale torre scegli");
				System.out.println("1. Torre Gialla");
				System.out.println("2. Torre Blu");
				System.out.println("3. Torre Verde");
				System.out.println("4. Torre Viola");
				
				choice = in.nextInt();
				
				if(choice >= 1 && choice <=4)
					retry = false;
				else
					System.err.println("Inserisci un valore ammissibile\n");
				
			} catch (InputMismatchException e) {
				System.err.println("errore nella scelta");
			}
		}
		
		return choice;
		
		
	}
	
	//in questo metodo faccio scegliere la torre
	private void torreScelta(Player player){
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
		final int MAX_CHOICES = 8;
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
					System.out.println("5 Mercato: +5 Monete");
					System.out.println("6 Mercato: +5 servitori");
					System.out.println("7 Stampa il tuo status");
					System.out.println("8 Passa il tuo turno");
					
					choice = input.nextInt();
					
					checkExc = false;
				
				} catch (InputMismatchException e) {
					System.err.println("errore nella scelta! riprova\n");
				}
			}
			
			//checking if the value is correct
			if( (choice <=MAX_CHOICES) && (choice >=1) ){
				retry = false;
				System.out.println("perfetto! hai scelto: "+ choice); //per debug
			}
			
		}//end of while(retry)
		
		return choice;
	
	}
	
	private void churchTurn(int period){
		//va invocato al secondo turno di ogni periodo. se i giocatori non hanno raggiunto
		//almeno i 3-4-5 punti fede, rispettivamente nel primo,secondo e terzo periodo
		
		switch (period){
		
		case 1:
			for(Player p : giocatori){
				if(p.getFaithPoints() < 3){
					//assegna una scomunica
				}
			}
			break;
			
		case 2:
			for(Player p : giocatori){
				if(p.getFaithPoints() < 4){
					//assegna una scomunica
				}
			}
			break;
			
		case 3:
			for(Player p : giocatori){
				if(p.getFaithPoints() < 5){
					//assegna una scomunica
				}
			}
			break;
			
		default:
			System.err.println("Qualcosa è andato storto nel metodo churchTurn");
			break;
			
		}
		
	}

}//end of Class


