package it.polimi.ingsw.ps11.model.familyMember;

import java.io.Serializable;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.dices.BlackDice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.dices.OrangeDice;
import it.polimi.ingsw.ps11.model.dices.WhiteDice;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
/**
 * <h3>FamilyMemberManager</h3>
 * <p> Classe Manager per i <code>FamilyMember</code>. Associa ad ogni tipo di familiare il familiare corrispondente. Uno per ogni giocatore.</p>
 * @see FamilyMember
 * @version 1.0
 */
public class FamilyMemberManager implements Serializable {
	
	private HashMap<String,FamilyMember> family = new HashMap<>();
	
	public FamilyMemberManager(){
		
		family.put(BlackFamilyMember.class.toString(), new BlackFamilyMember());
		family.put(WhiteFamilyMember.class.toString(), new WhiteFamilyMember());
		family.put(OrangeFamilyMember.class.toString(), new OrangeFamilyMember());
		family.put(NeutralFamilyMember.class.toString(), new NeutralFamilyMember());
	}
	
	public <T extends FamilyMember> T getFamilyMember(Class<T> familyMember){
		return getFamilyMember(familyMember.toString());
	}
	
	public <T extends FamilyMember> T getFamilyMember(String familyMember){
		return (T) this.family.get(familyMember.toString());
	}
		
	public <T extends FamilyMember> void setFamilyMember(T familyMember){
		this.family.put(familyMember.getClass().toString(), familyMember);
	}
	
	public HashMap<String, FamilyMember> getFamily(){
		return this.family;
	}
	
	public void setDices(DiceManager dices){
		getFamilyMember(BlackFamilyMember.class).setDice(dices.getDice(BlackDice.class));
		getFamilyMember(WhiteFamilyMember.class).setDice(dices.getDice(WhiteDice.class));
		getFamilyMember(OrangeFamilyMember.class).setDice(dices.getDice(OrangeDice.class));
	}
	
	@Override
	public FamilyMemberManager clone(){
		FamilyMemberManager clone = new FamilyMemberManager();
		
		for(FamilyMember f : this.family.values())
			clone.setFamilyMember(f.clone());
		
		return clone;
		
	}

}
