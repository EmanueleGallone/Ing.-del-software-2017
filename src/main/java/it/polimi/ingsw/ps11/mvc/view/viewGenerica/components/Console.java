package it.polimi.ingsw.ps11.mvc.view.viewGenerica.components;

public abstract class Console {

	public abstract void print(String message);
	public abstract void printError(String message);
	public abstract String read();
	public abstract String read(String message);
}
