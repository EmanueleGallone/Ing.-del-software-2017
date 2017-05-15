package it.polimi.ingsw.ps11.mvc;

import it.polimi.ingsw.ps11.mvc.controller.Controller;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class Mvc {
	
	public static void main(String[] args){
		
		TextualView view = new TextualView();
		Model model = new Model();
		
		Controller controller = new Controller(model, view);
		
		view.start();
	}
	
}
