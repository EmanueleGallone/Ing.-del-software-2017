package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.view.textualView.Input;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseFamilyView;
/**
 * <h3> TextualChooseFamilyView</h3>
 * <p> Classe per la visualizzazione testuale dei familiari dei giocatori, con i relativi valori e l'input per la scelta su quale
 * utilizzare</p>
 * @see ChooseFamilyView
 */
public class TextualChooseFamilyView extends ChooseFamilyView implements EventListener<String>{
	
	private Input input;
	
	public TextualChooseFamilyView() {
		
	}
	
	public TextualChooseFamilyView(Input input, FamilyMemberManager familyMemberManager, EventHandler<ViewEventInterface> viewEvent) {
		update(familyMemberManager);
		this.input = input;
		this.eventHandler = viewEvent;
	}
	
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		int i = 1; 
		for(FamilyMember member : familyManager.getFamily().values()){
			if(!member.isUsed())
				console.print("\n "+i+") " + member.getId() + " value: "+ member.getValue());
			i++;
		}
		console.println("");
	}

	@Override
	public void handle(String e) {
		int parsed;
		ArrayList<FamilyMember> family = new ArrayList<>(familyManager.getFamily().values());
		try {
			parsed = Integer.parseInt(e);
			parsed--;
			if(parsed <= family.size() && parsed >= 0){
				eventHandler.invoke(new FamilySelectedEvent(family.get(parsed).getId()));
			}
				
		} catch (NumberFormatException e1) {
			new TextualConsole().println("No family member selected");
		}finally{
			input.detach(this);
		}
	}

}
