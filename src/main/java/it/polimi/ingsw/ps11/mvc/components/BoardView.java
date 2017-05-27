package it.polimi.ingsw.ps11.mvc.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class BoardView implements TextualComponent{

	
	@Override
	public <T> void print(T arg) {
		if(Board.class == arg.getClass()){
			Console console = new Console();
			Board board = (Board) arg;
			ArrayList<Tower> towers = board.getTowers();
			
			for(int i=Tower.getMaxFloors()-1; i >= 0 ;i--){
				String out = new String();
				
				for(Tower tower : towers){
					out += tower.getFloors().get(i).toString()+"\t";
				}
				console.print(out);
			}
		}
	}

	@Override
	public void selected() {
		// TODO Auto-generated method stub
		
	}
}
