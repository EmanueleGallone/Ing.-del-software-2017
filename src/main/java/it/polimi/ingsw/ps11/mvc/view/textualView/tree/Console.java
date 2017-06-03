package it.polimi.ingsw.ps11.mvc.view.textualView.tree;

import java.util.Scanner;

public class Console {
	
	public void print(String message){
		System.out.println(message);
	}

	public void printError(String message){
		System.err.println(message);
	}
	
	public String read(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public String read(String message){
		print(message);
		return read();
	}
}
