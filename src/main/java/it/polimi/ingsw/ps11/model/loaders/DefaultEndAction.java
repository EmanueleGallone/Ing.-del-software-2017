package it.polimi.ingsw.ps11.model.loaders;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.endGame.IncrementEvryResource;
import it.polimi.ingsw.ps11.model.gameLogics.actions.endGame.PointByCardAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
/**
 * <h3> State </h3>
 * <p> Classe che inizializza le azioni base di fine partita.</p> 
 */
public class DefaultEndAction {

	public static void main(String[] args) throws FileNotFoundException, ClassCastException {
		//initializeDefaultAction();
	}
	
	
	public static void initializeDefaultAction(){
		
		ArrayList<NeedManager> doAtTheEnd = new ArrayList<>();
		
		HashMap<Integer, ResourceList> territories = new HashMap<>();
		
		territories.put(3, new ResourceList(new VictoryPoint(1)));
		territories.put(4, new ResourceList(new VictoryPoint(4)));
		territories.put(5, new ResourceList(new VictoryPoint(10)));
		territories.put(6, new ResourceList(new VictoryPoint(20)));
		
		PointByCardAction terrAction = new PointByCardAction(null, new GreenCard().getId(), territories);
		
		
		HashMap<Integer, ResourceList> bluCard = new HashMap<>();
		
		bluCard.put(1, new ResourceList(new VictoryPoint(1)));
		bluCard.put(2, new ResourceList(new VictoryPoint(3)));
		bluCard.put(3, new ResourceList(new VictoryPoint(6)));
		bluCard.put(4, new ResourceList(new VictoryPoint(10)));
		bluCard.put(5, new ResourceList(new VictoryPoint(15)));
		bluCard.put(6, new ResourceList(new VictoryPoint(21)));
		
		PointByCardAction bluAction = new PointByCardAction(null, new BlueCard().getId(), bluCard);
		
		
		IncrementEvryResource incrementEvryResource = new IncrementEvryResource(null, 5, new VictoryPoint(1));
		incrementEvryResource.addTarget(new Wood().getId());
		incrementEvryResource.addTarget(new Stone().getId());
		incrementEvryResource.addTarget(new Coin().getId());
		incrementEvryResource.addTarget(new Servant().getId());
		
		
		doAtTheEnd.add(terrAction);
		doAtTheEnd.add(bluAction);
		doAtTheEnd.add(incrementEvryResource);
		
		Type type = new TypeToken<ArrayList<NeedManager>>(){}.getType();
		new Loader(FileRegistry.endActions).write(doAtTheEnd,type);
		
	}
}
