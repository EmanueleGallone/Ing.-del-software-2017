package it.polimi.ingsw.ps11.mvc.posView.component.io;

import java.util.Scanner;

public class Console {
	
	public String read(){
		return new Scanner(System.in).nextLine();
	}

	public String read(String message){
		print(message);
		return read();
	}
	
	public void print (String message){
		System.out.println(message);
	}
	
}
