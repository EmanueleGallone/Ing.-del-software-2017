package it.polimi.ingsw.ps11.cranio.game.actions;

public interface ActionVisitor {
	
	public void visit(GetCard getCard);
	public void visit(ChangeTurn changeTurn);
}
