package it.polimi.ingsw.ps11.model.bonus.ema.malus.thirdPeriod;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.bonus.ema.malus.Excommunication;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

public class YellowCardCostsSubVP extends Excommunication {
	
	public YellowCardCostsSubVP(Player player) {
		this.owner = player;
		setPeriod(3);
	}

	@Override
	public void behaviour() {
		int counter = 0;
		
		
		
		ArrayList<YellowCard> list = owner.getCardManager().getCardList(YellowCard.class);
		
		for(YellowCard card : list)
			for(int index = 0; index < card.getCosts().size(); index++)
				for(Resource resource : card.getCosts().get(index))
					counter = counter + resource.getValue();
		
		//a questo punto dovrei avere il conteggio totale di tutti i costi di qualsiasi risorsa
	
	ResourceList resourceList = new ResourceList();
	resourceList.setResource(new VictoryPoint(counter));
	
	owner.getResourceList().subtract(resourceList);

	}
}
