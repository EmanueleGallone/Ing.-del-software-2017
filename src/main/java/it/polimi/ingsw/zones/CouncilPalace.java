package it.polimi.ingsw.zones;

import java.util.InputMismatchException;
import java.util.Scanner;

import gioco.da.console.Player;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Servant;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.Wood;

public class CouncilPalace extends Zone {
	private final int MAX_CHOICES = 4;
	
	private static int position = 1;
	private Resource resource;
	
	public CouncilPalace(){
		position = 1;
	}
	
	public void activate (Player player){
		player.setPosition(position);
		position++; //è da vedere come impostare le posizioni per tutti gli altri player
		
		choice();
		
		player.changeResourceValue(resource, resource.getValue()); //aggiungo la risorsa scelta al giocatore
		player.changeResourceValue(new Coin(), 1); //viene aggiunta la moneta! come da tabellone
	}
	
	private void choice(){
		//faccio scegliere la risorsa da aggiungere al proprio inventario
		 
		boolean retry = true;
		int temp=1;
		Scanner in;
		
		while(retry){
		
			try {
				in = new Scanner(System.in);
				System.out.println("Scegli quale risorsa accettare tra:");
				System.out.println("1. 2xPietra");
				System.out.println("2. 2xLegname");
				System.out.println("3. 2xMonete");
				System.out.println("4. 2xServitori");
				//System.out.println("5. 1xPrivilegio del consiglio (non so se sia giusto!)");
				temp = in.nextInt();
				
				switch (temp) {
				case 1:
					resource = new Stone();
					resource.setValue(2);
					break;
				case 2:
					resource = new Wood();
					resource.setValue(2);
					break;
				case 3:
					resource = new Coin();
					resource.setValue(2);
					break;
				case 4:
					resource = new Servant();
					resource.setValue(2);
					break;
				/*case 5:
					resource = new CouncilPrivilege(); //probabilmente non serve. faccio scegliere direttamente la risorsa, no?
					resource.setValue(1);
					break;*/

				default:
					System.out.println("Errore; valore non riconosciuto");
					break;
					
						
				}//end of switch
					
				if( temp>=1 && temp<=MAX_CHOICES ){
					retry = false;
				}
				
				
				
			} catch (InputMismatchException e) {
				System.err.println("Errore. Scegli tra l'elenco \n");
			}
			
			
				
			
		}//end of while(retry)

	}//end of choice()

}
