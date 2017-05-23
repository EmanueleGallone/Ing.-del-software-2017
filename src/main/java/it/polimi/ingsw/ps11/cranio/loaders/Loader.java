package it.polimi.ingsw.ps11.cranio.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Loader {
	
	protected String filePath;
	
// Start constructors
	
	public Loader(String filePath) {
		this.filePath = filePath;
	}
	
// End constructors
	
// Start logics
	
	public abstract Object load() throws IOException;

	protected ArrayList<String> read() throws IOException{
		
		BufferedReader reader = null; 
		ArrayList<String> testo = new ArrayList<>();
		String line  = "";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null){
				testo.add(line);
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Errore nel loader");
			throw e;
		}
		finally{
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return testo;
	}
	
// End logics
}
