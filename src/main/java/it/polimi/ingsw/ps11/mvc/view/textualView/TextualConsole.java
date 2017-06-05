package it.polimi.ingsw.ps11.mvc.view.textualView;

import java.util.Scanner;

import it.polimi.ingsw.ps11.mvc.view.viewGenerica.components.Console;

public class TextualConsole extends Console{
	
	@Override
	public void print(String message){
		System.out.println(message);
	}
	@Override
	public void printError(String message){
		System.err.println(message);
	}
	@Override
	public String read(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	@Override
	public String read(String message){
		print(message);
		return read();
	}
}
