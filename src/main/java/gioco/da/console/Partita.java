package gioco.da.console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import it.polimi.ingsw.resources.BlackFamilyMember;
import it.polimi.ingsw.resources.FamilyMember;
import it.polimi.ingsw.resources.NeutralFamilyMember;
import it.polimi.ingsw.resources.OrangeFamilyMember;
import it.polimi.ingsw.resources.WhiteFamilyMember;

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
			p.setOrangeFamilyMemberValue(board.getYellowDiceValue());
			p.setWhiteFamilyMemberValue(board.getWhiteDiceValue());
		}//end update values of family members
		
	}
	
	//MAIN FUNCTION
	public void Turno(){
		int choice=1;
		
		
		for(period = 1; period<=MAX_PERIOD; period++){
			for(turn = 1; turn<=MAX_TURN; turn++){
				
				System.out.println("Periodo: " + period + "\t\t\tTURNO " + turn + " \n");
				nuovoTurno();
				
				//giocatori = sortingPlayer(); //dà problemi
				for(int i = 0; i<giocatori.size();i++){ //sono abbastanza sicuro che andrebbe messo nel controller questo for
					boolean retry = true;
					
					while(retry){
					
						System.out.println("\n-Giocatore "+(i+1));
						choice = menuChoice();
										
						switch (choice) {
						
						case 1:
							board.activateProduction(giocatori.get(i));
							retry = false;
							break;
						case 2:
							board.activateHarvest(giocatori.get(i));
							retry = false;
							break;
							
						case 3: 
							sceltaCartaGiocatore(giocatori.get(i));
							retry = false;
							break;
								
						case 4: //palazzo del consiglio
							board.cambiaPosizioni(giocatori.get(i));
							retry = false;
							break;
						
						case 5: 
							System.out.println(giocatori.get(i).toString());
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
		//metodo troppo lungo. è da spezzare in sotto metodi
		boolean retry = true;
		int temp = 1;
		Scanner in;
		FamilyMember familyChoice = new BlackFamilyMember(); //inizializzo perchè il compilatore altrimenti mi dà problemi
		
			while (retry){
				boolean exc = true;
				
				while(exc){ // scelta familiare
					System.out.println("Quale familiare vuoi usare?");
					System.out.println("1. Nero (Valore: " + board.getBlackDiceValue() + ")");
					System.out.println("2. Arancione (Valore: " + board.getYellowDiceValue() + ")");
					System.out.println("3. Neutro (Valore 0)");
					System.out.println("4. Bianco (Valore: " + board.getWhiteDiceValue() + ")");
					try {
						in = new Scanner(System.in);
						temp = in.nextInt();
						exc = false;
						
					} catch (InputMismatchException e) {
						System.err.println("Errore nella selezione! riprova\n");
					}
				}
				
				switch (temp) {
				case 1:
					familyChoice = new BlackFamilyMember();
					familyChoice.setValue(board.getBlackDiceValue());
					player.getBlackFamilyMember().setIsUsed(true); //dico che il familiare del giocatore è stato usato
					break;
					
				case 2:
					familyChoice = new OrangeFamilyMember();
					familyChoice.setValue(board.getYellowDiceValue());
					player.getOrangeFamilyMember().setIsUsed(true);
					break;
				case 3:
					familyChoice = new NeutralFamilyMember();
					player.getNeutralFamilyMember();
					break;
				case 4:
					familyChoice = new WhiteFamilyMember();
					player.getWhiteFamilyMember().setIsUsed(true);
					break;

				default:
					System.err.println("Qualcosa è andato storto nella scelta del familiare!");
					break;
				} //fine statement per scelta familiare
				
				cardChoice(familyChoice,player);
				
				retry = false;
			}// end of while(retry)
			
	}// end of sceltaGiocatore()
	
	//firstPosition Player. devo implementare un Comparator e fare un sorting dei giocatori in base alla loro posizione.
	public int checkFirstPosition(){
		Iterator<Player> it = giocatori.iterator();
		
		int min = 4;
		
		while(it.hasNext()){
			
			if(min > it.next().getPosition() )
				min = it.next().getPosition();
		}
		
		return min;
		
	}//end of checkFirstPosition
	
	public int menuChoice(){
		final int MAX_CHOICES = 5;
		Scanner input;
		int choice = 1;
		boolean retry = true;
		boolean exc = true;
		
		while(retry){
			
			while(exc){
				try {
					input = new Scanner(System.in);
					System.out.println("Cose che puoi fare: \n");
					System.out.println("1. Zona Produzione");
					System.out.println("2. Zona raccolta");
					System.out.println("3. prendi una carta");
					System.out.println("4 Palazzo del Consiglio");
					System.out.println("5 Stampa il tuo status");
					
					choice = input.nextInt();
					exc = false;
				
				} catch (InputMismatchException e) {
					System.err.println("errore nella scelta! riprova\n");
				}
			}//end of while(exc) preventing entering not a number
			
			//checking if the value is correct
			if( (choice <=MAX_CHOICES) && (choice >=1) ){
				retry = false;
				System.out.println("perfetto");
			}
			
		}//end of while(retry)
		
		return choice;
	
	}//end menuChoice
	
	private void cardChoice(FamilyMember familyChoice,Player player){
		boolean exc = true;
		boolean retry = true;
		Scanner in;
		int temp=1; //inizializzo altrimenti il compilatore mi dà problemi
		
			while(retry){
				
				while(exc){
					System.out.println("Inserisci quale carta prendere: ");
					try {
						in = new Scanner(System.in);
						temp = in.nextInt();
						exc = false;
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
						}
						else{
							player.addCard(board.getCard(shift));
							System.out.println("Carta 1 Aggiunta al deck del giocatore= "+player.toString());
							board.removeCard(shift); //la remove card setta quel posto nella List a null! evitando così tutto lo shift
							retry = false;
							}
						break;
						
					case 2:
						player.addCard(board.getCard(shift));
						System.out.println("Carta 2 Aggiunta al deck del giocatore= "+player.toString());
						board.removeCard(shift);
						retry = false;
						break;
						
					case 3:
						player.addCard(board.getCard(shift));
						System.out.println("Carta 3 Aggiunta al deck del giocatore= "+player.toString());
						board.removeCard(shift);
						retry = false;
						break;
						
					case 4:
						player.addCard(board.getCard(shift));
						System.out.println("Carta 4 Aggiunta al deck del giocatore= "+player.toString());
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
	
	//da abbandonare quando si userà il comparator.
		public ArrayList<Player> sortingPlayer(){
			//non funziona
			ArrayList<Player> sorted = new ArrayList<>();
			int min = 1;
			
			for(Player p : giocatori){
				
				if(p.getPosition() == min){
					sorted.add(p);
					min++;
				}
			}
			
			return sorted;
		}
		
		//dove e come va implementato?
		/*{Collections.sort(giocatori, new Comparator<Player>() {
			
		    @Override
		    public int compare(Player p1, Player p2)
		    {
		    	Integer i = p1.getPosition();
		    	Integer j = p2.getPosition();

		        return  i.compareTo(j);
		    }
		});}*/
	
	

}//end of Class


