package it.polimi.ingsw.ps11.cranio.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;

public class CardsLoader {

	public CardManager load(String filePath) throws IOException {
		BufferedReader reader = null;
		CardManager cardManager = new CardManager();
		try{
			reader = new BufferedReader(new FileReader(filePath));
			String line;
			
			while((line = reader.readLine()) != null){
				cardManager.deserializeCard(line);
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
		return cardManager;
	}

}
