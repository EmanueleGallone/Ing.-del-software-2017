package it.polimi.ingsw.ps11.view.textualView.tree.components;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.tree.TextualComponent;

public class TextualFloorView extends TextualComponent{

	protected EventHandler<TextualFloorView> floorSelectedEvent = new EventHandler<>();
	protected EventHandler<TextualFloorView> printEvent = new EventHandler<>();
	
	private Floor floor;
	private Class<?> color;
	private int whichFloor;
	
	public TextualFloorView() {
		super();
	}
	
	public TextualFloorView(String id) {
		super(id);
	}
	
	public <T extends Tower> TextualFloorView(String id, Class<T> color, int witchFloor) {
		super(id);
		this.color = color;
		this.whichFloor = witchFloor;
	}
	
	public <T extends Tower> void setColor(Class<T> color) {
		this.color = color;
	}
	
	public <T extends Tower> Class<T> getColor() {
		return (Class<T>) color;
	}
	
	public int getWhichFloor() {
		return whichFloor;
	}
	
	public void setWhichFloor(int witchFloor) {
		this.whichFloor = witchFloor;
	}
	
	public void selectedEvent(EventListener<TextualFloorView> listener){
		this.floorSelectedEvent.attach(listener);
	}
	
	@Override
	public void print() {
		this.printEvent.invoke(this);
		TextualConsole console = new TextualConsole();
		String string = floor.getActionSpace().getResources().toString();
		String[] arr = string.split("\\.");
		
		//System.out.println(arr.length);
		
		if (arr.length > 1)
			console.println("Piano: " + (whichFloor+1) + " Risorsa: " + arr[arr.length-1]+ " value: " + floor.getActionSpace().getActionCost());
		else {
			console.println("Piano: " + (whichFloor+1) + "                     " + " value: " + floor.getActionSpace().getActionCost());	
		}
		
	}
	
	public void update(Floor floor){
		this.floor = floor;
	}

	public void printEvent(EventListener<TextualFloorView> listener){
		printEvent.attach(listener);
	}

	@Override
	public void select() {
		floorSelectedEvent.invoke(this);
	}


}
