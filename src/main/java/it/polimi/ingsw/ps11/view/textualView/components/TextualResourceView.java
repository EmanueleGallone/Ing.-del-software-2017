package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class TextualResourceView extends ResourceView{

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		for(Resource resource : resourceList){
			console.print(resource.getClass().getSimpleName() + " : " + resource.getValue() + "   ");
		}
		console.print("\n");
	}

}
