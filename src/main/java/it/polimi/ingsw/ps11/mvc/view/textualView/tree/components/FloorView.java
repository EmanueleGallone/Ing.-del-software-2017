package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualComponent;

public class FloorView extends TextualComponent{

	protected EventHandler<FloorView> floorSelectedEvent = new EventHandler<>();
	protected EventHandler<FloorView> printEvent = new EventHandler<>();
	
	private Floor floor;
	private Class<?> color;
	private int whichFloor;
	
	public FloorView() {
		super();
	}
	
	public FloorView(String id) {
		super(id);
	}
	
	public <T extends Tower> FloorView(String id, Class<T> color, int witchFloor) {
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
	
	public void selectedEvent(EventListener<FloorView> listener){
		this.floorSelectedEvent.attach(listener);
	}
	
	@Override
	public void print() {
		this.printEvent.invoke(this);
		Console console = new Console();
		String string = floor.getActionSpace().getResources().toString();
		String[] arr = string.split("\\.");
		
		//System.out.println(arr.length);
		
		if (arr.length > 1)
			console.print("Piano: " + (whichFloor+1) + " Risorsa: " + arr[arr.length-1]+ " value: " + floor.getActionSpace().getActionCost());
		else {
			console.print("Piano: " + (whichFloor+1) + "                     " + " value: " + floor.getActionSpace().getActionCost());	
		}
		
	}
	
	public void update(Floor floor){
		this.floor = floor;
	}

	public void printEvent(EventListener<FloorView> listener){
		printEvent.attach(listener);
	}

	@Override
	public void select() {
		floorSelectedEvent.invoke(this);
	}


}
