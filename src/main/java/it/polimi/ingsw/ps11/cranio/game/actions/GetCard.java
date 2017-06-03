package it.polimi.ingsw.ps11.cranio.game.actions;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class GetCard implements Action {

	private Player player;
	private DevelopmentCard card;
	private ResourceList cost; //Se la carta ha piu' di un costo, bisogna specificare quale va pagato
	
	public GetCard(Player player, DevelopmentCard card) {
		this.player = player;
		this.card = card;
	}
	
	public GetCard(Player player, DevelopmentCard card, ResourceList cost) {
		this.player = player;
		this.card = card;
		this.cost = cost;
	}
	
	
	//Se non è stato settato nessun costo in particolare, viene selezionato il primo costo soddisfacibile 
	@Override
	public void perform() {
		if (cost == null){
			for(ResourceList cost : card.getCosts()){
				if(player.getResourceList().greaterEquals(cost)){
					this.cost = cost;
					break;
				}
			}
		}
		if(card.getCosts().contains(cost)){//Questo if serve principalmente nel caso in cui il costo sia passato da fuori
			player.getResourceList().subtract(cost);
			player.getCardManager().addCard(card);
		}
	}

	
	/***
	 * Ritorna true se almeno uno dei costi della carta e' inferiore alle risorse del player
	 */
	@Override
	public boolean isLegal() {
		for(ResourceList cost : card.getCosts()){
			if(player.getResourceList().greaterEquals(cost))
				return true;
		}
		return false;
	}

	@Override
	public void accept(ActionVisitor visitor) {
		visitor.visit(this);
	}

}
