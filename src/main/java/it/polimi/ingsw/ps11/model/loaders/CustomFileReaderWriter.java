package it.polimi.ingsw.ps11.model.loaders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileReaderWriter {
	
	String path;
	
	public CustomFileReaderWriter(String path) {
		this.path = path;
	}
	
	public String readFile(){
		
		BufferedReader reader = null;
		String testo = new String();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine())!= null) {
				testo = testo + line;
			}
		} catch (IOException e) {
			System.err.println("File not Found!\n");
		}
		finally {
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
	
	public static String readFile(String fileName){
		
		BufferedReader reader = null;
		String testo = new String();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine())!= null) {
				testo = testo + line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
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
	
	public void writeFile(String testo){
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(testo);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void writeFile(String fileName, String testo){
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(testo);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
