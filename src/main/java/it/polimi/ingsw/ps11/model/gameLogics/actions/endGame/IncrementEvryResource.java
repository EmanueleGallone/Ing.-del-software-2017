package it.polimi.ingsw.ps11.model.gameLogics.actions.endGame;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedManager;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>IncrementEveryResource</h3>
 * <p> Classe che rappresenta l'azione che aggiunge un punto vittoria durente l'End Game ogni cinque risorse rimaste ad
 * un giocatore (coin, wood, stone e servant).</p>
 * @see NeedManager
 */
public class IncrementEvryResource implements  NeedManager{
	
	private int value = 1;
	private ActionManager aManager;
	private ArrayList<String> target = new ArrayList<>();
	private Resource resourceToAdd;
	
	public IncrementEvryResource(ActionManager aManager, int value, Resource increment) {
		this.aManager = aManager;
		if(value!=0)
			this.value = value;
		resourceToAdd = increment;
	}
	
	public void addTarget(String resource){
		this.target.add(resource);
	}
	
	@Override
	public void setManager(ActionManager aManager) {
		this.aManager = aManager;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		ResourceList playerResource = aManager.state().getPlayer().getResourceList();
		int totalPoint,sum=0;
		for(Resource resource : playerResource){
			if(target.contains(resource.getId()))
				sum = sum + resource.getValue();
		}
		
		totalPoint = sum/value;
		ResourceList toAdd = new ResourceList();
		resourceToAdd.setValue(resourceToAdd.getValue() * totalPoint);
		toAdd.setResource(resourceToAdd);
		playerResource.sum(toAdd);
	}

}
