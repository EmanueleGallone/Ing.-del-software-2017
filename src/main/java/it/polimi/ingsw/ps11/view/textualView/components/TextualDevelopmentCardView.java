package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;
/**
 * <h3> TextualDevelopmentCardView</h3>
 * <p> Classe per la visualizzazione testuale </p>
 * @see View
 */
public class TextualDevelopmentCardView extends DevelopmentCardView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		TextualResourceView resourceView = new TextualResourceView();
		
		if(developmentCard.getName() != null){
			console.println(developmentCard.getName()); //nome del tipo delle carte
			
			console.print("Costi: ");
			int i = developmentCard.getCosts().size() -1;//necessario per la stampa dell'OR
			for(ResourceList resourceList : developmentCard.getCosts()) {
				
				
				resourceView.update(resourceList);
				resourceView.print();
				
				if(i != 0){
					//stampo un OR in caso vi fossero piu' risorse
					console.print("OR ");
					i--;
				}
			}
		}
	}
}
