package gioco.da.console.event;

import java.util.ArrayList;

public class EventHandler {
	private ArrayList<EventListener> eventListener;
	
	public EventHandler(){
		eventListener = new ArrayList<EventListener>();
		
	}
	
	public void attach (EventListener listener){
		eventListener.add(listener);
	}
	
	public void detach (EventListener listener){
		eventListener.remove(listener);
	}
	
	public void invoke (){
		for(EventListener e : eventListener)
			e.handle();
	}

}
