package it.polimi.ingsw.ps11.view.textualView;

import java.util.Scanner;

import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;

public class TextualConsole extends Console{
	
	@Override
	public void println(String message){
		System.out.println(message);
	}
	@Override
	public void print(String message) {
		System.out.print(message);
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
		println(message);
		return read();
	}
	
	public String printSpace(int number){
		if(number > 0)
			return new String(new char[number]).replaceAll("\0", " ");
		return new String(" ");
	}
}
