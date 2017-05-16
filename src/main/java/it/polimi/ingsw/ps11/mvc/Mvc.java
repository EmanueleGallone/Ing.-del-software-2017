package it.polimi.ingsw.ps11.mvc;

import it.polimi.ingsw.ps11.cranio.bonus.istant.GetAnotherCard;
import it.polimi.ingsw.ps11.mvc.controller.Controller;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class Mvc {
	
	public static void main(String[] args){
		
		TextualView view = new TextualView();
		Model model = new Model();
		
		GetAnotherCard bonus = new GetAnotherCard(5);
		
		Controller controller = new Controller(model, view);
		
		bonus.behavior();
		//view.start();
	}
	
}
