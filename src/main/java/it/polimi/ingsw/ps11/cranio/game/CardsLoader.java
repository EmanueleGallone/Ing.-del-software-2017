package it.polimi.ingsw.ps11.cranio.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.game.loaders.Loader;

public class CardsLoader extends Loader{

	private final static String DEFAULT_PATH = "";
	
	/*public CardsLoader() {
		super(DEFAULT_PATH);
	}
	
	public CardsLoader(String filePath) {
		super(filePath);
	}*/
	
	public ArrayList<DevelopmentCard> load() throws IOException {
		BufferedReader reader = null;
		ArrayList<DevelopmentCard> cards = new ArrayList<>();
		try{
			reader = new BufferedReader(new FileReader(DEFAULT_PATH));
			String line;
			
			while((line = reader.readLine()) != null){
				 cards.add(deserializeCard(line));
			}
		}
		finally {
			if (reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cards;
	}

	public DevelopmentCard deserializeCard(String card){
		return null;
	}
	
}
