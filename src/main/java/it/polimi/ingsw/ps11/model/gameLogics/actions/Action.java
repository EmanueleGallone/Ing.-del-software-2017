package it.polimi.ingsw.ps11.model.gameLogics.actions;

/**
 * <h3> Action </h3>
 * <p> Interfaccia che rappresenta l'azione di gioco: contiene <p>isLegal(),</p> <p>perform(),</p> <p>clone().</p>
 */
public interface Action {

	public boolean isLegal();
	public void perform();
	public default String name(){
		return this.getClass().toString();
	}
	//public Action clone();
}
