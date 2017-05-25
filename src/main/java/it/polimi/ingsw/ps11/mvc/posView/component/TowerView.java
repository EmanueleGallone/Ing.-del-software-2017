package it.polimi.ingsw.ps11.mvc.posView.component;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.posView.component.io.Console;

public class TowerView {

	public String scegliTorre(ArrayList<Tower> towers){
		printTowers(towers);
		System.out.println("Scegli la torre ");
		return new Console().read();
	}
	
	public void printTowers(ArrayList<Tower> towers){
		for(Tower tower: towers){
			new Console().print(tower.toString());
		}
	}
	
	public void printTower(Tower tower){
		System.out.println("Tower: " + tower.getClass());
		for(Floor floor : tower.getFloors()){
			System.out.println(floor.getCard());
		}
	}
	
	public String scegliCarta(Tower tower){
		printTower(tower);
		return new Console().read("Scegli quale carta prendere (da 1 a 4) :");
	}
	
}
