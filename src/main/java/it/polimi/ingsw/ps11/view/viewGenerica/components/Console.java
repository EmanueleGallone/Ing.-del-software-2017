package it.polimi.ingsw.ps11.view.viewGenerica.components;

public abstract class Console {

	public abstract void println(String message);
	public abstract void print(String message);
	public abstract void printError(String message);
	public abstract String read();
	public abstract String read(String message);
}
