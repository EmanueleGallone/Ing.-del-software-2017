package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class TextualResourceView extends ResourceView{

	public TextualResourceView() {
	
	}
	
	public TextualResourceView(ResourceList resourceList) {
		update(resourceList);
	}
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		for(Resource resource : resourceList)
			console.print(resource.getId() + ": " + resource.getValue() + " ");
		
	}

}
