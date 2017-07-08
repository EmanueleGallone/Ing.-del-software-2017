package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;
/**
 * <h3>TextualTowerView</h3>
 * <p> Classe che permette la stampa a schermo di una torre. Al suo interno si avranno 4 FloorView, ovvero 1 per ogni piano.</p>
 */
public class TextualTowerView extends TowerView {

	public TextualTowerView(String towername) {
		super(towername);
		for(int i = 0; i < TOWERNUMBER; i++)
			floorViews.add(new TextualFloorView(towerName, i));
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println(towerName + "\n");
		for(FloorView f : floorViews){
			f.print();
		}
	}
	
}
