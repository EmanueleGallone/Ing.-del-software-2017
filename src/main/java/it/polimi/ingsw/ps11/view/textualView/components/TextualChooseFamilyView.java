package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseFamilyView;

public class TextualChooseFamilyView extends ChooseFamilyView implements EventListener<String>{
	
	private EventHandler<ViewEventInterface> events;
	private Input input;
	
	public TextualChooseFamilyView() {
		
	}
	
	public TextualChooseFamilyView(Input input, FamilyMemberManager familyMemberManager, EventHandler<ViewEventInterface> viewEvent) {
		update(familyMemberManager);
	}
	
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		int i = 1; 
		for(FamilyMember member : familyView.getFamily().values()){
			console.print("\n "+i+") " + member.getClass().getSimpleName() + " value: "+ member.getValue());
		}
		console.println("");
	}

	@Override
	public void handle(String e) {
		int parsed;
		ArrayList<FamilyMember> family = new ArrayList<>(familyView.getFamily().values());
		try {
			parsed = Integer.parseInt(e);
			if((parsed +1) <= family.size() && parsed > 0){
				events.invoke(new FamilySelectedEvent(family.get(parsed).getClass()));
			}
				
		} catch (NumberFormatException e1) {
			new TextualConsole().println("Choice not valid!");
		}finally{
			input.detach(this);
		}
	}

}
