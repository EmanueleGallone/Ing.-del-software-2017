package it.polimi.ingsw.ps11.model.loaders;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
/**
 * <h3> State </h3>
 * <p> Classe che inizializza le personal tiles.</p> 
 */
public class DefaultTiles {

	public static void main(String[] args) {
		
		ArrayList<DevelopmentCard> cards = new ArrayList<>();
		
		YellowCard t1 = new YellowCard("t1");
		t1.addPermanentEffect(new AddResourceEffect(new ResourceList(new MilitaryPoint(1), new Coin(2))));
		t1.setActiveValue(1);
		
		GreenCard t11 = new GreenCard("t1");
		t11.addPermanentEffect(new AddResourceEffect(new ResourceList(new Wood(1), new Stone(1),new Servant(1))));
		t11.setActiveValue(1);
		//__________
		
		YellowCard t2 = new YellowCard("t2");
		t2.addPermanentEffect(new AddResourceEffect(new ResourceList(new Servant(2), new Coin(1))));
		t2.setActiveValue(1);
		
		GreenCard t22 = new GreenCard("t2");
		t22.addPermanentEffect(new AddResourceEffect(new ResourceList(new Wood(1), new Stone(1),new MilitaryPoint(1))));
		t22.setActiveValue(1);
		//__________
		
		YellowCard t3 = new YellowCard("t3");
		t3.addPermanentEffect(new AddResourceEffect(new ResourceList(new MilitaryPoint(2), new Coin(1))));
		t3.setActiveValue(1);
		
		GreenCard t33 = new GreenCard("t3");
		t33.addPermanentEffect(new AddResourceEffect(new ResourceList(new Wood(1), new Stone(1),new Servant(1))));
		t33.setActiveValue(1);
		//__________
		
		YellowCard t4 = new YellowCard("t4");
		t4.addPermanentEffect(new AddResourceEffect(new ResourceList(new Servant(1), new Coin(2))));
		t4.setActiveValue(1);
		
		GreenCard t44 = new GreenCard("t4");
		t44.addPermanentEffect(new AddResourceEffect(new ResourceList(new Wood(1), new Stone(1),new MilitaryPoint(1))));
		t44.setActiveValue(1);
		//__________

		YellowCard t5 = new YellowCard("t5");
		t5.addPermanentEffect(new AddResourceEffect(new ResourceList(new Servant(1), new MilitaryPoint(1))));
		t5.setActiveValue(1);
		
		GreenCard t55 = new GreenCard("t5");
		t55.addPermanentEffect(new AddResourceEffect(new ResourceList(new Wood(1), new Stone(1),new Coin(1))));
		t55.setActiveValue(1);
		
		cards.add(t1);
		cards.add(t11);
		
		cards.add(t2);
		cards.add(t22);
		
		cards.add(t3);
		cards.add(t33);
		
		cards.add(t4);
		cards.add(t44);
		
		cards.add(t5);
		cards.add(t55);
		
		
		Type type = new TypeToken<ArrayList<DevelopmentCard>>(){}.getType();
		new Loader(FileRegistry.default_tiles).write(cards,type);
	}
}
