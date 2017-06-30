package it.polimi.ingsw.ps11.model.loaders;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.zones.Board;
/** <h3> CardsLoader </h3>
 * <p> Classe usata per caricare le DevelopmentCard dai relativi file tramite path.</p>
 * @see DevelopmentCard
 */
public class CardsLoader extends Loader {
	
	private final static String DEFAULT_PATH = "";
	
	public CardsLoader() {
		super(DEFAULT_PATH);
	}
	
	public CardsLoader(String filePath) {
		super(filePath);
	}
	
	public ArrayList<DevelopmentCard> load() throws IOException{
		
		ArrayList<DevelopmentCard> cards = new ArrayList<>();
		ArrayList<String> testo = read();
		for(String string : testo){
			cards.add(deserializeCard(string));
		}
		return cards;
	}

	public DevelopmentCard deserializeCard(String card){
		return null;
	}
	
}
