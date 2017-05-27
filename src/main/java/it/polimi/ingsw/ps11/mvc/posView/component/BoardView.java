package it.polimi.ingsw.ps11.mvc.posView.component;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.posView.TextualComponent;

public class BoardView implements TextualComponent{
	
	@Override
	public void print() {
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	public void printTowers(ArrayList<Tower> towers){
		
		Console console = new Console();
		int i = towers.get(0).getMaxFloors();
		
		for(int c = 0; c < i ; c++){
			
		}
		
	}
	
}
