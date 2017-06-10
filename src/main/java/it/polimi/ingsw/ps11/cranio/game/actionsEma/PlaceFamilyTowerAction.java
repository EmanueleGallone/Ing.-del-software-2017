package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.bonus.DecrementCostBonus;
import it.polimi.ingsw.ps11.cranio.bonus.FamilyMemberBonus;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class PlaceFamilyTowerAction extends Action {
	
	private Tower torreScelta;
	private Player player;
	private FamilyMember familyMember;
	
	public PlaceFamilyTowerAction(Tower torreScelta, Player player) {
		this.torreScelta = torreScelta;
		this.player = player;
	}
	
	public PlaceFamilyTowerAction() {
		//vuoto nel caso mi servisse solo la perform();
	}

	@Override
	public void perform() {
		//sarebbe la perform normale. Dovrei aggiungere del codice per vedere se il giocatore ha un bonus legato alla torre scelta
		//se ce l'ha, attiva il bonus

	}

	@Override
	public boolean isLegal() {
		//che faccio? quale è un controllo generico? se nella torre non vi è già un familiare proprio?
		return false;
	}
	
	public void perform(DecrementCostBonus bonus){
		//andrebbe controllato che il bonus si attiva solo quando viene scelta la stessa torre presente nel bonus
		//e controllata che la risorsa da decrementare sia effettivamente nella carta di quella torre		
		
	}
	
	public void perform(FamilyMemberBonus bonus){
		if(torreScelta == bonus.getTower()) //scorretto? forse vuole l'equals?
			familyMember.setModifier(bonus.getValue());
	}
	
	public void setTorreScelta(Tower torreScelta) {
		this.torreScelta = torreScelta;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}

}
