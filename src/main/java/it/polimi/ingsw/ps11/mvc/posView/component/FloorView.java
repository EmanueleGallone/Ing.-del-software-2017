package it.polimi.ingsw.ps11.mvc.posView.component;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.mvc.posView.TextualComponent;
import it.polimi.ingsw.ps11.mvc.posView.events.TextualViewEvent;

public class FloorView implements TextualComponent  {

	private String selectedMenu = "Vuoi prendere la carta? [y/n]";
	private Floor floor ;
	
	
	EventHandler<TextualViewEvent<FloorView>> takeCardEvent = new EventHandler<>();
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	public void update(Floor floor){
		this.floor = floor;
	}
	
	@Override
	public void select() throws Exception {
		
		Console console = new Console();
		
		String in = console.read(selectedMenu);
		
		if (in.equals("y")){
			takeCardEvent.invoke(new TextualViewEvent<>(this));
		}
	}

	
	
}
