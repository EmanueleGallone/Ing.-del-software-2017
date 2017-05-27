package it.polimi.ingsw.ps11.mvc.posView.component;

import java.util.Scanner;

import it.polimi.ingsw.ps11.mvc.posView.QuitGameException;

public class Console {
	
	public String read() throws QuitGameException {
		String input = new Scanner(System.in).nextLine();
		if (input.equals("quit"))
			throw new QuitGameException("Game Quit");
		return input;
	}
	
	public String read(String message) throws QuitGameException{
		print(message);
		return read();
	}
	
	public void print (String message){
		System.out.println(message);
	}
	
	public void printError(String message){
		System.err.println(message);
	}
	
}
