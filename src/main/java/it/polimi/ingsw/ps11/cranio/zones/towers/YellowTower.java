package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.cards.productionCard.YellowCard;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.carteGialle.Cappella;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.carteGialle.Residenze;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class YellowTower extends Tower {

	public YellowTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setValueOf(MilitaryPoint.class, 1);
		addFloor(new Floor(5, resource.clone()));
		resource.setValueOf(MilitaryPoint.class, 2);
		addFloor(new Floor(7, resource.clone()));
		
		selectFloor(0).setCard(new Residenze()); //setto per debug la carta "Residenze" al primo piano
		selectFloor(1).setCard(new Cappella());
		selectFloor(2).setCard(new YellowCard());
		selectFloor(3).setCard(new YellowCard());
	}
}
