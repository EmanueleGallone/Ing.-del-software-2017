package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseFamilyView;

public class TextualChooseFamilyView extends ChooseFamilyView {
	//faccio la print che fa scegliere e poi chiama la selected che crea l'evento?
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		String familyChoice = "Choose a Familiar: " 
				+ "\n1: White "
				+ "\n2: Orange"
				+ "\n3: Black"
				+ "\n4: Neutral"
				+ "\n"
				;
			console.print(familyChoice + "(Press 0 to Cancel the action)\n");
			String choice = console.read();
			
			switch (choice) {
			case "1":
				//lancia il FamilySelectedEvent?
				break;
			case "2":
				//lancia il FamilySelectedEvent?
				break;
			case "3":
				//lancia il FamilySelectedEvent?
				break;
			case "4":
				//lancia il FamilySelectedEvent?
				break;
				
			case "0":
				return;

			default:
				System.err.println("Unknown command.");
				break;
			} 
		
	}

}
