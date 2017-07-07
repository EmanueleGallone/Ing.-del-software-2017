package it.polimi.ingsw.ps11.model.loaders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import it.polimi.ingsw.ps11.model.JsonAdapter;

public class Loader {
	
	private String path;
	
	public Loader(String path) {
		this.path = path;
	}

	public <T> T load(Class<T> returnType) throws FileNotFoundException,ClassCastException{
		FileReader reader = new FileReader(path);
		return new JsonAdapter().fromJson(reader, returnType);
	}
	
	public <T> T load(Type type) throws FileNotFoundException,ClassCastException{
		FileReader reader = new FileReader(path);
		return new JsonAdapter().fromJson(reader, type);
	}
	
	public void write(Object object){
		write(new JsonAdapter().toJson(object));
	}
	
	public void write(Object object, Type type){
		write(new JsonAdapter().toJson(object,type));
	}
	
	public void write(String text){
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(text);
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
	
	
	public String read(){
		return read(path);
	}
	
	public static String read(String path){
		
		BufferedReader reader = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine())!= null) {
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			System.err.println("File not Found!\n");
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
		
		return stringBuilder.toString();
	}
	
}
