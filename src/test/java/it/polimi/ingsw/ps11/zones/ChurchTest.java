package it.polimi.ingsw.ps11.zones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.zones.Church;

public class ChurchTest {

	@Test
	public void test() {
		Excommunication e1 = new Excommunication("1", 1);
		Excommunication e2 = new Excommunication("2", 2);
		Excommunication e3 = new Excommunication("3", 3);
		ArrayList<Excommunication> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Church church = new Church(list);
		church.addRewards(1, new ResourceList(new VictoryPoint(1)));
	}

}
